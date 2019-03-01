package com.fmbah.netty.大纲.n3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName clienthandler
 * @Description
 * @Author root
 * @Date 19-2-23 上午9:46
 * @Version 1.0
 **/
public class clienthandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
