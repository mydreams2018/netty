package cn.kungreat.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class Child extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 添加 自带 自定意 处理器链  HttpServerCodec 编解码
        pipeline.addLast("http",new HttpServerCodec());
        // 把信息聚合在一起
        pipeline.addLast(new HttpObjectAggregator(8192));
        //目的是支持异步大文件传输
        pipeline.addLast( new ChunkedWriteHandler());
        pipeline.addLast("myHttp",new Http());
    }
}