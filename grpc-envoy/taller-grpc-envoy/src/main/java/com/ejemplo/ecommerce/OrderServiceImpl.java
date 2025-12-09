package com.ejemplo.ecommerce;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {

    // Simulación de Base de Datos
    private final Map<String, OrderResponse> orderRepository = new ConcurrentHashMap<>();

    @Override
    public void createOrder(CreateOrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        // Lógica de negocio: Calcular total y generar ID
        double total = request.getItemsList().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        String generatedId = UUID.randomUUID().toString();

        OrderResponse newOrder = OrderResponse.newBuilder()
                .setOrderId(generatedId)
                .setCustomerId(request.getCustomerId())
                .addAllItems(request.getItemsList()) // Copiar lista compleja
                .setStatus(OrderStatus.PENDING) // Asignar Enum por defecto
                .setTotalAmount(total)
                .build();

        // Guardar
        orderRepository.put(generatedId, newOrder);
        System.out.println("Orden creada: " + generatedId);

        // Responder
        responseObserver.onNext(newOrder);
        responseObserver.onCompleted();
    }

    @Override
    public void getOrder(GetOrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        String id = request.getOrderId();

        if (orderRepository.containsKey(id)) {
            responseObserver.onNext(orderRepository.get(id));
            responseObserver.onCompleted();
        } else {
            // Retornar un error gRPC específico.
            // Envoy traducirá Status.NOT_FOUND a HTTP 404 Not Found automáticamente.
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("La orden con ID " + id + " no existe.")
                    .asRuntimeException());
        }
    }
}