package cn.kungreat.nio;

import cn.kungreat.netty.NettyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NettyApplication.class )
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
            accept.configureBlocking(true);
            ByteBuffer byteBuffer = ByteBuffer.allocate(16);
            int read = accept.read(byteBuffer);
            while (read > 0){
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.print((char)byteBuffer.get());
                }
                byteBuffer.clear();
                read = accept.read(byteBuffer);
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void client(){
        try (SocketChannel socketChannel = SocketChannel.open();
             FileChannel fileChannel = new FileInputStream
                     ("C:/Users/dreaming/IdeaProjects/netty/src/main/doc/message.txt")
                     .getChannel()){
            socketChannel.connect(new InetSocketAddress("localhost",80));
            socketChannel.configureBlocking(true);

            //向服务器传送文件
            long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
            System.out.println("传送的总数量"+transferCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}