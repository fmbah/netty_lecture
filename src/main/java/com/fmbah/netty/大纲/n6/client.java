package com.fmbah.netty.大纲.n6;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName client
 * @Description
 * @Author root
 * @Date 19-2-25 上午9:46
 * @Version 1.0
 **/
public class client {
    public static void main(String[] args) {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap client = new Bootstrap();
            client.group(worker).channel(NioSocketChannel.class).handler(new clientinit());
            ChannelFuture channelFuture = client.connect("localhost", 8099).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }
    }
}
