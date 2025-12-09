package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.MiddleService;
import java.util.concurrent.TimeUnit;

public class MiddleServer {

    public static void main(String[] args) throws Exception {

        Server server = ServerBuilder.forPort(50052)
                .addService(new MiddleService())
                .build();

        System.out.println("MiddleServer escuchando en puerto 50052...");
        server.start();
        server.awaitTermination(240, TimeUnit.SECONDS);
    }
}
