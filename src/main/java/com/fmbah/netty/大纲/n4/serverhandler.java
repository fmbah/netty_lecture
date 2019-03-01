package com.fmbah.netty.大纲.n4;

import io.netty.handler.timeout.IdleStateEvent;

/**
 * @ClassName serverhandler
 * @Description
 * @Author root
 * @Date 19-2-23 上午10:25
 * @Version 1.0
 **/
public class serverhandler extends io.netty.channel.ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(io.netty.channel.ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            String eventType = null;
            switch (idleStateEvent.state()){
                case READER_IDLE: eventType = "读";break;
                case WRITER_IDLE: eventType = "写"; break;
                case ALL_IDLE: eventType = "读写"; break;
            }
            System.out.println(ctx.channel() + ":" + eventType);
            ctx.close();
        }
    }
}
