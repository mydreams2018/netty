package cn.kungreat.nio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SelectorTest.class )
public class SelectorTest {

    /*
    *selector.selectedKeys();   获得当前selector 设置类型的(SelectionKey.OP_ACCEPT)- SelectionKey集合
    * selector.keys()           获得当前selector   所有 SelectionKey集合
    */

    @Test
    public void server(){
        int ports[] = new int [5];
        ports[0]=5001;
        ports[1]=5002;
        ports[2]=5003;
        ports[3]=5004;
        ports[4]=5005;
        Selector selector = null;
        try {
            selector = Selector.open();
            for(int x=0;x<ports.length;x++){
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                // 如果一个 Channel 要注册到 Selector 中, 那么这个 Channel 必须是非阻塞的
                serverSocketChannel.configureBlocking(false);
                ServerSocket socket = serverSocketChannel.socket();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(ports[x]);
                socket.bind(inetSocketAddress);
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                //监听端口
            }
//            selector.select()  端口有事件数量就会解发
            //select()阻塞到至少有一个通道在你注册的事件上就绪了。
            //select(long timeout)和select()一样，除了最长会阻塞timeout毫秒(参数)。
            while (selector.select() > 0){

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while(iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    if(next.isAcceptable()){
                        ServerSocketChannel channel =(ServerSocketChannel) next.channel();
                        SocketChannel accept = channel.accept();
                        accept.configureBlocking(false);
                        accept.register(selector,SelectionKey.OP_READ);
                        iterator.remove();
                    }else if(next.isReadable()){
                        SocketChannel channel = (SocketChannel)next.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
                        int read = channel.read(byteBuffer);
                        while (read > 0){
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()){
                                System.out.print((char)byteBuffer.get());
                            }
                            //返回相同数据
                            byteBuffer.rewind();
                            channel.write(byteBuffer);

                            byteBuffer.clear();
                            read = channel.read(byteBuffer);
                        }
                        iterator.remove();
                    }
                }
            }
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            if(selector != null){
                try {
                    selector.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void client(){
        //1. 获取socketChannel
        SocketChannel client = null;
        try {
            client = SocketChannel.open();
            //2. 创建连接
            client.connect(new InetSocketAddress("localhost", 5001));
            ByteBuffer buf = ByteBuffer.allocate(16);
            //3. 设置通道为非阻塞
            client.configureBlocking(false);

            buf.put("hard".getBytes());
            buf.flip();
            client.write(buf);
            buf.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(client != null){
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}