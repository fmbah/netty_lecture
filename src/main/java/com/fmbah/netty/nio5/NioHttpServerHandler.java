package com.fmbah.netty.nio5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @ClassName NioHttpServerHandler
 * @Description
 *
     * handler added
     * channel registered
     * channel active
     * class io.netty.handler.codec.http.DefaultHttpRequest
     * /0:0:0:0:0:0:0:1:34794
     * 请求方法名: PUT
     * channel inactive
     * channel Unregistered
     * channel handlerRemoved
 *
 * @Author root
 * @Date 18-11-20 下午6:57
 * @Version 1.0
 **/
public class NioHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {//读取客户端发出的请求,返回相应响应
        if (msg instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest)msg;

            System.out.println(msg.getClass());
            System.out.println(ctx.channel().remoteAddress());
            System.out.println("请求方法名: " + httpRequest.getMethod().name());

            Thread.sleep(10000);
            //lsof -i :8099
            //COMMAND   PID USER   FD   TYPE  DEVICE SIZE/OFF NODE NAME
            //java    30134 root   42u  IPv6 1363445      0t0  TCP *:8099 (LISTEN)
            //java    30134 root   43u  IPv6 1371434      0t0  TCP localhost:8099->localhost:48244 (ESTABLISHED)
            //curl    30198 root    3u  IPv6 1365767      0t0  TCP localhost:48244->localhost:8099 (ESTABLISHED)

            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("/favicon.ico ");
                return;
            }

            ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(response);
            ChannelFuture channelFuture = ctx.close();//HTTP1.1 3S超时后,服务器端主动关闭, HTTP1.0 每次链接后,服务器关闭链接
        }
    }


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel inactive");
        super.channelInactive(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler added");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Unregistered");
        super.channelUnregistered(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel handlerRemoved");
        super.handlerRemoved(ctx);
    }
}
