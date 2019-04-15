package cn.kungreat.netty.protoc;

import cn.kungreat.netty.domain.Company;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtocHandler extends SimpleChannelInboundHandler<Company.Data> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Company.Data msg) throws Exception {
        if(1 == msg.getTypeId()){
            Company.Dept dept = msg.getDept();
            System.out.println(dept.getId());
            System.out.println(dept.getName());
            System.out.println(dept.getDescription());
        }else{
            Company.Employee employee = msg.getEmployee();
            System.out.println(employee.getId());
            System.out.println(employee.getFirstName());
            System.out.println(employee.getLastName());
            System.out.println(employee.getPhone());
            System.out.println(employee.getAge());
            System.out.println(employee.getSex());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
