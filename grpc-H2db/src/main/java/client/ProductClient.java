package client;

import com.grpc.ej5.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ProductClient {

    private final ManagedChannel channel;
    private final ProductServiceGrpc.ProductServiceBlockingStub blockingStub;
    private final ProductServiceGrpc.ProductServiceStub asyncStub;

    public ProductClient() {
        channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        blockingStub = ProductServiceGrpc.newBlockingStub(channel);
        asyncStub = ProductServiceGrpc.newStub(channel);
    }

    // 1. UNARY
    public void unary() {

        ProductIdRequest req = ProductIdRequest.newBuilder().setId(1).build();
        System.out.println("[CLIENT](UNARY) Enviando ID = " + req.getId());

        ProductResponse resp = blockingStub.getProductById(req);

        System.out.println("[SERVER](UNARY) Recibido producto:");
        System.out.println("   Nombre = " + resp.getName());
        System.out.println("   Precio = " + resp.getPrice());
    }


    // 2. SERVER STREAMING
    public void serverStreaming() {

        PriceRequest req = PriceRequest.newBuilder().setMaxPrice(50).build();
        System.out.println("[CLIENT](SERVERSTREAMING) Max price = " + req.getMaxPrice());

        System.out.println("[SERVER](SERVERSTREAMING) Productos recibidos:");

        blockingStub.streamCheaperProducts(req).forEachRemaining(
                p -> System.out.println("   → " + p.getName() + " | " + p.getPrice())
        );
    }


    // 3. CLIENT STREAMING
    public void clientStreaming() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<InsertSummary> respObs = new StreamObserver<>() {
            public void onNext(InsertSummary s) {
                System.out.println("[SERVER](CLIENTSTREAMING) Insertados total = " + s.getInsertedCount());
            }
            public void onError(Throwable t) { latch.countDown(); }
            public void onCompleted() { latch.countDown(); }
        };

        StreamObserver<NewProductRequest> reqStream = asyncStub.insertProducts(respObs);

        // ENVÍO 1
        NewProductRequest p1 = NewProductRequest.newBuilder()
                .setName("Mesa gaming").setPrice(120).build();
        System.out.println("[CLIENT](CLIENTSTREAMING) Enviando → " + p1.getName() + "con precio " + p1.getPrice());
        reqStream.onNext(p1);

        // ENVÍO 2
        NewProductRequest p2 = NewProductRequest.newBuilder()
                .setName("Monitor 27''").setPrice(199).build();
        System.out.println("[CLIENT](CLIENTSTREAMING) Enviando → " + p2.getName() + "con precio " + p2.getPrice());
        reqStream.onNext(p2);

        reqStream.onCompleted();
        latch.await();
    }


    // 4. BIDIRECTIONAL STREAMING
    public void bidiStreaming() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<ProductResponse> respObs = new StreamObserver<>() {

            public void onNext(ProductResponse p) {
                System.out.println("[SERVER](BIDIRECTIONAL) Producto → " + p.getName() + " | " + p.getPrice());
            }

            public void onError(Throwable t) { latch.countDown(); }

            public void onCompleted() {
                System.out.println("[SERVER](BIDIRECTIONAL) Fin del stream");
                latch.countDown();
            }
        };

        StreamObserver<PriceRequest> reqStream = asyncStub.livePriceQuery(respObs);

        PriceRequest r1 = PriceRequest.newBuilder().setMaxPrice(20).build();
        System.out.println("[CLIENT](BIDIRECTIONAL) MaxPrice enviado = " + r1.getMaxPrice());
        reqStream.onNext(r1);
        Thread.sleep(500);

        PriceRequest r2 = PriceRequest.newBuilder().setMaxPrice(60).build();
        System.out.println("[CLIENT] (BIDIRECTIONAL) MaxPrice enviado = " + r2.getMaxPrice());
        reqStream.onNext(r2);
        Thread.sleep(500);

        PriceRequest r3 = PriceRequest.newBuilder().setMaxPrice(200).build();
        System.out.println("[CLIENT](BIDIRECTIONAL) MaxPrice enviado = " + r3.getMaxPrice());
        reqStream.onNext(r3);

        reqStream.onCompleted();
        latch.await();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        ProductClient c = new ProductClient();
        c.unary();
        c.serverStreaming();
        c.clientStreaming();
        c.bidiStreaming();
        c.shutdown();
    }
}
