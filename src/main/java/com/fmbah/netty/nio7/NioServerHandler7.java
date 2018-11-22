package com.fmbah.netty.nio7;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @ClassName NioServerHandler7
 * @Description
 * @Author root
 * @Date 18-11-22 下午7:03
 * @Version 1.0
 **/
public class NioServerHandler7 extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {//ctx:上下文,请求对象

        System.out.println(ctx.channel().remoteAddress() + "," + msg);

        //向客户端写回数据
        ctx.writeAndFlush("server copy...." + UUID.randomUUID());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
