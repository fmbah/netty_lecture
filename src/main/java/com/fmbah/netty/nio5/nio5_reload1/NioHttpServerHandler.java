package com.fmbah.netty.nio5.nio5_reload1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @ClassName NioHttpServerHandler
 * @Description
 * @Author root
 * @Date 18-11-26 下午2:54
 * @Version 1.0
 **/
public class NioHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        ByteBuf copiedBuffer = Unpooled.copiedBuffer("reload2.....", CharsetUtil.UTF_8);
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, copiedBuffer);

        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, copiedBuffer.readableBytes());

        ctx.writeAndFlush(defaultFullHttpResponse);
        ctx.close();
    }
}
