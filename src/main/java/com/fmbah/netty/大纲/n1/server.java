package com.fmbah.netty.大纲.n1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName server
 * @Description
 * @Author root
 * @Date 19-2-22 上午9:27
 * @Version 1.0
 **/
public class server {

    public static void main(String[] args) {
        NioEventLoopGroup master = new NioEventLoopGroup();
        NioEventLoopGroup slaver = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(master, slaver)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new init());
            ChannelFuture channelFuture = serverBootstrap.bind(8099).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            master.shutdownGracefully();
            slaver.shutdownGracefully();
        }
    }

}
