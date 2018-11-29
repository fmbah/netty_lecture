package com.fmbah.netty.nio10_11.nio10_11reload0;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.time.LocalDateTime;

/**
 * @ClassName NioServer10_11HandlerReload0
 * @Description
 * @Author root
 * @Date 18-11-29 上午10:49
 * @Version 1.0
 **/
public class NioServer10_11HandlerReload0 extends SimpleChannelInboundHandler<WebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
        if (msg instanceof TextWebSocketFrame) {
            TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame) msg;
            System.out.println("ctx.channel: " + ctx.channel() + ", msg: " + textWebSocketFrame.text());
            ctx.channel().writeAndFlush(new TextWebSocketFrame(LocalDateTime.now().toString()));
        }
    }
}
