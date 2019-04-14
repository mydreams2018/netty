package cn.kungreat.netty.protoc.client;

import cn.kungreat.netty.domain.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<Student.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Student.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Student.Person src = Student.Person.newBuilder().setAge(33).setFirstName("kun").setLastName("great")
                .setSex(true).setId(1).build();
        ctx.channel().writeAndFlush(src);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}