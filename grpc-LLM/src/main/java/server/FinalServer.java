package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.FinalService;
import java.util.concurrent.TimeUnit;

public class FinalServer {

    public static void main(String[] args) throws Exception {

        Server server = ServerBuilder.forPort(50053)
                .addService(new FinalService())
                .build();

        System.out.println("FinalServer escuchando en puerto 50053...");
        server.start();
        server.awaitTermination(240, TimeUnit.SECONDS);
    }
}
