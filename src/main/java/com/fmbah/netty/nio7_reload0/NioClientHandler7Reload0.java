package com.fmbah.netty.nio7_reload0;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName NioClientHandler7Reload0
 * @Description
 * @Author root
 * @Date 18-11-23 上午10:18
 * @Version 1.0
 **/
public class NioClientHandler7Reload0 extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("接收到服务器端: " + ctx.channel().remoteAddress() + ", 消息: " + msg);

        ctx.writeAndFlush("客户端回复服务器消息....");

        Thread.sleep(1000);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("客户端第一次建立链接后,主动向服务器端发送请求.....");
    }
}
