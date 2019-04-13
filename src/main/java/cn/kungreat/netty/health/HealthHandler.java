package cn.kungreat.netty.health;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class HealthHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent)evt;
            IdleState state = idleStateEvent.state();
            String event ="";
            switch (state){
                case READER_IDLE:
                    event="读空间";
                    break;
                case WRITER_IDLE:
                    event="写空间";
                    break;
                case ALL_IDLE:
                     event="全部空间";
                     break;
            }
            System.out.println(event);
            ctx.channel().close();
        }
    }
}