package com.grpc.ej3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *  SERVICIO 1 (Middle)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: ask.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AskServiceGrpc {

  private AskServiceGrpc() {}

  public static final String SERVICE_NAME = "AskService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.ej3.Pregunta,
      com.grpc.ej3.Respuesta> getPreguntarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "preguntar",
      requestType = com.grpc.ej3.Pregunta.class,
      responseType = com.grpc.ej3.Respuesta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.ej3.Pregunta,
      com.grpc.ej3.Respuesta> getPreguntarMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej3.Pregunta, com.grpc.ej3.Respuesta> getPreguntarMethod;
    if ((getPreguntarMethod = AskServiceGrpc.getPreguntarMethod) == null) {
      synchronized (AskServiceGrpc.class) {
        if ((getPreguntarMethod = AskServiceGrpc.getPreguntarMethod) == null) {
          AskServiceGrpc.getPreguntarMethod = getPreguntarMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej3.Pregunta, com.grpc.ej3.Respuesta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "preguntar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej3.Pregunta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej3.Respuesta.getDefaultInstance()))
              .setSchemaDescriptor(new AskServiceMethodDescriptorSupplier("preguntar"))
              .build();
        }
      }
    }
    return getPreguntarMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AskServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AskServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AskServiceStub>() {
        @java.lang.Override
        public AskServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AskServiceStub(channel, callOptions);
        }
      };
    return AskServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AskServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AskServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AskServiceBlockingStub>() {
        @java.lang.Override
        public AskServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AskServiceBlockingStub(channel, callOptions);
        }
      };
    return AskServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AskServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AskServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AskServiceFutureStub>() {
        @java.lang.Override
        public AskServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AskServiceFutureStub(channel, callOptions);
        }
      };
    return AskServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *  SERVICIO 1 (Middle)
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void preguntar(com.grpc.ej3.Pregunta request,
        io.grpc.stub.StreamObserver<com.grpc.ej3.Respuesta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPreguntarMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AskService.
   * <pre>
   *  SERVICIO 1 (Middle)
   * </pre>
   */
  public static abstract class AskServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AskServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AskService.
   * <pre>
   *  SERVICIO 1 (Middle)
   * </pre>
   */
  public static final class AskServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AskServiceStub> {
    private AskServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AskServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AskServiceStub(channel, callOptions);
    }

    /**
     */
    public void preguntar(com.grpc.ej3.Pregunta request,
        io.grpc.stub.StreamObserver<com.grpc.ej3.Respuesta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPreguntarMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AskService.
   * <pre>
   *  SERVICIO 1 (Middle)
   * </pre>
   */
  public static final class AskServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AskServiceBlockingStub> {
    private AskServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AskServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AskServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.ej3.Respuesta preguntar(com.grpc.ej3.Pregunta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPreguntarMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AskService.
   * <pre>
   *  SERVICIO 1 (Middle)
   * </pre>
   */
  public static final class AskServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AskServiceFutureStub> {
    private AskServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AskServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AskServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.ej3.Respuesta> preguntar(
        com.grpc.ej3.Pregunta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPreguntarMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PREGUNTAR = 0;

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
        case METHODID_PREGUNTAR:
          serviceImpl.preguntar((com.grpc.ej3.Pregunta) request,
              (io.grpc.stub.StreamObserver<com.grpc.ej3.Respuesta>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPreguntarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grpc.ej3.Pregunta,
              com.grpc.ej3.Respuesta>(
                service, METHODID_PREGUNTAR)))
        .build();
  }

  private static abstract class AskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AskServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.ej3.AskProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AskService");
    }
  }

  private static final class AskServiceFileDescriptorSupplier
      extends AskServiceBaseDescriptorSupplier {
    AskServiceFileDescriptorSupplier() {}
  }

  private static final class AskServiceMethodDescriptorSupplier
      extends AskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AskServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AskServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AskServiceFileDescriptorSupplier())
              .addMethod(getPreguntarMethod())
              .build();
        }
      }
    }
    return result;
  }
}
