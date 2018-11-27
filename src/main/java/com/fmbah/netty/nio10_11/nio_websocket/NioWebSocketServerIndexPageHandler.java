package com.fmbah.netty.nio10_11.nio_websocket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.CharsetUtil;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static io.netty.handler.codec.rtsp.RtspResponseStatuses.BAD_REQUEST;
import static io.netty.handler.codec.rtsp.RtspResponseStatuses.FORBIDDEN;
import static io.netty.handler.codec.rtsp.RtspResponseStatuses.NOT_FOUND;

/**
 * @ClassName NioWebSocketServerIndexPageHandler
 * @Description
 * @Author root
 * @Date 18-11-27 上午10:45
 * @Version 1.0
 **/
public class NioWebSocketServerIndexPageHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final String websocketPath;
    public NioWebSocketServerIndexPageHandler (String websocketPath) {
        this.websocketPath = websocketPath;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        // Handle a bad request.
        if (!msg.decoderResult().isSuccess()) {
            sendHttpResponse(ctx, msg, new DefaultFullHttpResponse(HTTP_1_1, BAD_REQUEST));
            return;
        }

        // Allow only get methods
        if (msg.method() != HttpMethod.GET) {
            sendHttpResponse(ctx, msg, new DefaultFullHttpResponse(HTTP_1_1, FORBIDDEN));
            return;
        }

        //send the index page
        if (msg.uri().equals("/") || msg.uri().equals("/index.html")) {
            String webSocketLocation = getWebSocketLocation(ctx.pipeline(), msg, websocketPath);
            ByteBuf content = NioWebSocketServerIndexPage.getContent(webSocketLocation);
            FullHttpResponse res = new DefaultFullHttpResponse(HTTP_1_1, OK, content);
            res.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");
            HttpUtil.setContentLength(res, content.readableBytes());
            sendHttpResponse(ctx, msg, res);
        } else {
            sendHttpResponse(ctx, msg, new DefaultFullHttpResponse(HTTP_1_1, NOT_FOUND));
        }
    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res) {
        // Generate an error page if response getStatus code is not ok 200
        if (res.status().code() != 200) {
            ByteBuf byteBuf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(byteBuf);
            byteBuf.release();
            HttpUtil.setContentLength(res, res.content().readableBytes());
        }

        // Send the response and close the connection if necessary.
        ChannelFuture channelFuture = ctx.channel().writeAndFlush(res);
        if (!HttpUtil.isKeepAlive(req) || res.status().code() != 200) {
            channelFuture.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private static String getWebSocketLocation(ChannelPipeline pipeline, HttpRequest req, String path) {
        String protocol = "ws";
        if (pipeline.get(SslHandler.class) != null) {
            //SSl in use to user Secure WebSockets
            protocol = "wss";
        }

        return protocol + "://" + req.headers().get(HttpHeaderNames.HOST) + path;
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
