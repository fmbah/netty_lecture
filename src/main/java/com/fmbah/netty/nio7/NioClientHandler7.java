package com.fmbah.netty.nio7;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @ClassName NioClientHandler7
 * @Description
 * @Author root
 * @Date 18-11-22 下午7:14
 * @Version 1.0
 **/
public class NioClientHandler7 extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "," + msg);

        ctx.writeAndFlush("from client: " + LocalDateTime.now());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("from the server msg.....");
        Thread.sleep(1000);
        super.channelActive(ctx);
    }
}
