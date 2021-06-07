package com.learning.learning.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: ManagerOperationService.proto")
public final class ManagerOperationServiceGrpc {

  private ManagerOperationServiceGrpc() {}

  public static final String SERVICE_NAME = "com.learning.learning.grpc.ManagerOperationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.ManagerOperationRequest,
      com.learning.learning.grpc.ManagerOperationResponse> getPutNCStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putNCStatus",
      requestType = com.learning.learning.grpc.ManagerOperationRequest.class,
      responseType = com.learning.learning.grpc.ManagerOperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.ManagerOperationRequest,
      com.learning.learning.grpc.ManagerOperationResponse> getPutNCStatusMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.ManagerOperationRequest, com.learning.learning.grpc.ManagerOperationResponse> getPutNCStatusMethod;
    if ((getPutNCStatusMethod = ManagerOperationServiceGrpc.getPutNCStatusMethod) == null) {
      synchronized (ManagerOperationServiceGrpc.class) {
        if ((getPutNCStatusMethod = ManagerOperationServiceGrpc.getPutNCStatusMethod) == null) {
          ManagerOperationServiceGrpc.getPutNCStatusMethod = getPutNCStatusMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.ManagerOperationRequest, com.learning.learning.grpc.ManagerOperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putNCStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.ManagerOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.ManagerOperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManagerOperationServiceMethodDescriptorSupplier("putNCStatus"))
              .build();
        }
      }
    }
    return getPutNCStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.ManagerOperationRequest,
      com.learning.learning.grpc.ManagerOperationResponse> getPutScoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putScore",
      requestType = com.learning.learning.grpc.ManagerOperationRequest.class,
      responseType = com.learning.learning.grpc.ManagerOperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.ManagerOperationRequest,
      com.learning.learning.grpc.ManagerOperationResponse> getPutScoreMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.ManagerOperationRequest, com.learning.learning.grpc.ManagerOperationResponse> getPutScoreMethod;
    if ((getPutScoreMethod = ManagerOperationServiceGrpc.getPutScoreMethod) == null) {
      synchronized (ManagerOperationServiceGrpc.class) {
        if ((getPutScoreMethod = ManagerOperationServiceGrpc.getPutScoreMethod) == null) {
          ManagerOperationServiceGrpc.getPutScoreMethod = getPutScoreMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.ManagerOperationRequest, com.learning.learning.grpc.ManagerOperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putScore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.ManagerOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.ManagerOperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManagerOperationServiceMethodDescriptorSupplier("putScore"))
              .build();
        }
      }
    }
    return getPutScoreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ManagerOperationServiceStub newStub(io.grpc.Channel channel) {
    return new ManagerOperationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ManagerOperationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ManagerOperationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ManagerOperationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ManagerOperationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ManagerOperationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void putNCStatus(com.learning.learning.grpc.ManagerOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.ManagerOperationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPutNCStatusMethod(), responseObserver);
    }

    /**
     */
    public void putScore(com.learning.learning.grpc.ManagerOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.ManagerOperationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPutScoreMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPutNCStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.ManagerOperationRequest,
                com.learning.learning.grpc.ManagerOperationResponse>(
                  this, METHODID_PUT_NCSTATUS)))
          .addMethod(
            getPutScoreMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.ManagerOperationRequest,
                com.learning.learning.grpc.ManagerOperationResponse>(
                  this, METHODID_PUT_SCORE)))
          .build();
    }
  }

  /**
   */
  public static final class ManagerOperationServiceStub extends io.grpc.stub.AbstractStub<ManagerOperationServiceStub> {
    private ManagerOperationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ManagerOperationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagerOperationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ManagerOperationServiceStub(channel, callOptions);
    }

    /**
     */
    public void putNCStatus(com.learning.learning.grpc.ManagerOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.ManagerOperationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutNCStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putScore(com.learning.learning.grpc.ManagerOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.ManagerOperationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutScoreMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ManagerOperationServiceBlockingStub extends io.grpc.stub.AbstractStub<ManagerOperationServiceBlockingStub> {
    private ManagerOperationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ManagerOperationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagerOperationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ManagerOperationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.learning.learning.grpc.ManagerOperationResponse putNCStatus(com.learning.learning.grpc.ManagerOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getPutNCStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.learning.learning.grpc.ManagerOperationResponse putScore(com.learning.learning.grpc.ManagerOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getPutScoreMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ManagerOperationServiceFutureStub extends io.grpc.stub.AbstractStub<ManagerOperationServiceFutureStub> {
    private ManagerOperationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ManagerOperationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagerOperationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ManagerOperationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.ManagerOperationResponse> putNCStatus(
        com.learning.learning.grpc.ManagerOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPutNCStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.ManagerOperationResponse> putScore(
        com.learning.learning.grpc.ManagerOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPutScoreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PUT_NCSTATUS = 0;
  private static final int METHODID_PUT_SCORE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ManagerOperationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ManagerOperationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUT_NCSTATUS:
          serviceImpl.putNCStatus((com.learning.learning.grpc.ManagerOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.ManagerOperationResponse>) responseObserver);
          break;
        case METHODID_PUT_SCORE:
          serviceImpl.putScore((com.learning.learning.grpc.ManagerOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.ManagerOperationResponse>) responseObserver);
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

  private static abstract class ManagerOperationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManagerOperationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learning.learning.grpc.ManagerOperationServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ManagerOperationService");
    }
  }

  private static final class ManagerOperationServiceFileDescriptorSupplier
      extends ManagerOperationServiceBaseDescriptorSupplier {
    ManagerOperationServiceFileDescriptorSupplier() {}
  }

  private static final class ManagerOperationServiceMethodDescriptorSupplier
      extends ManagerOperationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ManagerOperationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ManagerOperationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ManagerOperationServiceFileDescriptorSupplier())
              .addMethod(getPutNCStatusMethod())
              .addMethod(getPutScoreMethod())
              .build();
        }
      }
    }
    return result;
  }
}
