package com.ejemplo.ecommerce;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// Extendemos de la clase base generada por el compilador de Protobuf
public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {

    // Simulación de Base de Datos
    private final Map<String, OrderResponse> orderRepository = new ConcurrentHashMap<>();

    // -----------------------------------------------------------------------
    // EJERCICIO 1: CREAR ORDEN
    // Mira el archivo .proto:
    // rpc CreateOrder (CreateOrderRequest) returns (OrderResponse)
    // -----------------------------------------------------------------------

    @Override
    // TODO 1: Rellena los tipos de datos en la cabecera basándote en el archivo
    // .proto
    public void createOrder(____________________ request, StreamObserver<____________________> responseObserver) {

        System.out.println("Recibida solicitud para crear orden del cliente: " + request.getCustomerId());

        // TODO 2: Cálculo del total (Te dejamos el stream preparado, completa el
        // mapToDouble)
        // Pista: item.getPrice() * item.getQuantity()
        double total = request.getItemsList().stream()
                .mapToDouble(item -> __________________________________________)
                .sum();

        // Generamos un ID simulado
        String generatedId = UUID.randomUUID().toString();

        // TODO 3: Construir la respuesta usando el patrón Builder
        // Pista: En Protobuf no se usa 'new', se usa .newBuilder()
        OrderResponse response = OrderResponse.newBuilder()
                .setOrderId(generatedId)
                .setCustomerId(request.getCustomerId())
                .addAllItems(request.getItemsList()) // Copiamos la lista tal cual
                .setStatus(OrderStatus.PENDING) // Estado inicial
                .setTotalAmount(__________) // Asigna la variable 'total' aquí
                .build();

        // Guardamos en "Base de datos"
        orderRepository.put(generatedId, response);

        // TODO 4: Enviar respuesta al cliente (gRPC)
        // 1. Envía el objeto 'response'
        // 2. Avisa de que has terminado la comunicación
        responseObserver.onNext(__________);
        responseObserver.____________();
    }

    // -----------------------------------------------------------------------
    // EJERCICIO 2: CONSULTAR ORDEN
    // Mira el archivo .proto:
    // rpc GetOrder (GetOrderRequest) returns (OrderResponse)
    // -----------------------------------------------------------------------

    @Override
    // TODO 5: Rellena los tipos de datos para la consulta
    public void getOrder(____________________ request, StreamObserver<____________________> responseObserver) {

        String idBuscado = request.getOrderId();

        if (orderRepository.containsKey(idBuscado)) {
            // CASO ÉXITO: La orden existe
            OrderResponse ordenEncontrada = orderRepository.get(idBuscado);

            // TODO 6: Devuelve la orden encontrada y cierra el stream
            responseObserver.____________________(ordenEncontrada);
            responseObserver.onCompleted();

        } else {
            // CASO ERROR: La orden no existe

            // TODO 7: Devolver un error formal de gRPC
            // Usa Status.NOT_FOUND.withDescription("...").asRuntimeException()
            responseObserver.onError(Status.______________
                    .withDescription("Orden no encontrada con ID: " + idBuscado)
                    .asRuntimeException());
        }
    }
}