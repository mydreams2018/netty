package cn.kungreat.netty;

import cn.kungreat.netty.handler.Child;
import cn.kungreat.netty.socket.server.MyServer;
import cn.kungreat.netty.socket.server.client.ClientInit;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocketTest {

    @Test
    public void server() {
        //  使用netty http协议 监听80端口 并返回hello world
        //负责数据读写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //服务类
        EventLoopGroup workGroup = new NioEventLoopGroup();
        // 快速启动服务器
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)
                .childHandler(new MyServer());
        try {
            ChannelFuture bind = serverBootstrap.bind(80).sync();
            bind.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(bossGroup != null){
                try {
                    bossGroup.shutdownGracefully();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(workGroup != null){
                workGroup.shutdownGracefully();
            }
        }
    }

    @Test
    public void client() {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        // 快速启动服务器
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup).channel(NioSocketChannel.class)
                .handler(new ClientInit());
        try {
            ChannelFuture bind = bootstrap.connect("localhost",80).sync();
            bind.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(workGroup != null){
                workGroup.shutdownGracefully();
            }
        }
    }
}
