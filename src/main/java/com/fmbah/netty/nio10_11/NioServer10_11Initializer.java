package com.fmbah.netty.nio10_11;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;

/**
 * @ClassName NioServer10_11Initializer
 * @Description
 * @Author root
 * @Date 18-11-27 下午1:50
 * @Version 1.0
 **/
public class NioServer10_11Initializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new WebSocketServerCompressionHandler());
        //此处有个小问题,记得加上'/',我之前一直没加'/',导致一直在客户端建立链接,
        //websocket.html?_ijt=v9nr426pp987pk5021heic2i0f:31 Uncaught DOMException: Failed to execute 'send' on 'WebSocket': Still in CONNECTING state.
        //    at send (http://localhost:63342/netty_lecture/netty_lecture_main/webapps/websocket.html?_ijt=v9nr426pp987pk5021heic2i0f:31:28)
        //    at HTMLInputElement.onclick (http://localhost:63342/netty_lecture/netty_lecture_main/webapps/websocket.html?_ijt=v9nr426pp987pk5021heic2i0f:41:74)
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws", null, true));

        pipeline.addLast("NioServer10_11Handler", new NioServer10_11Handler());
    }
}
