package com.grpc.ej3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *  SERVICIO 2 (Final)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: ask.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ResponseServiceGrpc {

  private ResponseServiceGrpc() {}

  public static final String SERVICE_NAME = "ResponseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.ej3.Pregunta,
      com.grpc.ej3.Respuesta> getResponderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "responder",
      requestType = com.grpc.ej3.Pregunta.class,
      responseType = com.grpc.ej3.Respuesta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.ej3.Pregunta,
      com.grpc.ej3.Respuesta> getResponderMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej3.Pregunta, com.grpc.ej3.Respuesta> getResponderMethod;
    if ((getResponderMethod = ResponseServiceGrpc.getResponderMethod) == null) {
      synchronized (ResponseServiceGrpc.class) {
        if ((getResponderMethod = ResponseServiceGrpc.getResponderMethod) == null) {
          ResponseServiceGrpc.getResponderMethod = getResponderMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej3.Pregunta, com.grpc.ej3.Respuesta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "responder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej3.Pregunta.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej3.Respuesta.getDefaultInstance()))
              .setSchemaDescriptor(new ResponseServiceMethodDescriptorSupplier("responder"))
              .build();
        }
      }
    }
    return getResponderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ResponseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResponseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ResponseServiceStub>() {
        @java.lang.Override
        public ResponseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ResponseServiceStub(channel, callOptions);
        }
      };
    return ResponseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ResponseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResponseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ResponseServiceBlockingStub>() {
        @java.lang.Override
        public ResponseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ResponseServiceBlockingStub(channel, callOptions);
        }
      };
    return ResponseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ResponseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResponseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ResponseServiceFutureStub>() {
        @java.lang.Override
        public ResponseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ResponseServiceFutureStub(channel, callOptions);
        }
      };
    return ResponseServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *  SERVICIO 2 (Final)
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void responder(com.grpc.ej3.Pregunta request,
        io.grpc.stub.StreamObserver<com.grpc.ej3.Respuesta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResponderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ResponseService.
   * <pre>
   *  SERVICIO 2 (Final)
   * </pre>
   */
  public static abstract class ResponseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ResponseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ResponseService.
   * <pre>
   *  SERVICIO 2 (Final)
   * </pre>
   */
  public static final class ResponseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ResponseServiceStub> {
    private ResponseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResponseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResponseServiceStub(channel, callOptions);
    }

    /**
     */
    public void responder(com.grpc.ej3.Pregunta request,
        io.grpc.stub.StreamObserver<com.grpc.ej3.Respuesta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResponderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ResponseService.
   * <pre>
   *  SERVICIO 2 (Final)
   * </pre>
   */
  public static final class ResponseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ResponseServiceBlockingStub> {
    private ResponseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResponseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResponseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.ej3.Respuesta responder(com.grpc.ej3.Pregunta request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResponderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ResponseService.
   * <pre>
   *  SERVICIO 2 (Final)
   * </pre>
   */
  public static final class ResponseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ResponseServiceFutureStub> {
    private ResponseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResponseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResponseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.ej3.Respuesta> responder(
        com.grpc.ej3.Pregunta request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResponderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESPONDER = 0;

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
        case METHODID_RESPONDER:
          serviceImpl.responder((com.grpc.ej3.Pregunta) request,
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
          getResponderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grpc.ej3.Pregunta,
              com.grpc.ej3.Respuesta>(
                service, METHODID_RESPONDER)))
        .build();
  }

  private static abstract class ResponseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ResponseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.ej3.AskProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ResponseService");
    }
  }

  private static final class ResponseServiceFileDescriptorSupplier
      extends ResponseServiceBaseDescriptorSupplier {
    ResponseServiceFileDescriptorSupplier() {}
  }

  private static final class ResponseServiceMethodDescriptorSupplier
      extends ResponseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ResponseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ResponseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ResponseServiceFileDescriptorSupplier())
              .addMethod(getResponderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
