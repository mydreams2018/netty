// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: StreamTest.proto

package cn.kungreat.netty.domain.grpc.stream;

public final class StreamData {
  private StreamData() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_mail_stream_Data_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_mail_stream_Data_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_mail_stream_SendAge_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_mail_stream_SendAge_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020StreamTest.proto\022\021proto.mail.stream\"!\n" +
      "\004Data\022\014\n\004name\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\"\026\n\007Send" +
      "Age\022\013\n\003age\030\001 \001(\0052\214\001\n\010SendData\022?\n\004send\022\032." +
      "proto.mail.stream.SendAge\032\027.proto.mail.s" +
      "tream.Data\"\0000\001\022?\n\004left\022\032.proto.mail.stre" +
      "am.SendAge\032\027.proto.mail.stream.Data\"\000(\001B" +
      "6\n$cn.kungreat.netty.domain.grpc.streamB" +
      "\nStreamDataH\001P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_proto_mail_stream_Data_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_mail_stream_Data_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_mail_stream_Data_descriptor,
        new java.lang.String[] { "Name", "Age", });
    internal_static_proto_mail_stream_SendAge_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_proto_mail_stream_SendAge_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_mail_stream_SendAge_descriptor,
        new java.lang.String[] { "Age", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
