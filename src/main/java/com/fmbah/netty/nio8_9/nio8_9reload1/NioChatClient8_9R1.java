package com.fmbah.netty.nio8_9.nio8_9reload1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName NioChatClient8_9R1
 * @Description
 * @Author root
 * @Date 18-11-26 下午4:08
 * @Version 1.0
 **/
public class NioChatClient8_9R1 {
    public static void main (String args[]) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new NioChatClient8_9R1Initializer());
            Channel channel = bootstrap.connect("localhost", 8099).sync().channel();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                String readLine = reader.readLine();
                if (readLine != null && !readLine.equals("")) {
                    channel.writeAndFlush(readLine + "\r\n");
                }
                if ("bye".equals(readLine.toLowerCase())) {
                    break;
                }
            }
            channel.closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
