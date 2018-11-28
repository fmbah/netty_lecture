package com.fmbah.netty.nio12;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName NioProtobufClient12
 * @Description
 * @Author root
 * @Date 18-11-28 下午1:52
 * @Version 1.0
 **/
public class NioProtobufClient12 {

    public static void main(String[] args) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new NioProtobufClientInitializer12());
            Channel channel = bootstrap.connect("localhost", 8099).sync().channel();
            channel.closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
