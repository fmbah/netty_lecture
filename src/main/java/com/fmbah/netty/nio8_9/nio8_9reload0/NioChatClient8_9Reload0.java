package com.fmbah.netty.nio8_9.nio8_9reload0;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName NioChatClient8_9Reload0
 * @Description
 * @Author root
 * @Date 18-11-23 下午2:21
 * @Version 1.0
 **/
public class NioChatClient8_9Reload0 {
    public static void main (String args[]) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .remoteAddress("localhost", 8099)
                    .handler(new NioChatClient8_9InitializerReload0());
            Channel channel = bootstrap.connect().sync().channel();
            ChannelFuture channelFuture = null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }

                channel.writeAndFlush(readLine + "\r\n");

                if (readLine.equals("exit")) {
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
