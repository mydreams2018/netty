package cn.kungreat.thrift;

import cn.kungreat.netty.domain.User;
import cn.kungreat.netty.domain.UserService;
import cn.kungreat.netty.thrift.ThriftServiceImpl;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThriftService.class)
public class ThriftService {

    @Test
    public void service(){
        try {
            TNonblockingServerSocket socket = new TNonblockingServerSocket(80);
            THsHaServer.Args args = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(20);
            UserService.Processor<ThriftServiceImpl> processor = new UserService.Processor<>(new ThriftServiceImpl());
            args.protocolFactory(new TCompactProtocol.Factory());
            args.transportFactory(new TFramedTransport.Factory());
            args.processorFactory(new TProcessorFactory(processor));
            TServer tServer = new THsHaServer(args);
            tServer.serve();
            //死循环
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void client(){
        TTransport tTransport = new TFramedTransport(new TSocket("localhost",80),8192);
        try {
            TProtocol tProtocol = new TCompactProtocol(tTransport);
            UserService.Client client = new UserService.Client(tProtocol);
            tTransport.open();
            User user = client.getUserById(32);
            System.out.println(user);

            user.setAge(33);
            client.saveUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(tTransport != null){
                tTransport.close();
            }

        }

    }
}