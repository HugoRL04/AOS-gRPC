package service;

import com.grpc.ej1.HelloRequest;
import com.grpc.ej1.HelloResponse;
import com.grpc.ej1.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    // -----------------------------
    // 1) UNARY
    // -----------------------------
    @Override
    public void unaryHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        System.out.println("[Unary] Recibido mensaje de: " + request.getName());

        String msg = "Hola " + request.getName();
        HelloResponse resp = HelloResponse.newBuilder().setMessage(msg).build();

        System.out.println("[Unary] Enviado mensaje -> " + msg);

        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }


    // -----------------------------
    // 2) SERVER STREAMING
    // -----------------------------
    @Override
    public void serverStreamHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        System.out.println("[ServerStreaming] Recibido mensaje de: " + request.getName());

        String name = request.getName();

        String[] mensajes = {
                "Hola " + name + ", bienvenido!",
                "Este es un ejemplo de Server Streaming.",
                "El servidor envía varios mensajes.",
                "Fin del streaming."
        };

        try {
            for (String m : mensajes) {
                HelloResponse resp = HelloResponse.newBuilder().setMessage(m).build();
                responseObserver.onNext(resp);
                System.out.println("[ServerStreaming] Enviado mensaje -> " + m);
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        responseObserver.onCompleted();
    }


    // -----------------------------
    // 3) CLIENT STREAMING
    // -----------------------------
    @Override
    public StreamObserver<HelloRequest> clientStreamHello(StreamObserver<HelloResponse> responseObserver) {

        return new StreamObserver<HelloRequest>() {

            StringBuilder builder = new StringBuilder();

            @Override
            public void onNext(HelloRequest req) {
                System.out.println("[ClientStreaming] Recibido mesnsaje de: " + req.getName());
                if (builder.length() > 0) builder.append(", ");
                builder.append(req.getName());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error en ClientStreamHello: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                String msgFinal = "Saludos a: " + builder.toString();
                System.out.println("[ClientStreaming] Enviando respuesta final: " + msgFinal);

                HelloResponse resp = HelloResponse.newBuilder()
                        .setMessage(msgFinal)
                        .build();
                responseObserver.onNext(resp);
                responseObserver.onCompleted();
            }
        };
    }


    // -----------------------------
    // 4) BIDIRECTIONAL STREAMING
    // -----------------------------
    @Override
    public StreamObserver<HelloRequest> bidirectionalHello(StreamObserver<HelloResponse> responseObserver) {

        return new StreamObserver<HelloRequest>() {

            @Override
            public void onNext(HelloRequest req) {

                System.out.println("[BidirectionalStreaming] Recibido mensaje: " + req.getName());

                String msg = "Recibido mensaje: " + req.getName();
                HelloResponse resp = HelloResponse.newBuilder()
                        .setMessage(msg)
                        .build();

                System.out.println("[BidirectionalStreaming] Enviando mensaje -> " + msg);

                responseObserver.onNext(resp);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error en BidirectionalHello: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}