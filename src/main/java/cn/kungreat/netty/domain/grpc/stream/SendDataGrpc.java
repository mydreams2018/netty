package cn.kungreat.netty.domain.grpc.stream;

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
    comments = "Source: StreamTest.proto")
public final class SendDataGrpc {

  private SendDataGrpc() {}

  public static final String SERVICE_NAME = "proto.mail.stream.SendData";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.kungreat.netty.domain.grpc.stream.SendAge,
      cn.kungreat.netty.domain.grpc.stream.Data> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send",
      requestType = cn.kungreat.netty.domain.grpc.stream.SendAge.class,
      responseType = cn.kungreat.netty.domain.grpc.stream.Data.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cn.kungreat.netty.domain.grpc.stream.SendAge,
      cn.kungreat.netty.domain.grpc.stream.Data> getSendMethod() {
    io.grpc.MethodDescriptor<cn.kungreat.netty.domain.grpc.stream.SendAge, cn.kungreat.netty.domain.grpc.stream.Data> getSendMethod;
    if ((getSendMethod = SendDataGrpc.getSendMethod) == null) {
      synchronized (SendDataGrpc.class) {
        if ((getSendMethod = SendDataGrpc.getSendMethod) == null) {
          SendDataGrpc.getSendMethod = getSendMethod = 
              io.grpc.MethodDescriptor.<cn.kungreat.netty.domain.grpc.stream.SendAge, cn.kungreat.netty.domain.grpc.stream.Data>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "proto.mail.stream.SendData", "send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.kungreat.netty.domain.grpc.stream.SendAge.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.kungreat.netty.domain.grpc.stream.Data.getDefaultInstance()))
                  .setSchemaDescriptor(new SendDataMethodDescriptorSupplier("send"))
                  .build();
          }
        }
     }
     return getSendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.kungreat.netty.domain.grpc.stream.SendAge,
      cn.kungreat.netty.domain.grpc.stream.Data> getLeftMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "left",
      requestType = cn.kungreat.netty.domain.grpc.stream.SendAge.class,
      responseType = cn.kungreat.netty.domain.grpc.stream.Data.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<cn.kungreat.netty.domain.grpc.stream.SendAge,
      cn.kungreat.netty.domain.grpc.stream.Data> getLeftMethod() {
    io.grpc.MethodDescriptor<cn.kungreat.netty.domain.grpc.stream.SendAge, cn.kungreat.netty.domain.grpc.stream.Data> getLeftMethod;
    if ((getLeftMethod = SendDataGrpc.getLeftMethod) == null) {
      synchronized (SendDataGrpc.class) {
        if ((getLeftMethod = SendDataGrpc.getLeftMethod) == null) {
          SendDataGrpc.getLeftMethod = getLeftMethod = 
              io.grpc.MethodDescriptor.<cn.kungreat.netty.domain.grpc.stream.SendAge, cn.kungreat.netty.domain.grpc.stream.Data>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "proto.mail.stream.SendData", "left"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.kungreat.netty.domain.grpc.stream.SendAge.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.kungreat.netty.domain.grpc.stream.Data.getDefaultInstance()))
                  .setSchemaDescriptor(new SendDataMethodDescriptorSupplier("left"))
                  .build();
          }
        }
     }
     return getLeftMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SendDataStub newStub(io.grpc.Channel channel) {
    return new SendDataStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SendDataBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SendDataBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SendDataFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SendDataFutureStub(channel);
  }

  /**
   */
  public static abstract class SendDataImplBase implements io.grpc.BindableService {

    /**
     */
    public void send(cn.kungreat.netty.domain.grpc.stream.SendAge request,
        io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.stream.Data> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.stream.SendAge> left(
        io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.stream.Data> responseObserver) {
      return asyncUnimplementedStreamingCall(getLeftMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                cn.kungreat.netty.domain.grpc.stream.SendAge,
                cn.kungreat.netty.domain.grpc.stream.Data>(
                  this, METHODID_SEND)))
          .addMethod(
            getLeftMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                cn.kungreat.netty.domain.grpc.stream.SendAge,
                cn.kungreat.netty.domain.grpc.stream.Data>(
                  this, METHODID_LEFT)))
          .build();
    }
  }

  /**
   */
  public static final class SendDataStub extends io.grpc.stub.AbstractStub<SendDataStub> {
    private SendDataStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SendDataStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendDataStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SendDataStub(channel, callOptions);
    }

    /**
     */
    public void send(cn.kungreat.netty.domain.grpc.stream.SendAge request,
        io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.stream.Data> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.stream.SendAge> left(
        io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.stream.Data> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLeftMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SendDataBlockingStub extends io.grpc.stub.AbstractStub<SendDataBlockingStub> {
    private SendDataBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SendDataBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendDataBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SendDataBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<cn.kungreat.netty.domain.grpc.stream.Data> send(
        cn.kungreat.netty.domain.grpc.stream.SendAge request) {
      return blockingServerStreamingCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SendDataFutureStub extends io.grpc.stub.AbstractStub<SendDataFutureStub> {
    private SendDataFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SendDataFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendDataFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SendDataFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND = 0;
  private static final int METHODID_LEFT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SendDataImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SendDataImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((cn.kungreat.netty.domain.grpc.stream.SendAge) request,
              (io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.stream.Data>) responseObserver);
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
        case METHODID_LEFT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.left(
              (io.grpc.stub.StreamObserver<cn.kungreat.netty.domain.grpc.stream.Data>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SendDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SendDataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.kungreat.netty.domain.grpc.stream.StreamData.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SendData");
    }
  }

  private static final class SendDataFileDescriptorSupplier
      extends SendDataBaseDescriptorSupplier {
    SendDataFileDescriptorSupplier() {}
  }

  private static final class SendDataMethodDescriptorSupplier
      extends SendDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SendDataMethodDescriptorSupplier(String methodName) {
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
      synchronized (SendDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SendDataFileDescriptorSupplier())
              .addMethod(getSendMethod())
              .addMethod(getLeftMethod())
              .build();
        }
      }
    }
    return result;
  }
}
