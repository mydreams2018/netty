package cn.kungreat.netty.socket.mall;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MallHandler extends SimpleChannelInboundHandler<String> {
    // 如果掉线 会自动的删除保存的连接
    private static ChannelGroup channelGroup  = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel original = ctx.channel();
        channelGroup.writeAndFlush(msg, new ChannelMatcher() {
            @Override
            public boolean matches(Channel channel) {
                return original!=channel;
            }
        });
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"下线");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush(ctx.channel().remoteAddress() + "连接\ndoc", new ChannelMatcher() {
            @Override
            public boolean matches(Channel channel) {
                return true;
            }
        });
        channelGroup.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush(ctx.channel().remoteAddress() + "离线", new ChannelMatcher() {
            @Override
            public boolean matches(Channel channel) {
                return channel!=ctx.channel();
            }
        });

    }
}