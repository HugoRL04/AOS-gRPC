package server;

import db.H2Database;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.ProductService;

public class ProductServer {

    public static void main(String[] args) throws Exception {

        H2Database.init();

        Server server = ServerBuilder
                .forPort(50051)
                .addService(new ProductService())
                .build();

        server.start();
        System.out.println("Servidor gRPC con H2 ejecutándose en puerto 50051...");

        server.awaitTermination();
    }
}
