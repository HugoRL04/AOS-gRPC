package server;

import service.HelloService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HelloServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(50051)
                .addService(new HelloService())
                .build();

        System.out.println("Servidor gRPC iniciado en puerto 50051...");
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Apagando servidor gRPC");
            server.shutdown();
        }));

        server.awaitTermination();
    }
}

