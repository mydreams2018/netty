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
            System.out.println(i);
            intBuffer.put(i);
        }
        System.out.println("-----------------------");
        // 读写切换 在NIO 中一个区域 又能读又能写 需要有状态标识
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
                    // 读取的长度
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
}
