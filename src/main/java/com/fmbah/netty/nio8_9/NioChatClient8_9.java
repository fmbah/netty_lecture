package com.fmbah.netty.nio8_9;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName NioChatClient8_9
 * @Description
 * @Author root
 * @Date 18-11-23 上午10:43
 * @Version 1.0
 **/
public class NioChatClient8_9 {
    public static void main (String args[]) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new NioChatClient8_9Initializer());

            Channel channel = bootstrap.connect("localhost", 8099).sync().channel();
            ChannelFuture channelFuture = null;

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            for(;;) {
                String line = bufferedReader.readLine();
                if (line != null && !"".equals(line)) {
                    channel.writeAndFlush(line + "\r\n");
                }

                if ("bye".equals(line.toLowerCase())) {
                    channel.closeFuture().sync();
                    break;
                }
            }

            if (channelFuture != null) {
                channelFuture.sync();
            }

        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
