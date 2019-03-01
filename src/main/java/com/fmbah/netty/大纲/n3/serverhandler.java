package com.fmbah.netty.大纲.n3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName serverhandler
 * @Description
 * @Author root
 * @Date 19-2-22 下午1:47
 * @Version 1.0
 **/
public class serverhandler extends SimpleChannelInboundHandler<String> {
    static ChannelGroup globalChannel = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + ": " + msg);
        globalChannel.forEach(channel -> {
            if (channel == ctx.channel()) {
                channel.writeAndFlush("自己: " + msg + "\r\n");
            } else {
                channel.writeAndFlush(channel.remoteAddress() + ": " + msg+ "\r\n");
            }
        });
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        globalChannel.forEach(channel -> {
            channel.writeAndFlush(ctx.channel().remoteAddress() + ",上线了"+ "\r\n");
        });
        globalChannel.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        globalChannel.forEach(channel -> {
            channel.writeAndFlush(ctx.channel().remoteAddress() + ", 下线了"+ "\r\n");
        });
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        globalChannel.forEach(channel -> {
            channel.writeAndFlush(ctx.channel().remoteAddress() + ", 离开了"+ "\r\n");
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
