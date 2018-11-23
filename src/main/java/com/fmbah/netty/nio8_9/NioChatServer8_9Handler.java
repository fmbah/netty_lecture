package com.fmbah.netty.nio8_9;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName NioChatServer8_9Handler
 * @Description
 * @Author root
 * @Date 18-11-23 上午10:31
 * @Version 1.0
 **/
public class NioChatServer8_9Handler extends SimpleChannelInboundHandler<String> {

    static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);//全局channel缓存组

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("客户端: " + ctx.channel().remoteAddress() + ", 消息: " + msg);

        channelGroup.forEach(ch -> {
            if (ch != ctx.channel()) {
                ch.writeAndFlush("服务器: " + ctx.channel().remoteAddress() + ", 消息: " + msg + "\r\n");
            } else {
                ch.writeAndFlush("自己: " + ctx.channel().remoteAddress() + ", 消息: " + msg + "\r\n");
            }
        });

        if ("bye".equals(msg.toLowerCase())) {
            ctx.close();
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        channelGroup.forEach(ch -> {
            ch.writeAndFlush("服务器: " + ctx.channel().remoteAddress() + ", 下线\r\n");
        });
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channelGroup.forEach(ch -> {
            ch.writeAndFlush("服务器: " + ctx.channel().remoteAddress() + ", 上线\r\n");
        });
        channelGroup.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务器: " + ctx.channel().remoteAddress() + "离开 \r\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
