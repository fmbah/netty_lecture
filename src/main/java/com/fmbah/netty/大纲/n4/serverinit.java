package com.fmbah.netty.大纲.n4;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName serverinit
 * @Description
 * @Author root
 * @Date 19-2-23 上午10:29
 * @Version 1.0
 **/
public class serverinit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new IdleStateHandler(1,2,3, TimeUnit.SECONDS));
        ch.pipeline().addLast(new StringEncoder());
        ch.pipeline().addLast(new StringDecoder());
        ch.pipeline().addLast("", new serverhandler());
    }
}
