package com.fmbah.netty.nio8_9.nio8_9reload1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName NioChatClient8_9R1Handler
 * @Description
 * @Author root
 * @Date 18-11-26 下午4:19
 * @Version 1.0
 **/
public class NioChatClient8_9R1Handler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
