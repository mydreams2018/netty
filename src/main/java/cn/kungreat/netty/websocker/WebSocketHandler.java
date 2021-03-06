package cn.kungreat.netty.websocker;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
/*
* WebSocketFrame  有6种实现类型 返回必须要遵守这6种类型
*/
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println(msg.text());
        ctx.writeAndFlush(new TextWebSocketFrame("websocket answer"));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //每个 channel 都有一个唯一的id
        System.out.println("add"+ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("remove"+ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}