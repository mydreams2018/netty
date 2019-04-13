package cn.kungreat.netty;

import cn.kungreat.netty.health.HealthInit;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthHeart {

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
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new HealthInit());
        try {
            ChannelFuture bind = serverBootstrap.bind(80).sync();
            bind.channel().closeFuture().sync();
            //上边表示一直在线等待 死循环
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
