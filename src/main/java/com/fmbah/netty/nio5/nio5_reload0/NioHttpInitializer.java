package com.fmbah.netty.nio5.nio5_reload0;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName NioHttpInitializer
 * @Description
 * @Author root
 * @Date 18-11-22 上午11:05
 * @Version 1.0
 **/
public class NioHttpInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        pipeline.addLast("nioHttpServerHandler", new NioHttpServerHandler());
    }
}
