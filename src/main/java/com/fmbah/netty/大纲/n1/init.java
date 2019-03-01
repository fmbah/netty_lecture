package com.fmbah.netty.大纲.n1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName init
 * @Description
 * @Author root
 * @Date 19-2-22 上午9:37
 * @Version 1.0
 **/
public class init extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("HttpServerCodec", new HttpServerCodec());
        ch.pipeline().addLast("handler", new handler());
    }
}
