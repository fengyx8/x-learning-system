// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SearchService.proto

package com.learning.learning.grpc;

public final class SearchServiceOuterClass {
  private SearchServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_learning_learning_grpc_NewsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_learning_learning_grpc_NewsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_learning_learning_grpc_GraphRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_learning_learning_grpc_GraphRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_learning_learning_grpc_WordCloudRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_learning_learning_grpc_WordCloudRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_learning_learning_grpc_NewsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_learning_learning_grpc_NewsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_learning_learning_grpc_GraphResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_learning_learning_grpc_GraphResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_learning_learning_grpc_WordCloudResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_learning_learning_grpc_WordCloudResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_learning_learning_grpc_UserInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_learning_learning_grpc_UserInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_learning_learning_grpc_UserInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_learning_learning_grpc_UserInfoResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023SearchService.proto\022\032com.learning.lear" +
      "ning.grpc\"W\n\013NewsRequest\022\r\n\005title\030\001 \001(\t\022" +
      "\017\n\007content\030\002 \001(\t\022\014\n\004type\030\003 \001(\t\022\014\n\004year\030\004" +
      " \001(\t\022\014\n\004page\030\005 \001(\t\"\016\n\014GraphRequest\"\022\n\020Wo" +
      "rdCloudRequest\" \n\014NewsResponse\022\020\n\010respon" +
      "se\030\001 \001(\t\"!\n\rGraphResponse\022\020\n\010response\030\001 " +
      "\001(\t\"%\n\021WordCloudResponse\022\020\n\010response\030\001 \001" +
      "(\t\"1\n\017UserInfoRequest\022\016\n\006userId\030\001 \001(\t\022\016\n" +
      "\006roleId\030\002 \001(\005\"$\n\020UserInfoResponse\022\020\n\010use" +
      "rInfo\030\001 \001(\t2\304\002\n\rSearchService\022_\n\nsearchN" +
      "ews\022\'.com.learning.learning.grpc.NewsReq" +
      "uest\032(.com.learning.learning.grpc.NewsRe" +
      "sponse\022b\n\013searchGraph\022(.com.learning.lea" +
      "rning.grpc.GraphRequest\032).com.learning.l" +
      "earning.grpc.GraphResponse\022n\n\017searchWord" +
      "Cloud\022,.com.learning.learning.grpc.WordC" +
      "loudRequest\032-.com.learning.learning.grpc" +
      ".WordCloudResponse2\202\001\n\026CommunityLoggedSe" +
      "rvice\022h\n\013getUserInfo\022+.com.learning.lear" +
      "ning.grpc.UserInfoRequest\032,.com.learning" +
      ".learning.grpc.UserInfoResponseB\002P\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_learning_learning_grpc_NewsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_learning_learning_grpc_NewsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_learning_learning_grpc_NewsRequest_descriptor,
        new java.lang.String[] { "Title", "Content", "Type", "Year", "Page", });
    internal_static_com_learning_learning_grpc_GraphRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_learning_learning_grpc_GraphRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_learning_learning_grpc_GraphRequest_descriptor,
        new java.lang.String[] { });
    internal_static_com_learning_learning_grpc_WordCloudRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_learning_learning_grpc_WordCloudRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_learning_learning_grpc_WordCloudRequest_descriptor,
        new java.lang.String[] { });
    internal_static_com_learning_learning_grpc_NewsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_learning_learning_grpc_NewsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_learning_learning_grpc_NewsResponse_descriptor,
        new java.lang.String[] { "Response", });
    internal_static_com_learning_learning_grpc_GraphResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_learning_learning_grpc_GraphResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_learning_learning_grpc_GraphResponse_descriptor,
        new java.lang.String[] { "Response", });
    internal_static_com_learning_learning_grpc_WordCloudResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_learning_learning_grpc_WordCloudResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_learning_learning_grpc_WordCloudResponse_descriptor,
        new java.lang.String[] { "Response", });
    internal_static_com_learning_learning_grpc_UserInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_learning_learning_grpc_UserInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_learning_learning_grpc_UserInfoRequest_descriptor,
        new java.lang.String[] { "UserId", "RoleId", });
    internal_static_com_learning_learning_grpc_UserInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_com_learning_learning_grpc_UserInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_learning_learning_grpc_UserInfoResponse_descriptor,
        new java.lang.String[] { "UserInfo", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
