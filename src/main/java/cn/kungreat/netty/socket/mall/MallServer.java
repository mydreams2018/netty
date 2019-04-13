package cn.kungreat.netty.socket.mall;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class MallServer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
  /*      添加 自带 自定意 处理器链  HttpServerCodec 编解码
        因为TCP在发送过程用可能会发生粘包拆包问题，netty中给了我们很好的解决方法，
        就是每次发送消息是已特殊的符号（可自定义）$_ 结尾，只收收到的消息以$_ 符号结尾是该消息才算接收完毕。
        pipeline.addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Unpooled.copiedBuffer("$_".getBytes())));
        pipeline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
   */
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast(new MallHandler());
    }
}
