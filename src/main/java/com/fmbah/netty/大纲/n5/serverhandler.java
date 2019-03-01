package com.fmbah.netty.大纲.n5;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.Locale;

/**
 * @ClassName serverhandler
 * @Description
 * @Author root
 * @Date 19-2-23 上午11:07
 * @Version 1.0
 **/
public class serverhandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
        if (msg instanceof TextWebSocketFrame) {
            String text = ((TextWebSocketFrame) msg).text();
            System.out.println(ctx.channel().remoteAddress() + ", msg: " + text);
            ctx.channel().writeAndFlush(new TextWebSocketFrame(text.toUpperCase(Locale.US)));
        } else {
            throw new UnsupportedOperationException("不支持的类型" + msg.getClass().getName());
        }
    }
}
