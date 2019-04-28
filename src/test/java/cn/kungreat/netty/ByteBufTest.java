package cn.kungreat.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NettyApplication.class)
public class ByteBufTest {

    @Test
    public void buf(){
        // ByteBuf  是netty 在nio  ByteBuffer 上的扩展 去掉了Nio 上的指针切换  用多个指针来控制 读写 状态分开标识
        ByteBuf byteBuf  = Unpooled.copiedBuffer("hello-world", Charset.forName("utf-8"));
        // JVM 内存存储区
        Unpooled.buffer(1024);
        //JVM 外的存储区
        Unpooled.directBuffer(1024);

        if(byteBuf.hasArray()){
            byte[] array = byteBuf.array();
            System.out.println(new String(array,Charset.forName("utf-8")));
            System.out.println(byteBuf.getClass());
        }
    }
}
