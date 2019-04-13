package cn.kungreat.netty.health;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

public class HealthInit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 添加 自带 自定意 处理器链  IdleStateHandler 超时
        pipeline.addLast(new IdleStateHandler(5,7,10));
        pipeline.addLast(new HealthHandler());
    }
}