package cn.kungreat.netty.grpc;


import cn.kungreat.netty.domain.grpc.MailData;
import cn.kungreat.netty.domain.grpc.SendMailGrpc;
import io.grpc.stub.StreamObserver;

public class SendServiceImpl extends SendMailGrpc.SendMailImplBase {
    @Override
    public void send(MailData request, StreamObserver<MailData> responseObserver) {
        System.out.println("接收的:"+request);

        MailData bbs = MailData.newBuilder().setAddress("襄阳论坛").setPhone(8820).build();
        // 响应给客户端
        responseObserver.onNext(bbs);
        // 完成
        responseObserver.onCompleted();
    }
}