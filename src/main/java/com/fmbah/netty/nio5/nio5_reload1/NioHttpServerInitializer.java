package com.fmbah.netty.nio5.nio5_reload1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName NioHttpServerInitializer
 * @Description
 * @Author root
 * @Date 18-11-26 下午2:52
 * @Version 1.0
 **/
public class NioHttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast("NioHttpServerHandler", new NioHttpServerHandler());
    }
}
