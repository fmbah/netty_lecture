package com.fmbah.netty.nio7.nio7_reload0;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName NioServerHandlerReload0
 * @Description
 * @Author root
 * @Date 18-11-23 上午10:09
 * @Version 1.0
 **/
public class NioServerHandlerReload0 extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("请求端地址: " + ctx.channel().remoteAddress() + " , 消息: " + msg);

        ctx.writeAndFlush("服务器端收到消息后,回复客户端一个消息......");
        Thread.sleep(1000);
    }
}
