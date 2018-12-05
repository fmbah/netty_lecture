package com.fmbah.netty.nio9.nio9_reload1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @ClassName NioServer9HandlerReload1
 * @Description
 * @Author root
 * @Date 18-12-5 上午10:00
 * @Version 1.0
 **/
public class NioServer9HandlerReload1 extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        //discard
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = "";
            switch(event.state()){
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
            }
            System.err.println(ctx.channel().remoteAddress() + ", 事件: " + eventType);
        }
    }
}
