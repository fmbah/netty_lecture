package com.fmbah.netty.大纲.n2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName serverhandler
 * @Description
 * @Author root
 * @Date 19-2-22 上午10:24
 * @Version 1.0
 **/
public class serverhandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
        ctx.writeAndFlush(msg);
    }
}
