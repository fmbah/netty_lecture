package com.fmbah.netty.nio8_9reload0;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName NioChatServer8_9HandlerReload0
 * @Description
 * @Author root
 * @Date 18-11-23 下午2:07
 * @Version 1.0
 **/
public class NioChatServer8_9HandlerReload0 extends SimpleChannelInboundHandler<String> {

    static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channels.forEach(ch->{
            if (ch != channel) {
                ch.writeAndFlush("来自: " + ch.remoteAddress() + ", 消息: " + msg + "\r\n");
            } else {
                ch.writeAndFlush("我的: " + ch.remoteAddress() + ", 消息: " + msg + "\r\n");
            }
        });
        if ("exit".equals(msg)) {
            ctx.close();
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channels.forEach(ch->{
            ch.writeAndFlush("客户端: " + ch.remoteAddress() + ", 上线啦....\r\n");
        });
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channels.forEach(ch->{
            ch.writeAndFlush("客户端: " + ch.remoteAddress() + ", 下线啦....\r\n");
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }


}
