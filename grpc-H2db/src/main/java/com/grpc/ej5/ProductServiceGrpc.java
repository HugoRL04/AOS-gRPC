package com.grpc.ej5;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: product.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductServiceGrpc {

  private ProductServiceGrpc() {}

  public static final String SERVICE_NAME = "ProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.ej5.ProductIdRequest,
      com.grpc.ej5.ProductResponse> getGetProductByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProductById",
      requestType = com.grpc.ej5.ProductIdRequest.class,
      responseType = com.grpc.ej5.ProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.ej5.ProductIdRequest,
      com.grpc.ej5.ProductResponse> getGetProductByIdMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej5.ProductIdRequest, com.grpc.ej5.ProductResponse> getGetProductByIdMethod;
    if ((getGetProductByIdMethod = ProductServiceGrpc.getGetProductByIdMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getGetProductByIdMethod = ProductServiceGrpc.getGetProductByIdMethod) == null) {
          ProductServiceGrpc.getGetProductByIdMethod = getGetProductByIdMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej5.ProductIdRequest, com.grpc.ej5.ProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProductById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej5.ProductIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej5.ProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("GetProductById"))
              .build();
        }
      }
    }
    return getGetProductByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.ej5.PriceRequest,
      com.grpc.ej5.ProductResponse> getStreamCheaperProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCheaperProducts",
      requestType = com.grpc.ej5.PriceRequest.class,
      responseType = com.grpc.ej5.ProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.ej5.PriceRequest,
      com.grpc.ej5.ProductResponse> getStreamCheaperProductsMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej5.PriceRequest, com.grpc.ej5.ProductResponse> getStreamCheaperProductsMethod;
    if ((getStreamCheaperProductsMethod = ProductServiceGrpc.getStreamCheaperProductsMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getStreamCheaperProductsMethod = ProductServiceGrpc.getStreamCheaperProductsMethod) == null) {
          ProductServiceGrpc.getStreamCheaperProductsMethod = getStreamCheaperProductsMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej5.PriceRequest, com.grpc.ej5.ProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamCheaperProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej5.PriceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej5.ProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("StreamCheaperProducts"))
              .build();
        }
      }
    }
    return getStreamCheaperProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.ej5.NewProductRequest,
      com.grpc.ej5.InsertSummary> getInsertProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertProducts",
      requestType = com.grpc.ej5.NewProductRequest.class,
      responseType = com.grpc.ej5.InsertSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.ej5.NewProductRequest,
      com.grpc.ej5.InsertSummary> getInsertProductsMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej5.NewProductRequest, com.grpc.ej5.InsertSummary> getInsertProductsMethod;
    if ((getInsertProductsMethod = ProductServiceGrpc.getInsertProductsMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getInsertProductsMethod = ProductServiceGrpc.getInsertProductsMethod) == null) {
          ProductServiceGrpc.getInsertProductsMethod = getInsertProductsMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej5.NewProductRequest, com.grpc.ej5.InsertSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej5.NewProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej5.InsertSummary.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("InsertProducts"))
              .build();
        }
      }
    }
    return getInsertProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.ej5.PriceRequest,
      com.grpc.ej5.ProductResponse> getLivePriceQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LivePriceQuery",
      requestType = com.grpc.ej5.PriceRequest.class,
      responseType = com.grpc.ej5.ProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.ej5.PriceRequest,
      com.grpc.ej5.ProductResponse> getLivePriceQueryMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej5.PriceRequest, com.grpc.ej5.ProductResponse> getLivePriceQueryMethod;
    if ((getLivePriceQueryMethod = ProductServiceGrpc.getLivePriceQueryMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getLivePriceQueryMethod = ProductServiceGrpc.getLivePriceQueryMethod) == null) {
          ProductServiceGrpc.getLivePriceQueryMethod = getLivePriceQueryMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej5.PriceRequest, com.grpc.ej5.ProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LivePriceQuery"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej5.PriceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej5.ProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("LivePriceQuery"))
              .build();
        }
      }
    }
    return getLivePriceQueryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub>() {
        @java.lang.Override
        public ProductServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceStub(channel, callOptions);
        }
      };
    return ProductServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub>() {
        @java.lang.Override
        public ProductServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub>() {
        @java.lang.Override
        public ProductServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceFutureStub(channel, callOptions);
        }
      };
    return ProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * 1. UNARY: Obtener producto por ID
     * </pre>
     */
    default void getProductById(com.grpc.ej5.ProductIdRequest request,
        io.grpc.stub.StreamObserver<com.grpc.ej5.ProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     * 2. SERVER STREAMING: Productos más baratos que un precio
     * </pre>
     */
    default void streamCheaperProducts(com.grpc.ej5.PriceRequest request,
        io.grpc.stub.StreamObserver<com.grpc.ej5.ProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCheaperProductsMethod(), responseObserver);
    }

    /**
     * <pre>
     * 3. CLIENT STREAMING: Insertar varios productos
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.grpc.ej5.NewProductRequest> insertProducts(
        io.grpc.stub.StreamObserver<com.grpc.ej5.InsertSummary> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getInsertProductsMethod(), responseObserver);
    }

    /**
     * <pre>
     * 4. BIDIRECTIONAL STREAMING: Consultas dinámicas de precio
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.grpc.ej5.PriceRequest> livePriceQuery(
        io.grpc.stub.StreamObserver<com.grpc.ej5.ProductResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getLivePriceQueryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductService.
   */
  public static abstract class ProductServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductService.
   */
  public static final class ProductServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductServiceStub> {
    private ProductServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. UNARY: Obtener producto por ID
     * </pre>
     */
    public void getProductById(com.grpc.ej5.ProductIdRequest request,
        io.grpc.stub.StreamObserver<com.grpc.ej5.ProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 2. SERVER STREAMING: Productos más baratos que un precio
     * </pre>
     */
    public void streamCheaperProducts(com.grpc.ej5.PriceRequest request,
        io.grpc.stub.StreamObserver<com.grpc.ej5.ProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCheaperProductsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 3. CLIENT STREAMING: Insertar varios productos
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.grpc.ej5.NewProductRequest> insertProducts(
        io.grpc.stub.StreamObserver<com.grpc.ej5.InsertSummary> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getInsertProductsMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 4. BIDIRECTIONAL STREAMING: Consultas dinámicas de precio
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.grpc.ej5.PriceRequest> livePriceQuery(
        io.grpc.stub.StreamObserver<com.grpc.ej5.ProductResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getLivePriceQueryMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductService.
   */
  public static final class ProductServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductServiceBlockingStub> {
    private ProductServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. UNARY: Obtener producto por ID
     * </pre>
     */
    public com.grpc.ej5.ProductResponse getProductById(com.grpc.ej5.ProductIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 2. SERVER STREAMING: Productos más baratos que un precio
     * </pre>
     */
    public java.util.Iterator<com.grpc.ej5.ProductResponse> streamCheaperProducts(
        com.grpc.ej5.PriceRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCheaperProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductService.
   */
  public static final class ProductServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductServiceFutureStub> {
    private ProductServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. UNARY: Obtener producto por ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.ej5.ProductResponse> getProductById(
        com.grpc.ej5.ProductIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PRODUCT_BY_ID = 0;
  private static final int METHODID_STREAM_CHEAPER_PRODUCTS = 1;
  private static final int METHODID_INSERT_PRODUCTS = 2;
  private static final int METHODID_LIVE_PRICE_QUERY = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PRODUCT_BY_ID:
          serviceImpl.getProductById((com.grpc.ej5.ProductIdRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.ej5.ProductResponse>) responseObserver);
          break;
        case METHODID_STREAM_CHEAPER_PRODUCTS:
          serviceImpl.streamCheaperProducts((com.grpc.ej5.PriceRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.ej5.ProductResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INSERT_PRODUCTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.insertProducts(
              (io.grpc.stub.StreamObserver<com.grpc.ej5.InsertSummary>) responseObserver);
        case METHODID_LIVE_PRICE_QUERY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.livePriceQuery(
              (io.grpc.stub.StreamObserver<com.grpc.ej5.ProductResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetProductByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grpc.ej5.ProductIdRequest,
              com.grpc.ej5.ProductResponse>(
                service, METHODID_GET_PRODUCT_BY_ID)))
        .addMethod(
          getStreamCheaperProductsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.grpc.ej5.PriceRequest,
              com.grpc.ej5.ProductResponse>(
                service, METHODID_STREAM_CHEAPER_PRODUCTS)))
        .addMethod(
          getInsertProductsMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.grpc.ej5.NewProductRequest,
              com.grpc.ej5.InsertSummary>(
                service, METHODID_INSERT_PRODUCTS)))
        .addMethod(
          getLivePriceQueryMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.grpc.ej5.PriceRequest,
              com.grpc.ej5.ProductResponse>(
                service, METHODID_LIVE_PRICE_QUERY)))
        .build();
  }

  private static abstract class ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.ej5.ProductProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductService");
    }
  }

  private static final class ProductServiceFileDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier {
    ProductServiceFileDescriptorSupplier() {}
  }

  private static final class ProductServiceMethodDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductServiceFileDescriptorSupplier())
              .addMethod(getGetProductByIdMethod())
              .addMethod(getStreamCheaperProductsMethod())
              .addMethod(getInsertProductsMethod())
              .addMethod(getLivePriceQueryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
