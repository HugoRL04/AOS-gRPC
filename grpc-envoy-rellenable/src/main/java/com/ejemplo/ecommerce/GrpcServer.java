package com.ejemplo.ecommerce;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        // 1. Definimos el puerto
        int port = 9090;

        // -------------------------------------------------------------------
        // EJERCICIO 3: ARRANCAR EL SERVIDOR
        // -------------------------------------------------------------------

        System.out.println("Iniciando servidor...");

        // TODO 1: Configurar y Arrancar
        // - Usa ServerBuilder para el puerto.
        // - Registra tu implementación (OrderServiceImpl).
        // - Construye y arranca.

        Server server = ServerBuilder.forPort(port)
                .______________(new OrderServiceImpl()) // <--- Añade el servicio aquí
                .build()
                ._______(); // <--- Arranca el servidor aquí

        System.out.println("Servidor gRPC escuchando en el puerto " + port);

        // -------------------------------------------------------------------
        // EJERCICIO 4: EVITAR QUE EL PROGRAMA TERMINE
        // -------------------------------------------------------------------

        // TODO 2: Bloquear el hilo principal
        // Si no ponemos esto, el 'main' termina y el servidor se apaga al instante.
        // Necesitamos que espere a recibir la señal de terminar (ej. Ctrl+C).

        server.__________________();
    }
}