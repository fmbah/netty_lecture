package com.fmbah.netty.nio8_9reload0;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName NioChatClient8_9HandlerReload0
 * @Description
 * @Author root
 * @Date 18-11-23 下午2:30
 * @Version 1.0
 **/
public class NioChatClient8_9HandlerReload0 extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
