package com.fmbah.netty.nio5;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName NioHttpServer
 * @Description
 * @Author root
 * @Date 18-11-20 下午6:48
 * @Version 1.0
 **/
public class NioHttpServer {
    public static void main (String args[]) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();//老板工作组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();//工人工作组

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();//简易服务器
            serverBootstrap.group(bossGroup, workerGroup)//老板工作组接收请求后,工人工作组将请求处理
                    .channel(NioServerSocketChannel.class)//创建了一个管道
                    .childHandler(new NioHttpInitializer());//自定义管道处理器

            ChannelFuture channelFuture = serverBootstrap.bind(8099).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

