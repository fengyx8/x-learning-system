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
    comments = "Source: SearchService.proto")
public final class CommunityLoggedServiceGrpc {

  private CommunityLoggedServiceGrpc() {}

  public static final String SERVICE_NAME = "com.learning.learning.grpc.CommunityLoggedService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.UserInfoRequest,
      com.learning.learning.grpc.UserInfoResponse> getGetUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUserInfo",
      requestType = com.learning.learning.grpc.UserInfoRequest.class,
      responseType = com.learning.learning.grpc.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.UserInfoRequest,
      com.learning.learning.grpc.UserInfoResponse> getGetUserInfoMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.UserInfoRequest, com.learning.learning.grpc.UserInfoResponse> getGetUserInfoMethod;
    if ((getGetUserInfoMethod = CommunityLoggedServiceGrpc.getGetUserInfoMethod) == null) {
      synchronized (CommunityLoggedServiceGrpc.class) {
        if ((getGetUserInfoMethod = CommunityLoggedServiceGrpc.getGetUserInfoMethod) == null) {
          CommunityLoggedServiceGrpc.getGetUserInfoMethod = getGetUserInfoMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.UserInfoRequest, com.learning.learning.grpc.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommunityLoggedServiceMethodDescriptorSupplier("getUserInfo"))
              .build();
        }
      }
    }
    return getGetUserInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommunityLoggedServiceStub newStub(io.grpc.Channel channel) {
    return new CommunityLoggedServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommunityLoggedServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CommunityLoggedServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommunityLoggedServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CommunityLoggedServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CommunityLoggedServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserInfo(com.learning.learning.grpc.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.UserInfoRequest,
                com.learning.learning.grpc.UserInfoResponse>(
                  this, METHODID_GET_USER_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class CommunityLoggedServiceStub extends io.grpc.stub.AbstractStub<CommunityLoggedServiceStub> {
    private CommunityLoggedServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunityLoggedServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunityLoggedServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunityLoggedServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUserInfo(com.learning.learning.grpc.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommunityLoggedServiceBlockingStub extends io.grpc.stub.AbstractStub<CommunityLoggedServiceBlockingStub> {
    private CommunityLoggedServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunityLoggedServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunityLoggedServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunityLoggedServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.learning.learning.grpc.UserInfoResponse getUserInfo(com.learning.learning.grpc.UserInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommunityLoggedServiceFutureStub extends io.grpc.stub.AbstractStub<CommunityLoggedServiceFutureStub> {
    private CommunityLoggedServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunityLoggedServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunityLoggedServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunityLoggedServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.UserInfoResponse> getUserInfo(
        com.learning.learning.grpc.UserInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommunityLoggedServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommunityLoggedServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_INFO:
          serviceImpl.getUserInfo((com.learning.learning.grpc.UserInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserInfoResponse>) responseObserver);
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

  private static abstract class CommunityLoggedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommunityLoggedServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learning.learning.grpc.SearchServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommunityLoggedService");
    }
  }

  private static final class CommunityLoggedServiceFileDescriptorSupplier
      extends CommunityLoggedServiceBaseDescriptorSupplier {
    CommunityLoggedServiceFileDescriptorSupplier() {}
  }

  private static final class CommunityLoggedServiceMethodDescriptorSupplier
      extends CommunityLoggedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommunityLoggedServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommunityLoggedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommunityLoggedServiceFileDescriptorSupplier())
              .addMethod(getGetUserInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
