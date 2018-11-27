package com.fmbah.netty.nio7.nio7_reload1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @ClassName NioClient7R1Handler
 * @Description
 * @Author root
 * @Date 18-11-26 下午3:41
 * @Version 1.0
 **/
public class NioClient7R1Handler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("服务器端地址: " + ctx.channel().remoteAddress() + ", 消息: " + msg);
        ctx.writeAndFlush(UUID.randomUUID() + "");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("客户端向服务端发送第一次数据....");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
