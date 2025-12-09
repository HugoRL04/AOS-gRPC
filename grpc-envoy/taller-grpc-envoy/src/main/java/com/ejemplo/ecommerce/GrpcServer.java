package com.ejemplo.ecommerce;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 9090;

        // Construye e inicia el servidor gRPC.
        server = ServerBuilder.forPort(port)
                .addService(new OrderServiceImpl()) // Registra la implementación del servicio.
                .build()
                .start();

        System.out.println("Servidor gRPC iniciado en el puerto " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Hook para un apagado ordenado (ej. al recibir Ctrl+C).
            System.err.println("*** Apagando servidor gRPC porque la JVM se está cerrando");
            try {
                GrpcServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** Servidor apagado");
        }));
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Espera a que el hilo principal termine (esto mantiene la app viva).
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }
}