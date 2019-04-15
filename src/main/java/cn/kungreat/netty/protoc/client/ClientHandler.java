package cn.kungreat.netty.protoc.client;

import cn.kungreat.netty.domain.Company;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<Company.Data> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Company.Data msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Company.Employee employee = Company.Employee.newBuilder().setId(1).setAge(30)
                .setFirstName("kun").setLastName("great").setSex(true).setPhone("18675788820")
                .build();
        Company.Data src = Company.Data.newBuilder().setTypeId(2).setEmployee(employee).build();
        ctx.channel().writeAndFlush(src);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}