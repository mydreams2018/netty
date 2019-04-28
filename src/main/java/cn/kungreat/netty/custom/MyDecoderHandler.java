package cn.kungreat.netty.custom;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MyDecoderHandler extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("进入自定意解码器");
        System.out.println("byte总长度"+in.readableBytes());
        // 传输long 型
        if(in.readableBytes() >= 8){
            out.add(in.readLong());
        }
    }
}
