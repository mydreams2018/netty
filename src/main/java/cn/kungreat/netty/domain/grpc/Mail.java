// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Mail.proto

package cn.kungreat.netty.domain.grpc;

public final class Mail {
  private Mail() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_mail_MailData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_mail_MailData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nMail.proto\022\nproto.mail\"*\n\010MailData\022\017\n\007" +
      "address\030\001 \001(\t\022\r\n\005phone\030\002 \001(\0052@\n\010SendMail" +
      "\0224\n\004Send\022\024.proto.mail.MailData\032\024.proto.m" +
      "ail.MailData\"\000B)\n\035cn.kungreat.netty.doma" +
      "in.grpcB\004MailH\001P\001b\006proto3"
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
    internal_static_proto_mail_MailData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_mail_MailData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_mail_MailData_descriptor,
        new java.lang.String[] { "Address", "Phone", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
