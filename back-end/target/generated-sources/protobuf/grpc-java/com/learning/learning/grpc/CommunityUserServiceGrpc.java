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
    comments = "Source: CommunityUserService.proto")
public final class CommunityUserServiceGrpc {

  private CommunityUserServiceGrpc() {}

  public static final String SERVICE_NAME = "com.learning.learning.grpc.CommunityUserService";

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
    if ((getGetUserInfoMethod = CommunityUserServiceGrpc.getGetUserInfoMethod) == null) {
      synchronized (CommunityUserServiceGrpc.class) {
        if ((getGetUserInfoMethod = CommunityUserServiceGrpc.getGetUserInfoMethod) == null) {
          CommunityUserServiceGrpc.getGetUserInfoMethod = getGetUserInfoMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.UserInfoRequest, com.learning.learning.grpc.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommunityUserServiceMethodDescriptorSupplier("getUserInfo"))
              .build();
        }
      }
    }
    return getGetUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.UserInfoRequest,
      com.learning.learning.grpc.UserInfoResponse> getGetAnsRecordsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAnsRecords",
      requestType = com.learning.learning.grpc.UserInfoRequest.class,
      responseType = com.learning.learning.grpc.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.UserInfoRequest,
      com.learning.learning.grpc.UserInfoResponse> getGetAnsRecordsMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.UserInfoRequest, com.learning.learning.grpc.UserInfoResponse> getGetAnsRecordsMethod;
    if ((getGetAnsRecordsMethod = CommunityUserServiceGrpc.getGetAnsRecordsMethod) == null) {
      synchronized (CommunityUserServiceGrpc.class) {
        if ((getGetAnsRecordsMethod = CommunityUserServiceGrpc.getGetAnsRecordsMethod) == null) {
          CommunityUserServiceGrpc.getGetAnsRecordsMethod = getGetAnsRecordsMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.UserInfoRequest, com.learning.learning.grpc.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAnsRecords"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommunityUserServiceMethodDescriptorSupplier("getAnsRecords"))
              .build();
        }
      }
    }
    return getGetAnsRecordsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommunityUserServiceStub newStub(io.grpc.Channel channel) {
    return new CommunityUserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommunityUserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CommunityUserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommunityUserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CommunityUserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CommunityUserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserInfo(com.learning.learning.grpc.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserInfoMethod(), responseObserver);
    }

    /**
     */
    public void getAnsRecords(com.learning.learning.grpc.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAnsRecordsMethod(), responseObserver);
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
          .addMethod(
            getGetAnsRecordsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.UserInfoRequest,
                com.learning.learning.grpc.UserInfoResponse>(
                  this, METHODID_GET_ANS_RECORDS)))
          .build();
    }
  }

  /**
   */
  public static final class CommunityUserServiceStub extends io.grpc.stub.AbstractStub<CommunityUserServiceStub> {
    private CommunityUserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunityUserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunityUserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunityUserServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUserInfo(com.learning.learning.grpc.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnsRecords(com.learning.learning.grpc.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAnsRecordsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommunityUserServiceBlockingStub extends io.grpc.stub.AbstractStub<CommunityUserServiceBlockingStub> {
    private CommunityUserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunityUserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunityUserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunityUserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.learning.learning.grpc.UserInfoResponse getUserInfo(com.learning.learning.grpc.UserInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.learning.learning.grpc.UserInfoResponse getAnsRecords(com.learning.learning.grpc.UserInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAnsRecordsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommunityUserServiceFutureStub extends io.grpc.stub.AbstractStub<CommunityUserServiceFutureStub> {
    private CommunityUserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunityUserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunityUserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunityUserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.UserInfoResponse> getUserInfo(
        com.learning.learning.grpc.UserInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.UserInfoResponse> getAnsRecords(
        com.learning.learning.grpc.UserInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAnsRecordsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_INFO = 0;
  private static final int METHODID_GET_ANS_RECORDS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommunityUserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommunityUserServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_GET_ANS_RECORDS:
          serviceImpl.getAnsRecords((com.learning.learning.grpc.UserInfoRequest) request,
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

  private static abstract class CommunityUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommunityUserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learning.learning.grpc.CommunityUserServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommunityUserService");
    }
  }

  private static final class CommunityUserServiceFileDescriptorSupplier
      extends CommunityUserServiceBaseDescriptorSupplier {
    CommunityUserServiceFileDescriptorSupplier() {}
  }

  private static final class CommunityUserServiceMethodDescriptorSupplier
      extends CommunityUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommunityUserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommunityUserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommunityUserServiceFileDescriptorSupplier())
              .addMethod(getGetUserInfoMethod())
              .addMethod(getGetAnsRecordsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
