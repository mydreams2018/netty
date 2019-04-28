package cn.kungreat.protoc;

import cn.kungreat.netty.NettyApplication;
import cn.kungreat.netty.domain.Student;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NettyApplication.class )
public class ProtocTest {

    @Test
    public void parseTest(){
        Student.Person src = Student.Person.newBuilder().setAge(33).setFirstName("kun").setLastName("great")
                .setSex(true).setId(1).build();
        byte data[] = src.toByteArray();
        try {
            Student.Person parse = Student.Person.parseFrom(data);
            System.out.println(parse);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}