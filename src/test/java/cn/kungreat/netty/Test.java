package cn.kungreat.netty;

import cn.kungreat.netty.socket.mall.client.MallInit;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        // 快速启动服务器
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup).channel(NioSocketChannel.class)
                .handler(new MallInit());
        try {
            ChannelFuture bind = bootstrap.connect("localhost",80).sync();
//            bind.channel().closeFuture().sync();
//            //上边表示一直在线等待 死循环
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                bind.channel().writeAndFlush(reader.readLine());
                System.out.println(11222);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(workGroup != null){
                workGroup.shutdownGracefully();
            }
        }
    }
}