package com.fmbah.netty.nio5;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName NioHttpInitializer
 * @Description
 * @Author root
 * @Date 18-11-20 下午6:54
 * @Version 1.0
 **/
public class NioHttpInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("httpServerCodec", new HttpServerCodec());//请求 响应 编解码
        pipeline.addLast("nioHttpServerHandler", new NioHttpServerHandler());

    }
}
