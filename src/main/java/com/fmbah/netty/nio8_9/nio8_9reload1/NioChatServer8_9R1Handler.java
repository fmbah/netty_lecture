package com.fmbah.netty.nio8_9.nio8_9reload1;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName NioChatServer8_9R1Handler
 * @Description
 * @Author root
 * @Date 18-11-26 下午3:59
 * @Version 1.0
 **/
public class NioChatServer8_9R1Handler extends SimpleChannelInboundHandler<String> {

    static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     *
     * 功能描述: 服务器端中转客户端发过来的消息给每一个在线的客户端....
     *
     * @param:
     * @return:
     * @auther: Fmbah
     * @date: 18-11-26 下午4:00
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println("客户端地址: " + ctx.channel().remoteAddress() + ", 消息: " + msg + "\r\n");
        Channel channel = ctx.channel();
        channels.forEach(ch -> {
            if (channel != ch) {
                ch.writeAndFlush("地址: " + ch.remoteAddress() + "其它客户: " + msg + "\r\n");
            } else {
                ch.writeAndFlush("地址: " + ch.remoteAddress() + "本客户: " + msg + "\r\n");
            }
        });

        if ("bye".equals(msg.toLowerCase())) {
            ctx.close();
        }
    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded.....");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive.....");
        channels.forEach(ch -> {
            ch.writeAndFlush("地址: " + ch.remoteAddress() + ", 上线...." + "\r\n");
        });
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved.....");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive.....");
        channels.forEach(ch -> {
            ch.writeAndFlush("地址: " + ch.remoteAddress() + ", 下线...." + "\r\n");
        });
    }
}
