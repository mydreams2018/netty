package cn.kungreat.netty.domain.grpc;

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
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: Mail.proto")
public final class SendMailGrpc {

  private SendMailGrpc() {}

  public static final String SERVICE_NAME = "proto.mail.SendMail";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.kungreat.netty.domain.grpc.MailData,
      cn.kungreat.netty.domain.grpc.MailData> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Send",
      requestType = cn.kungreat.netty.domain.grpc.MailData.class,
      responseType = cn.kungreat.netty.domain.grpc.MailData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.kungreat.netty.domain.grpc.MailData,
      cn.kungreat.netty.domain.grpc.MailData> getSendMethod() {
    io.grpc.MethodDescriptor<cn.kungreat.netty.domain.grpc.MailData, cn.kungreat.netty.domain.grpc.MailData> getSendMethod;
    if ((getSendMethod = SendMailGrpc.getSendMethod) == null) {
      synchronized (SendMailGrpc.class) {
        if ((getSendMethod = SendMailGrpc.getSendMethod) == null) {
          SendMailGrpc.getSendMethod = getSendMethod = 
              io.grpc.MethodDescriptor.<cn.kungreat.netty.domain.grpc.MailData, cn.kungreat.netty.domain.grpc.MailData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.mail.SendMail", "Send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.kungreat.netty.domain.grpc.MailData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.kungreat.netty.domain.grpc.MailData.getDefaultInstance()))
                  .setSchemaDescriptor(new SendMailMethodDescriptorSupplier("Send"))
                  .build();
          }
        }
     }
     return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SendMailStub newStub(io.grpc.Channel channel) {
    return new SendMailStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SendMailBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SendMailBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SendMailFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SendMailFutureStub(channel);
  }

  /**
   */
  public static abstract class SendMailImplBase implements io.grpc.BindableService {

    /**
     */
    public void send(cn.kungreat.netty.domain.grpc.MailData request,
        io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.MailData> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.kungreat.netty.domain.grpc.MailData,
                cn.kungreat.netty.domain.grpc.MailData>(
                  this, METHODID_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class SendMailStub extends io.grpc.stub.AbstractStub<SendMailStub> {
    private SendMailStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SendMailStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendMailStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SendMailStub(channel, callOptions);
    }

    /**
     */
    public void send(cn.kungreat.netty.domain.grpc.MailData request,
        io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.MailData> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SendMailBlockingStub extends io.grpc.stub.AbstractStub<SendMailBlockingStub> {
    private SendMailBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SendMailBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendMailBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SendMailBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.kungreat.netty.domain.grpc.MailData send(cn.kungreat.netty.domain.grpc.MailData request) {
      return blockingUnaryCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SendMailFutureStub extends io.grpc.stub.AbstractStub<SendMailFutureStub> {
    private SendMailFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SendMailFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendMailFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SendMailFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.kungreat.netty.domain.grpc.MailData> send(
        cn.kungreat.netty.domain.grpc.MailData request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SendMailImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SendMailImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((cn.kungreat.netty.domain.grpc.MailData) request,
              (io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.MailData>) responseObserver);
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

  private static abstract class SendMailBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SendMailBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.kungreat.netty.domain.grpc.Mail.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SendMail");
    }
  }

  private static final class SendMailFileDescriptorSupplier
      extends SendMailBaseDescriptorSupplier {
    SendMailFileDescriptorSupplier() {}
  }

  private static final class SendMailMethodDescriptorSupplier
      extends SendMailBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SendMailMethodDescriptorSupplier(String methodName) {
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
      synchronized (SendMailGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SendMailFileDescriptorSupplier())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
