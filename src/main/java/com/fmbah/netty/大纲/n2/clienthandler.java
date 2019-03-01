package com.fmbah.netty.大纲.n2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName clienthandler
 * @Description
 * @Author root
 * @Date 19-2-22 上午10:39
 * @Version 1.0
 **/
public class clienthandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("server: " + msg);
        ctx.writeAndFlush("client say....");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("client active....");
    }
}
