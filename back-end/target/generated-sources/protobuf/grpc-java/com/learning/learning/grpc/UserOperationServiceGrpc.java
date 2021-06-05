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
    comments = "Source: UserOperationService.proto")
public final class UserOperationServiceGrpc {

  private UserOperationServiceGrpc() {}

  public static final String SERVICE_NAME = "com.learning.learning.grpc.UserOperationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest,
      com.learning.learning.grpc.UserOperationResponse> getPostNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "postNote",
      requestType = com.learning.learning.grpc.UserOperationRequest.class,
      responseType = com.learning.learning.grpc.UserOperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest,
      com.learning.learning.grpc.UserOperationResponse> getPostNoteMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest, com.learning.learning.grpc.UserOperationResponse> getPostNoteMethod;
    if ((getPostNoteMethod = UserOperationServiceGrpc.getPostNoteMethod) == null) {
      synchronized (UserOperationServiceGrpc.class) {
        if ((getPostNoteMethod = UserOperationServiceGrpc.getPostNoteMethod) == null) {
          UserOperationServiceGrpc.getPostNoteMethod = getPostNoteMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.UserOperationRequest, com.learning.learning.grpc.UserOperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "postNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserOperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserOperationServiceMethodDescriptorSupplier("postNote"))
              .build();
        }
      }
    }
    return getPostNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest,
      com.learning.learning.grpc.UserOperationResponse> getPostCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "postComment",
      requestType = com.learning.learning.grpc.UserOperationRequest.class,
      responseType = com.learning.learning.grpc.UserOperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest,
      com.learning.learning.grpc.UserOperationResponse> getPostCommentMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest, com.learning.learning.grpc.UserOperationResponse> getPostCommentMethod;
    if ((getPostCommentMethod = UserOperationServiceGrpc.getPostCommentMethod) == null) {
      synchronized (UserOperationServiceGrpc.class) {
        if ((getPostCommentMethod = UserOperationServiceGrpc.getPostCommentMethod) == null) {
          UserOperationServiceGrpc.getPostCommentMethod = getPostCommentMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.UserOperationRequest, com.learning.learning.grpc.UserOperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "postComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserOperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserOperationServiceMethodDescriptorSupplier("postComment"))
              .build();
        }
      }
    }
    return getPostCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest,
      com.learning.learning.grpc.UserOperationResponse> getPostLikeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "postLike",
      requestType = com.learning.learning.grpc.UserOperationRequest.class,
      responseType = com.learning.learning.grpc.UserOperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest,
      com.learning.learning.grpc.UserOperationResponse> getPostLikeMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest, com.learning.learning.grpc.UserOperationResponse> getPostLikeMethod;
    if ((getPostLikeMethod = UserOperationServiceGrpc.getPostLikeMethod) == null) {
      synchronized (UserOperationServiceGrpc.class) {
        if ((getPostLikeMethod = UserOperationServiceGrpc.getPostLikeMethod) == null) {
          UserOperationServiceGrpc.getPostLikeMethod = getPostLikeMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.UserOperationRequest, com.learning.learning.grpc.UserOperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "postLike"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserOperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserOperationServiceMethodDescriptorSupplier("postLike"))
              .build();
        }
      }
    }
    return getPostLikeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest,
      com.learning.learning.grpc.UserOperationResponse> getPostAnswerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "postAnswer",
      requestType = com.learning.learning.grpc.UserOperationRequest.class,
      responseType = com.learning.learning.grpc.UserOperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest,
      com.learning.learning.grpc.UserOperationResponse> getPostAnswerMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.UserOperationRequest, com.learning.learning.grpc.UserOperationResponse> getPostAnswerMethod;
    if ((getPostAnswerMethod = UserOperationServiceGrpc.getPostAnswerMethod) == null) {
      synchronized (UserOperationServiceGrpc.class) {
        if ((getPostAnswerMethod = UserOperationServiceGrpc.getPostAnswerMethod) == null) {
          UserOperationServiceGrpc.getPostAnswerMethod = getPostAnswerMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.UserOperationRequest, com.learning.learning.grpc.UserOperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "postAnswer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.UserOperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserOperationServiceMethodDescriptorSupplier("postAnswer"))
              .build();
        }
      }
    }
    return getPostAnswerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserOperationServiceStub newStub(io.grpc.Channel channel) {
    return new UserOperationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserOperationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserOperationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserOperationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserOperationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserOperationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void postNote(com.learning.learning.grpc.UserOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPostNoteMethod(), responseObserver);
    }

    /**
     */
    public void postComment(com.learning.learning.grpc.UserOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPostCommentMethod(), responseObserver);
    }

    /**
     */
    public void postLike(com.learning.learning.grpc.UserOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPostLikeMethod(), responseObserver);
    }

    /**
     */
    public void postAnswer(com.learning.learning.grpc.UserOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPostAnswerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPostNoteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.UserOperationRequest,
                com.learning.learning.grpc.UserOperationResponse>(
                  this, METHODID_POST_NOTE)))
          .addMethod(
            getPostCommentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.UserOperationRequest,
                com.learning.learning.grpc.UserOperationResponse>(
                  this, METHODID_POST_COMMENT)))
          .addMethod(
            getPostLikeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.UserOperationRequest,
                com.learning.learning.grpc.UserOperationResponse>(
                  this, METHODID_POST_LIKE)))
          .addMethod(
            getPostAnswerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.UserOperationRequest,
                com.learning.learning.grpc.UserOperationResponse>(
                  this, METHODID_POST_ANSWER)))
          .build();
    }
  }

  /**
   */
  public static final class UserOperationServiceStub extends io.grpc.stub.AbstractStub<UserOperationServiceStub> {
    private UserOperationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserOperationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserOperationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserOperationServiceStub(channel, callOptions);
    }

    /**
     */
    public void postNote(com.learning.learning.grpc.UserOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPostNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void postComment(com.learning.learning.grpc.UserOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPostCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void postLike(com.learning.learning.grpc.UserOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPostLikeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void postAnswer(com.learning.learning.grpc.UserOperationRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPostAnswerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserOperationServiceBlockingStub extends io.grpc.stub.AbstractStub<UserOperationServiceBlockingStub> {
    private UserOperationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserOperationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserOperationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserOperationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.learning.learning.grpc.UserOperationResponse postNote(com.learning.learning.grpc.UserOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getPostNoteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.learning.learning.grpc.UserOperationResponse postComment(com.learning.learning.grpc.UserOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getPostCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.learning.learning.grpc.UserOperationResponse postLike(com.learning.learning.grpc.UserOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getPostLikeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.learning.learning.grpc.UserOperationResponse postAnswer(com.learning.learning.grpc.UserOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getPostAnswerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserOperationServiceFutureStub extends io.grpc.stub.AbstractStub<UserOperationServiceFutureStub> {
    private UserOperationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserOperationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserOperationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserOperationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.UserOperationResponse> postNote(
        com.learning.learning.grpc.UserOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPostNoteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.UserOperationResponse> postComment(
        com.learning.learning.grpc.UserOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPostCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.UserOperationResponse> postLike(
        com.learning.learning.grpc.UserOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPostLikeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.UserOperationResponse> postAnswer(
        com.learning.learning.grpc.UserOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPostAnswerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_POST_NOTE = 0;
  private static final int METHODID_POST_COMMENT = 1;
  private static final int METHODID_POST_LIKE = 2;
  private static final int METHODID_POST_ANSWER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserOperationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserOperationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_POST_NOTE:
          serviceImpl.postNote((com.learning.learning.grpc.UserOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse>) responseObserver);
          break;
        case METHODID_POST_COMMENT:
          serviceImpl.postComment((com.learning.learning.grpc.UserOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse>) responseObserver);
          break;
        case METHODID_POST_LIKE:
          serviceImpl.postLike((com.learning.learning.grpc.UserOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse>) responseObserver);
          break;
        case METHODID_POST_ANSWER:
          serviceImpl.postAnswer((com.learning.learning.grpc.UserOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.UserOperationResponse>) responseObserver);
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

  private static abstract class UserOperationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserOperationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learning.learning.grpc.UserOperationServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserOperationService");
    }
  }

  private static final class UserOperationServiceFileDescriptorSupplier
      extends UserOperationServiceBaseDescriptorSupplier {
    UserOperationServiceFileDescriptorSupplier() {}
  }

  private static final class UserOperationServiceMethodDescriptorSupplier
      extends UserOperationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserOperationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserOperationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserOperationServiceFileDescriptorSupplier())
              .addMethod(getPostNoteMethod())
              .addMethod(getPostCommentMethod())
              .addMethod(getPostLikeMethod())
              .addMethod(getPostAnswerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
