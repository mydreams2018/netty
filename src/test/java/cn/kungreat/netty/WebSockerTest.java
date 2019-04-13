package cn.kungreat.netty;

import cn.kungreat.netty.socket.server.MyServer;
import cn.kungreat.netty.websocker.WebSockerInit;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSockerTest {

    @Test
    public void server() {
        //负责数据读写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //服务类
        EventLoopGroup workGroup = new NioEventLoopGroup();
        // 快速启动服务器
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)
                .childHandler(new WebSockerInit());
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
}