package client;

import com.grpc.ej1.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HelloClient {

    private final ManagedChannel channel;
    private final HelloServiceGrpc.HelloServiceBlockingStub blockingStub;
    private final HelloServiceGrpc.HelloServiceStub asyncStub;

    public HelloClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        blockingStub = HelloServiceGrpc.newBlockingStub(channel);
        asyncStub = HelloServiceGrpc.newStub(channel);
    }

    // -----------------------
    // UNARY
    // -----------------------
    public void testUnary() {
        String msg = "Hugo";
        System.out.println("[Client] Enviando mensaje: " + msg);
        HelloRequest req = HelloRequest.newBuilder().setName(msg).build();
        HelloResponse resp = blockingStub.unaryHello(req);
        System.out.println("[Unary] Respuesta del servidor -> " + resp.getMessage());
    }

    // -----------------------
    // SERVER STREAMING
    // -----------------------
    public void testServerStreaming() {
        String msg = "Hugo";
        System.out.println("[Client] Enviando mensaje: " + msg);
        HelloRequest req = HelloRequest.newBuilder().setName(msg).build();
        Iterator<HelloResponse> it = blockingStub.serverStreamHello(req);

        System.out.println("[ServerStreaming] Respuestas del servidor ->");
        while (it.hasNext()) {
            System.out.println(" -> " + it.next().getMessage());
        }
    }

    // -----------------------
    // CLIENT STREAMING
    // -----------------------
    public void testClientStreaming() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<HelloResponse> responseObserver = new StreamObserver<HelloResponse>() {
            @Override
            public void onNext(HelloResponse value) {
                System.out.println("[ClientStreaming] Respuesta del servidor -> " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        };

        String msg1 = "Luis";
        String msg2 = "Carlos";
        String msg3 = "María";
        System.out.println("[Client] Enviando mensajes: " + msg1 + ", " + msg2 + ", " + msg3);

        StreamObserver<HelloRequest> requestObserver =
                asyncStub.clientStreamHello(responseObserver);

        requestObserver.onNext(HelloRequest.newBuilder().setName(msg1).build());
        requestObserver.onNext(HelloRequest.newBuilder().setName(msg2).build());
        requestObserver.onNext(HelloRequest.newBuilder().setName(msg3).build());

        requestObserver.onCompleted();

        latch.await();
    }

    // -----------------------
    // BIDIRECTIONAL STREAMING
    // -----------------------
    public void testBidirectionalStreaming() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<HelloResponse> responseObserver = new StreamObserver<HelloResponse>() {
            @Override
            public void onNext(HelloResponse value) {
                System.out.println("[BidirectionalStreaming] Respuesta del servidor -> " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        };

        StreamObserver<HelloRequest> requestObserver =
                asyncStub.bidirectionalHello(responseObserver);

        String[] mensajes = {"Hola", "¿Qué tal?", "Probando bidirecional", "Adiós"};

        System.out.println("[Client] Enviando mensajes: " + String.join(", ", mensajes));

        for (String m : mensajes) {
            requestObserver.onNext(HelloRequest.newBuilder().setName(m).build());
            Thread.sleep(300);
        }

        requestObserver.onCompleted();
        latch.await();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        HelloClient client = new HelloClient("localhost", 50051);

        client.testUnary();
        client.testServerStreaming();
        client.testClientStreaming();
        client.testBidirectionalStreaming();

        client.shutdown();
    }
}
