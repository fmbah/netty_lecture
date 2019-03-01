package com.fmbah.netty.大纲.n5;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;

/**
 * @ClassName serverinit
 * @Description
 * @Author root
 * @Date 19-2-23 上午11:11
 * @Version 1.0
 **/
public class serverinit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new HttpServerCodec());
        ch.pipeline().addLast(new HttpObjectAggregator(65536));
        ch.pipeline().addLast(new WebSocketServerCompressionHandler());
        ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws", null, true));
        ch.pipeline().addLast("serverhandler", new serverhandler());
    }
}
