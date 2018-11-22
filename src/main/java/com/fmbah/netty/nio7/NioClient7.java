package com.fmbah.netty.nio7;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName NioClient7
 * @Description
 * @Author root
 * @Date 18-11-22 下午7:08
 * @Version 1.0
 **/
public class NioClient7 {
    public static void main(String args[]) throws Exception {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).
                    handler(new NioClientInitializer7());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8099).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
