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
    comments = "Source: CommunityWholeService.proto")
public final class CommunityWholeServiceGrpc {

  private CommunityWholeServiceGrpc() {}

  public static final String SERVICE_NAME = "com.learning.learning.grpc.CommunityWholeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest,
      com.learning.learning.grpc.CommunityWholeResponse> getGetNoteListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getNoteList",
      requestType = com.learning.learning.grpc.CommunityWholeRequest.class,
      responseType = com.learning.learning.grpc.CommunityWholeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest,
      com.learning.learning.grpc.CommunityWholeResponse> getGetNoteListMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest, com.learning.learning.grpc.CommunityWholeResponse> getGetNoteListMethod;
    if ((getGetNoteListMethod = CommunityWholeServiceGrpc.getGetNoteListMethod) == null) {
      synchronized (CommunityWholeServiceGrpc.class) {
        if ((getGetNoteListMethod = CommunityWholeServiceGrpc.getGetNoteListMethod) == null) {
          CommunityWholeServiceGrpc.getGetNoteListMethod = getGetNoteListMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.CommunityWholeRequest, com.learning.learning.grpc.CommunityWholeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getNoteList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.CommunityWholeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.CommunityWholeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommunityWholeServiceMethodDescriptorSupplier("getNoteList"))
              .build();
        }
      }
    }
    return getGetNoteListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest,
      com.learning.learning.grpc.CommunityWholeResponse> getGetScoreBoardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getScoreBoard",
      requestType = com.learning.learning.grpc.CommunityWholeRequest.class,
      responseType = com.learning.learning.grpc.CommunityWholeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest,
      com.learning.learning.grpc.CommunityWholeResponse> getGetScoreBoardMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest, com.learning.learning.grpc.CommunityWholeResponse> getGetScoreBoardMethod;
    if ((getGetScoreBoardMethod = CommunityWholeServiceGrpc.getGetScoreBoardMethod) == null) {
      synchronized (CommunityWholeServiceGrpc.class) {
        if ((getGetScoreBoardMethod = CommunityWholeServiceGrpc.getGetScoreBoardMethod) == null) {
          CommunityWholeServiceGrpc.getGetScoreBoardMethod = getGetScoreBoardMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.CommunityWholeRequest, com.learning.learning.grpc.CommunityWholeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getScoreBoard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.CommunityWholeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.CommunityWholeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommunityWholeServiceMethodDescriptorSupplier("getScoreBoard"))
              .build();
        }
      }
    }
    return getGetScoreBoardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest,
      com.learning.learning.grpc.CommunityWholeResponse> getGetQuestionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getQuestion",
      requestType = com.learning.learning.grpc.CommunityWholeRequest.class,
      responseType = com.learning.learning.grpc.CommunityWholeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest,
      com.learning.learning.grpc.CommunityWholeResponse> getGetQuestionMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest, com.learning.learning.grpc.CommunityWholeResponse> getGetQuestionMethod;
    if ((getGetQuestionMethod = CommunityWholeServiceGrpc.getGetQuestionMethod) == null) {
      synchronized (CommunityWholeServiceGrpc.class) {
        if ((getGetQuestionMethod = CommunityWholeServiceGrpc.getGetQuestionMethod) == null) {
          CommunityWholeServiceGrpc.getGetQuestionMethod = getGetQuestionMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.CommunityWholeRequest, com.learning.learning.grpc.CommunityWholeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getQuestion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.CommunityWholeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.CommunityWholeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommunityWholeServiceMethodDescriptorSupplier("getQuestion"))
              .build();
        }
      }
    }
    return getGetQuestionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest,
      com.learning.learning.grpc.CommunityWholeResponse> getGetLikeListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLikeList",
      requestType = com.learning.learning.grpc.CommunityWholeRequest.class,
      responseType = com.learning.learning.grpc.CommunityWholeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest,
      com.learning.learning.grpc.CommunityWholeResponse> getGetLikeListMethod() {
    io.grpc.MethodDescriptor<com.learning.learning.grpc.CommunityWholeRequest, com.learning.learning.grpc.CommunityWholeResponse> getGetLikeListMethod;
    if ((getGetLikeListMethod = CommunityWholeServiceGrpc.getGetLikeListMethod) == null) {
      synchronized (CommunityWholeServiceGrpc.class) {
        if ((getGetLikeListMethod = CommunityWholeServiceGrpc.getGetLikeListMethod) == null) {
          CommunityWholeServiceGrpc.getGetLikeListMethod = getGetLikeListMethod =
              io.grpc.MethodDescriptor.<com.learning.learning.grpc.CommunityWholeRequest, com.learning.learning.grpc.CommunityWholeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getLikeList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.CommunityWholeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.learning.grpc.CommunityWholeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommunityWholeServiceMethodDescriptorSupplier("getLikeList"))
              .build();
        }
      }
    }
    return getGetLikeListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommunityWholeServiceStub newStub(io.grpc.Channel channel) {
    return new CommunityWholeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommunityWholeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CommunityWholeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommunityWholeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CommunityWholeServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CommunityWholeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getNoteList(com.learning.learning.grpc.CommunityWholeRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNoteListMethod(), responseObserver);
    }

    /**
     */
    public void getScoreBoard(com.learning.learning.grpc.CommunityWholeRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetScoreBoardMethod(), responseObserver);
    }

    /**
     */
    public void getQuestion(com.learning.learning.grpc.CommunityWholeRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetQuestionMethod(), responseObserver);
    }

    /**
     */
    public void getLikeList(com.learning.learning.grpc.CommunityWholeRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLikeListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetNoteListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.CommunityWholeRequest,
                com.learning.learning.grpc.CommunityWholeResponse>(
                  this, METHODID_GET_NOTE_LIST)))
          .addMethod(
            getGetScoreBoardMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.CommunityWholeRequest,
                com.learning.learning.grpc.CommunityWholeResponse>(
                  this, METHODID_GET_SCORE_BOARD)))
          .addMethod(
            getGetQuestionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.CommunityWholeRequest,
                com.learning.learning.grpc.CommunityWholeResponse>(
                  this, METHODID_GET_QUESTION)))
          .addMethod(
            getGetLikeListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.learning.grpc.CommunityWholeRequest,
                com.learning.learning.grpc.CommunityWholeResponse>(
                  this, METHODID_GET_LIKE_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class CommunityWholeServiceStub extends io.grpc.stub.AbstractStub<CommunityWholeServiceStub> {
    private CommunityWholeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunityWholeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunityWholeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunityWholeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getNoteList(com.learning.learning.grpc.CommunityWholeRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNoteListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getScoreBoard(com.learning.learning.grpc.CommunityWholeRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetScoreBoardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getQuestion(com.learning.learning.grpc.CommunityWholeRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetQuestionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLikeList(com.learning.learning.grpc.CommunityWholeRequest request,
        io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLikeListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommunityWholeServiceBlockingStub extends io.grpc.stub.AbstractStub<CommunityWholeServiceBlockingStub> {
    private CommunityWholeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunityWholeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunityWholeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunityWholeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.learning.learning.grpc.CommunityWholeResponse getNoteList(com.learning.learning.grpc.CommunityWholeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNoteListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.learning.learning.grpc.CommunityWholeResponse getScoreBoard(com.learning.learning.grpc.CommunityWholeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetScoreBoardMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.learning.learning.grpc.CommunityWholeResponse getQuestion(com.learning.learning.grpc.CommunityWholeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetQuestionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.learning.learning.grpc.CommunityWholeResponse getLikeList(com.learning.learning.grpc.CommunityWholeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLikeListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommunityWholeServiceFutureStub extends io.grpc.stub.AbstractStub<CommunityWholeServiceFutureStub> {
    private CommunityWholeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunityWholeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunityWholeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunityWholeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.CommunityWholeResponse> getNoteList(
        com.learning.learning.grpc.CommunityWholeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNoteListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.CommunityWholeResponse> getScoreBoard(
        com.learning.learning.grpc.CommunityWholeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetScoreBoardMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.CommunityWholeResponse> getQuestion(
        com.learning.learning.grpc.CommunityWholeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetQuestionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.learning.grpc.CommunityWholeResponse> getLikeList(
        com.learning.learning.grpc.CommunityWholeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLikeListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_NOTE_LIST = 0;
  private static final int METHODID_GET_SCORE_BOARD = 1;
  private static final int METHODID_GET_QUESTION = 2;
  private static final int METHODID_GET_LIKE_LIST = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommunityWholeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommunityWholeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_NOTE_LIST:
          serviceImpl.getNoteList((com.learning.learning.grpc.CommunityWholeRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse>) responseObserver);
          break;
        case METHODID_GET_SCORE_BOARD:
          serviceImpl.getScoreBoard((com.learning.learning.grpc.CommunityWholeRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse>) responseObserver);
          break;
        case METHODID_GET_QUESTION:
          serviceImpl.getQuestion((com.learning.learning.grpc.CommunityWholeRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse>) responseObserver);
          break;
        case METHODID_GET_LIKE_LIST:
          serviceImpl.getLikeList((com.learning.learning.grpc.CommunityWholeRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.learning.grpc.CommunityWholeResponse>) responseObserver);
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

  private static abstract class CommunityWholeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommunityWholeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learning.learning.grpc.CommunityWholeServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommunityWholeService");
    }
  }

  private static final class CommunityWholeServiceFileDescriptorSupplier
      extends CommunityWholeServiceBaseDescriptorSupplier {
    CommunityWholeServiceFileDescriptorSupplier() {}
  }

  private static final class CommunityWholeServiceMethodDescriptorSupplier
      extends CommunityWholeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommunityWholeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommunityWholeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommunityWholeServiceFileDescriptorSupplier())
              .addMethod(getGetNoteListMethod())
              .addMethod(getGetScoreBoardMethod())
              .addMethod(getGetQuestionMethod())
              .addMethod(getGetLikeListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
