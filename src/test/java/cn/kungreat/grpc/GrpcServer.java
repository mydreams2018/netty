package cn.kungreat.grpc;

import cn.kungreat.netty.NettyApplication;
import cn.kungreat.netty.domain.grpc.MailData;
import cn.kungreat.netty.domain.grpc.SendMailGrpc;
import cn.kungreat.netty.grpc.SendServiceImpl;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NettyApplication.class)
public class GrpcServer {

    @Test
    public void service(){
        Server server = ServerBuilder.forPort(80).addService(new SendServiceImpl()).build();
        try {
            server.start();
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    //jvm 回调钩子 jvm 关闭前会执行
                    if(server != null){
                        server.shutdown();
                    }
                }
            }));
            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void client(){
        ManagedChannel localhost = ManagedChannelBuilder.forAddress("localhost", 80)
                .usePlaintext().build();
        SendMailGrpc.SendMailBlockingStub sendMailBlockingStub = SendMailGrpc.newBlockingStub(localhost);
        MailData mailData = MailData.newBuilder().setPhone(888).setAddress("localhost").build();
        //发送信息 并接收返回值
        MailData send = sendMailBlockingStub.send(mailData);
        //输出返回信息
        System.out.println(send);

    }
}