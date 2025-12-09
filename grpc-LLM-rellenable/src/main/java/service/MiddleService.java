package service;

import com.grpc.ej3.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

// Este servicio actúa como INTERMEDIARIO.
// 1. Recibe una petición de un Cliente.
// 2. Se conecta como cliente al "Servidor Final".
// 3. Devuelve la respuesta al Cliente original.
public class MiddleService extends AskServiceGrpc.AskServiceImplBase {

    // Stub bloqueante: El hilo se detendrá esperando la respuesta del servidor
    // final
    private final ResponseServiceGrpc.ResponseServiceBlockingStub stubFinal;

    public MiddleService() {
        // -------------------------------------------------------------------
        // EJERCICIO 1: CONFIGURAR EL CLIENTE gRPC
        // Este servicio necesita conectarse al 'FinalServer' que corre en el puerto
        // 50053.
        // -------------------------------------------------------------------

        System.out.println("Configurando conexión con el Servidor Final...");

        // TODO 1: Crea el Canal de comunicación (The Channel)
        // 1. Define la dirección y el puerto ("localhost", 50053).
        ManagedChannel channel = ManagedChannelBuilder
                .________("localhost", 50053)
                ._____________() //
                .build();

        // TODO 2: Crea el Stub (El objeto cliente)
        // Usa el método estático .newBlockingStub(channel) de la clase generada
        // ResponseServiceGrpc
        stubFinal = ResponseServiceGrpc.________________(channel);
    }

    @Override
    public void preguntar(Pregunta req, StreamObserver<Respuesta> obs) {

        System.out.println("[MiddleService] Recibida pregunta de Cliente: " + req.getMensaje());
        System.out.println("[MiddleService] Enviando pregunta a FinalServer...");

        // -------------------------------------------------------------------
        // EJERCICIO 2: LÓGICA DE PROXY (Pasar la bola)
        // -------------------------------------------------------------------

        // TODO 3: Llama al servicio final usando tu 'stubFinal'
        // El método del servicio final se llama 'responder(req)'
        Respuesta resp = stubFinal._________(req);

        System.out.println("[MiddleService] Recibida respuesta de FinalServer: " + resp.getMensaje());
        System.out.println("[MiddleService] Enviando respuesta a Cliente original...");

        // TODO 4: Envía la respuesta recibida hacia atrás (al cliente original)
        // Recuerda cerrar el stream al terminar.
        obs.______(resp);
        obs.____________();
    }
}