package com.grpc.ej1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: hello.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HelloServiceGrpc {

  private HelloServiceGrpc() {}

  public static final String SERVICE_NAME = "HelloService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest,
      com.grpc.ej1.HelloResponse> getUnaryHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unaryHello",
      requestType = com.grpc.ej1.HelloRequest.class,
      responseType = com.grpc.ej1.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest,
      com.grpc.ej1.HelloResponse> getUnaryHelloMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest, com.grpc.ej1.HelloResponse> getUnaryHelloMethod;
    if ((getUnaryHelloMethod = HelloServiceGrpc.getUnaryHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getUnaryHelloMethod = HelloServiceGrpc.getUnaryHelloMethod) == null) {
          HelloServiceGrpc.getUnaryHelloMethod = getUnaryHelloMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej1.HelloRequest, com.grpc.ej1.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "unaryHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej1.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej1.HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("unaryHello"))
              .build();
        }
      }
    }
    return getUnaryHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest,
      com.grpc.ej1.HelloResponse> getServerStreamHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "serverStreamHello",
      requestType = com.grpc.ej1.HelloRequest.class,
      responseType = com.grpc.ej1.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest,
      com.grpc.ej1.HelloResponse> getServerStreamHelloMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest, com.grpc.ej1.HelloResponse> getServerStreamHelloMethod;
    if ((getServerStreamHelloMethod = HelloServiceGrpc.getServerStreamHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getServerStreamHelloMethod = HelloServiceGrpc.getServerStreamHelloMethod) == null) {
          HelloServiceGrpc.getServerStreamHelloMethod = getServerStreamHelloMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej1.HelloRequest, com.grpc.ej1.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "serverStreamHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej1.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej1.HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("serverStreamHello"))
              .build();
        }
      }
    }
    return getServerStreamHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest,
      com.grpc.ej1.HelloResponse> getClientStreamHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "clientStreamHello",
      requestType = com.grpc.ej1.HelloRequest.class,
      responseType = com.grpc.ej1.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest,
      com.grpc.ej1.HelloResponse> getClientStreamHelloMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest, com.grpc.ej1.HelloResponse> getClientStreamHelloMethod;
    if ((getClientStreamHelloMethod = HelloServiceGrpc.getClientStreamHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getClientStreamHelloMethod = HelloServiceGrpc.getClientStreamHelloMethod) == null) {
          HelloServiceGrpc.getClientStreamHelloMethod = getClientStreamHelloMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej1.HelloRequest, com.grpc.ej1.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "clientStreamHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej1.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej1.HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("clientStreamHello"))
              .build();
        }
      }
    }
    return getClientStreamHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest,
      com.grpc.ej1.HelloResponse> getBidirectionalHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bidirectionalHello",
      requestType = com.grpc.ej1.HelloRequest.class,
      responseType = com.grpc.ej1.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest,
      com.grpc.ej1.HelloResponse> getBidirectionalHelloMethod() {
    io.grpc.MethodDescriptor<com.grpc.ej1.HelloRequest, com.grpc.ej1.HelloResponse> getBidirectionalHelloMethod;
    if ((getBidirectionalHelloMethod = HelloServiceGrpc.getBidirectionalHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getBidirectionalHelloMethod = HelloServiceGrpc.getBidirectionalHelloMethod) == null) {
          HelloServiceGrpc.getBidirectionalHelloMethod = getBidirectionalHelloMethod =
              io.grpc.MethodDescriptor.<com.grpc.ej1.HelloRequest, com.grpc.ej1.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "bidirectionalHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej1.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ej1.HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("bidirectionalHello"))
              .build();
        }
      }
    }
    return getBidirectionalHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloServiceStub>() {
        @java.lang.Override
        public HelloServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloServiceStub(channel, callOptions);
        }
      };
    return HelloServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloServiceBlockingStub>() {
        @java.lang.Override
        public HelloServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloServiceBlockingStub(channel, callOptions);
        }
      };
    return HelloServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloServiceFutureStub>() {
        @java.lang.Override
        public HelloServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloServiceFutureStub(channel, callOptions);
        }
      };
    return HelloServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * UNARY
     * </pre>
     */
    default void unaryHello(com.grpc.ej1.HelloRequest request,
        io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnaryHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     * SERVER STREAMING
     * </pre>
     */
    default void serverStreamHello(com.grpc.ej1.HelloRequest request,
        io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerStreamHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     * CLIENT STREAMING
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.grpc.ej1.HelloRequest> clientStreamHello(
        io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getClientStreamHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     * BIDIRECTIONAL STREAMING
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.grpc.ej1.HelloRequest> bidirectionalHello(
        io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBidirectionalHelloMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HelloService.
   */
  public static abstract class HelloServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HelloServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HelloService.
   */
  public static final class HelloServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HelloServiceStub> {
    private HelloServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY
     * </pre>
     */
    public void unaryHello(com.grpc.ej1.HelloRequest request,
        io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnaryHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * SERVER STREAMING
     * </pre>
     */
    public void serverStreamHello(com.grpc.ej1.HelloRequest request,
        io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getServerStreamHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * CLIENT STREAMING
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.grpc.ej1.HelloRequest> clientStreamHello(
        io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getClientStreamHelloMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * BIDIRECTIONAL STREAMING
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.grpc.ej1.HelloRequest> bidirectionalHello(
        io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBidirectionalHelloMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HelloService.
   */
  public static final class HelloServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HelloServiceBlockingStub> {
    private HelloServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY
     * </pre>
     */
    public com.grpc.ej1.HelloResponse unaryHello(com.grpc.ej1.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnaryHelloMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * SERVER STREAMING
     * </pre>
     */
    public java.util.Iterator<com.grpc.ej1.HelloResponse> serverStreamHello(
        com.grpc.ej1.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getServerStreamHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HelloService.
   */
  public static final class HelloServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HelloServiceFutureStub> {
    private HelloServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.ej1.HelloResponse> unaryHello(
        com.grpc.ej1.HelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnaryHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNARY_HELLO = 0;
  private static final int METHODID_SERVER_STREAM_HELLO = 1;
  private static final int METHODID_CLIENT_STREAM_HELLO = 2;
  private static final int METHODID_BIDIRECTIONAL_HELLO = 3;

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
        case METHODID_UNARY_HELLO:
          serviceImpl.unaryHello((com.grpc.ej1.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAM_HELLO:
          serviceImpl.serverStreamHello((com.grpc.ej1.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse>) responseObserver);
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
        case METHODID_CLIENT_STREAM_HELLO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStreamHello(
              (io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse>) responseObserver);
        case METHODID_BIDIRECTIONAL_HELLO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidirectionalHello(
              (io.grpc.stub.StreamObserver<com.grpc.ej1.HelloResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getUnaryHelloMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grpc.ej1.HelloRequest,
              com.grpc.ej1.HelloResponse>(
                service, METHODID_UNARY_HELLO)))
        .addMethod(
          getServerStreamHelloMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.grpc.ej1.HelloRequest,
              com.grpc.ej1.HelloResponse>(
                service, METHODID_SERVER_STREAM_HELLO)))
        .addMethod(
          getClientStreamHelloMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.grpc.ej1.HelloRequest,
              com.grpc.ej1.HelloResponse>(
                service, METHODID_CLIENT_STREAM_HELLO)))
        .addMethod(
          getBidirectionalHelloMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.grpc.ej1.HelloRequest,
              com.grpc.ej1.HelloResponse>(
                service, METHODID_BIDIRECTIONAL_HELLO)))
        .build();
  }

  private static abstract class HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.ej1.HelloProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloService");
    }
  }

  private static final class HelloServiceFileDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier {
    HelloServiceFileDescriptorSupplier() {}
  }

  private static final class HelloServiceMethodDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HelloServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloServiceFileDescriptorSupplier())
              .addMethod(getUnaryHelloMethod())
              .addMethod(getServerStreamHelloMethod())
              .addMethod(getClientStreamHelloMethod())
              .addMethod(getBidirectionalHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
