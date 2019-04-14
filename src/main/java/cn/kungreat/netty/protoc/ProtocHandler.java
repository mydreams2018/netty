package cn.kungreat.netty.protoc;

import cn.kungreat.netty.domain.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtocHandler extends SimpleChannelInboundHandler<Student.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Student.Person msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
