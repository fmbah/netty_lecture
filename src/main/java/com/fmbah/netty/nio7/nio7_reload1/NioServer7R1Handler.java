package com.fmbah.netty.nio7.nio7_reload1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @ClassName NioServer7R1Handler
 * @Description
 * @Author root
 * @Date 18-11-26 下午3:15
 * @Version 1.0
 **/
public class NioServer7R1Handler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("地址: " + ctx.channel().remoteAddress() + ", 消息: " + msg);

        ctx.writeAndFlush("服务器时间戳: " + LocalDateTime.now());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
