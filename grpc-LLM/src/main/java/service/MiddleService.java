package service;

import com.grpc.ej3.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class MiddleService extends AskServiceGrpc.AskServiceImplBase {

    private final ResponseServiceGrpc.ResponseServiceBlockingStub stubFinal;

    public MiddleService() {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        stubFinal = ResponseServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public void preguntar(Pregunta req, StreamObserver<Respuesta> obs) {

        System.out.println("[MiddleService] Recibida pregunta de Cliente: " + req.getMensaje());
        System.out.println("[MiddleService] Enviando pregunta a FinalServer...");

        Respuesta resp = stubFinal.responder(req);

        System.out.println("[MiddleService] Recibida respuesta a FinalServer: " + resp.getMensaje());
        System.out.println("[MiddleService] Enviando respuesta a Cliente...");

        obs.onNext(resp);
        obs.onCompleted();
    }
}
