package cn.kungreat.thrift;

import cn.kungreat.netty.NettyApplication;
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
@SpringBootTest(classes = NettyApplication.class)
public class ThriftService {

    @Test
    public void service(){
        try {
            TNonblockingServerSocket socket = new TNonblockingServerSocket(80);
            THsHaServer.Args args = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(20);
            // 真实处理的过程
            UserService.Processor<ThriftServiceImpl> processor = new UserService.Processor<>(new ThriftServiceImpl());
            // 压缩协议
            args.protocolFactory(new TCompactProtocol.Factory());
            // 传输层
            args.transportFactory(new TFramedTransport.Factory());
            args.processorFactory(new TProcessorFactory(processor));
            TServer tServer = new THsHaServer(args);
            tServer.serve();
            //死循环
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*      总接口  TProtocol协议
    * TCompactProtocol  压缩
    * TBinaryProtocol   二进制
    * TJSONProtocol     json
    *
    *       总接口 TTransport 传输方式
    *       TSocket 阻塞socket
    *       TFramedTransport   以frame 方式传输 非阻塞
    *       TFileTransport     以文件方式
    *       TZlibTransport     以压缩方式
    *
    *       总接口   TServer
    *       TSimpleServer 简单的单线程的服务  用于测试
    *       TThreadPoolServer   多线程的服务 (阻塞IO)
    *       TNonblockingServer   非阻塞IO (配合TFramedTransport)
    *       THsHaServer  引入线程池处理  half-sync half-asnyc
    *                  (half-asnyc是在异步处理IO),(half-sync用在Handler处理RPC同步处理)
    *
     */


    @Test
    public void client(){
        //传输层
        TTransport tTransport = new TFramedTransport(new TSocket("localhost",80),8192);
        try {
            // 压缩协议
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