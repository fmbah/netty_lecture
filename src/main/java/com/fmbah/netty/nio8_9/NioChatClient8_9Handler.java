package com.fmbah.netty.nio8_9;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName NioChatClient8_9Handler
 * @Description
 * @Author root
 * @Date 18-11-23 上午10:47
 * @Version 1.0
 **/
public class NioChatClient8_9Handler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
