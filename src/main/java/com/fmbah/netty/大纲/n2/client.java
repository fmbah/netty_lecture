package com.fmbah.netty.大纲.n2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @ClassName client
 * @Description
 * @Author root
 * @Date 19-2-22 上午10:34
 * @Version 1.0
 **/
public class client {

    public static void main(String[] args) {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker).channel(NioSocketChannel.class).handler(new clientinit());
            ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress("localhost", 8099)).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }
    }

}
