package client;

import com.grpc.ej3.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;

public class Client {

    private final AskServiceGrpc.AskServiceBlockingStub stub;
    private final ManagedChannel channel;

    public Client(String host, int port) {

        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        stub = AskServiceGrpc.newBlockingStub(channel);
    }

    /**
     * Método reutilizable para enviar una pregunta
     */
    public void enviarPregunta(String mensaje) {

        System.out.println("[Client] Enviando pregunta -> " + mensaje);

        Pregunta p = Pregunta.newBuilder()
                .setMensaje(mensaje)
                .build();

        Respuesta r = stub.preguntar(p);

        System.out.println("\n=== RESPUESTA DEL SERVIDOR ===");
        System.out.println(r.getMensaje());
        System.out.println("=======================\n");
    }

    /**
     * Cierra el canal gRPC
     */
    public void shutdown() {
        System.out.println("[Client] Cerrando canal...");
        channel.shutdown();
    }

    public static void main(String[] args) {

        Client c = new Client("localhost", 50052);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Escribe tu pregunta para el servidor gRPC: ");
        String pregunta = scanner.nextLine();

        c.enviarPregunta(pregunta);

        c.shutdown();
    }
}
