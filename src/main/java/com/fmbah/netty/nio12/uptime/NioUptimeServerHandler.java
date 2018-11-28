package com.fmbah.netty.nio12.uptime;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName NioUptimeServerHandler
 * @Description
 * @Author root
 * @Date 18-11-27 下午5:40
 * @Version 1.0
 **/
@ChannelHandler.Sharable
public class NioUptimeServerHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        //discard message
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
