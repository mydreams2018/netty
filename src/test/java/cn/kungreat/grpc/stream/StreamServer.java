package cn.kungreat.grpc.stream;

import cn.kungreat.netty.NettyApplication;
import cn.kungreat.netty.domain.grpc.MailData;
import cn.kungreat.netty.domain.grpc.stream.Data;
import cn.kungreat.netty.domain.grpc.stream.SendAge;
import cn.kungreat.netty.domain.grpc.stream.SendDataGrpc;
import cn.kungreat.netty.grpc.stream.DataServiceImpl;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NettyApplication.class)
public class StreamServer {

    @Test
    public void service(){
        Server server = ServerBuilder.forPort(80).addService(new DataServiceImpl()).build();
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
        SendDataGrpc.SendDataBlockingStub sendDataBlockingStub = SendDataGrpc.newBlockingStub(localhost);
        SendAge build = SendAge.newBuilder().setAge(33).build();
        //发送信息 并接收返回值
        Iterator<Data> send = sendDataBlockingStub.send(build);
        //输出返回信息
        while (send.hasNext()){
            System.out.println(send.next().toString());
        }
    }

    @Test
    public void leftClient() {
        ManagedChannel localhost = ManagedChannelBuilder.forAddress("localhost", 80)
                .usePlaintext().build();
        //异步的
        SendDataGrpc.SendDataStub sendDataStub = SendDataGrpc.newStub(localhost);

        StreamObserver<Data> receive = new StreamObserver<Data>() {
            @Override
            public void onNext(Data value) {
                System.out.println("服务器返回了");
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("出错了");
            }

            @Override
            public void onCompleted() {
                System.out.println("服务器完全成了返回");
            }
        };
        StreamObserver<SendAge> send = sendDataStub.left(receive);
        SendAge age1 = SendAge.newBuilder().setAge(18).build();
        SendAge age2 = SendAge.newBuilder().setAge(19).build();
        send.onNext(age1);
        send.onNext(age2);
        send.onCompleted();

        try {
            // 异步 一直往下走 jvm关闭的快  都还没有发送和接收信息
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}