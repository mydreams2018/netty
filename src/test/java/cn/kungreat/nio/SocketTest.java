package cn.kungreat.nio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SocketTest.class )
public class SocketTest {
    @Test
    public void server(){
        //使用 linux  nc 测试
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()){
            //设置通道为阻塞等待客户端  连接完成后会关闭
            serverSocketChannel.configureBlocking(true);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(80);
            serverSocketChannel.socket().bind(inetSocketAddress);
            // 等待接收
            SocketChannel accept = serverSocketChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(16);
            int read = accept.read(byteBuffer);
            while (read > 0){
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.println(byteBuffer.get());
                }
                byteBuffer.clear();
                read = accept.read(byteBuffer);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}