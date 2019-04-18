package cn.kungreat.netty.grpc.stream;

import cn.kungreat.netty.domain.grpc.stream.Data;
import cn.kungreat.netty.domain.grpc.stream.SendAge;
import cn.kungreat.netty.domain.grpc.stream.SendDataGrpc;
import io.grpc.stub.StreamObserver;

public class DataServiceImpl extends SendDataGrpc.SendDataImplBase {
    @Override
    public void send(SendAge request, StreamObserver<Data> responseObserver) {
        System.out.println(request.getAge());

        Data kun = Data.newBuilder().setAge(33).setName("kun").build();
        Data great = Data.newBuilder().setAge(33).setName("great").build();
        responseObserver.onNext(kun);
        responseObserver.onNext(great);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<SendAge> left(StreamObserver<Data> responseObserver) {
        return new StreamObserver<SendAge>() {
            @Override
            public void onNext(SendAge value) {
                System.out.println("客户有请求-请处理");
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("出错了");
            }

            @Override
            public void onCompleted() {
                System.out.println("客户端发送完了-准备返回最后结果");
                Data kun = Data.newBuilder().setAge(18).setName("bbs").build();
                responseObserver.onNext(kun);
                responseObserver.onCompleted();
            }
        };
    }
}