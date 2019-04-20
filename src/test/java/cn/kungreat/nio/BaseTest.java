package cn.kungreat.nio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseTest.class )
public class BaseTest {
    @Test
    public void base(){
        IntBuffer intBuffer = IntBuffer.allocate(8);
        for(int x=0 ;x<intBuffer.capacity();x++){
            //生成随机数
            int i = new SecureRandom().nextInt(20);
            if(x == 5){
                intBuffer.get();
                continue; // 等5的时候读一个IntBuffer默认为0  会进位 后边读出来也是0
            }
            intBuffer.put(i);
        }
        System.out.println("-----------------------");
        // 位置变更 切换 在NIO 中一个区域 又能读又能写 需要有状态标识
        // 读写都会进一位 需要自已控制 intBuffer.flip() 只改变标识指针位置
        intBuffer.flip();
        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }

    @Test
    public void fileChannelReader(){
        FileInputStream fileInputStream = null;
        try {
            String s = ResourceUtils.getURL("").toString();
            String path = s.substring(6)+"src/main/doc";
            File file = new File(path);
            File[] files = file.listFiles();
            if(files.length>0){
                fileInputStream = new FileInputStream(files[0]);
                FileChannel channel = fileInputStream.getChannel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(16);
                int read = channel.read(byteBuffer);
                while (read > 0){
                    //读取的长度
                    System.out.println(read);
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()){
                        System.out.print((char)byteBuffer.get());
                    }
                    System.out.println("---------------");
                    byteBuffer.flip();
                    read = channel.read(byteBuffer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void fileChannelWriter(){
        FileOutputStream fileOutputStream = null;
        try {
            String s = ResourceUtils.getURL("").toString();
            String path = s.substring(6)+"src/main/doc";
            File file = new File(path);
            File[] files = file.listFiles();
            if(files.length > 0){
                fileOutputStream = new FileOutputStream(files[0]);
                FileChannel channel = fileOutputStream.getChannel();

                ByteBuffer byteBuffer  = ByteBuffer.allocate(16);
                byte message[] = "http://datacenter.xnjz.com:8082/new-\nxnsjy696".getBytes();
                for(int x = 0 ; x < message.length ; x++){
                    if(byteBuffer.hasRemaining()){
                        byteBuffer.put(message[x]);
                        if(x==(message.length-1)){
                            byteBuffer.flip();
                            channel.write(byteBuffer);
                        }
                    }else{
                        byteBuffer.flip();
                        channel.write(byteBuffer);
                        byteBuffer.flip();
                        byteBuffer.put(message[x]);
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    *   parrent.mark(); //标记当前的位置
        parrent.reset();// 配合 mark 使用 修改当前位置为mark
        parrent.rewind(); // 修改当前 position-mark  为初始位置 (不改变limit)

       除了是只能读以外 和slice一样     IntBuffer childReadOnly = parrent.asReadOnlyBuffer();
     */

    @Test
    public void sliceTest() {
        IntBuffer parrent = IntBuffer.allocate(16);
        // 指定生成一个新的buffer 共享区域
        parrent.position(8);
        parrent.limit(16);
        IntBuffer child = parrent.slice();
        parrent.clear(); //重置

        for (int x = 0; x < parrent.capacity(); x++) {
            //生成随机数
            int i = new SecureRandom().nextInt(20);
            parrent.put(i);
        }
        // 位置变更 切换 在NIO 中一个区域 又能读又能写 需要有状态标识
        // 读写都会进一位 需要自已控制 intBuffer.flip() 只改变标识指针位置
        parrent.flip();
        while (parrent.hasRemaining()) {
            System.out.println(parrent.get());
        }
        for (; child.remaining() > 0; ) {
            //输出 child值  跟parrent 的一样 如果修改child值也会影响parrent
            System.out.print(child.get());
        }
    }
}
