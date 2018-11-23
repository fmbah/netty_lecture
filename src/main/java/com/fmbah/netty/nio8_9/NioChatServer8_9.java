package com.fmbah.netty.nio8_9;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName NioChatServer8_9
 * @Description
 *
 * 实现功能:
 *          启动服务器后,其它客户端链接后,向除了链接的客户端以外的客户端发送当前客户端上线了
 *                     当客户端发送消息时,向所有客户端发送消息(区别开是否为自己发送的)
 *
 * @Author root
 * @Date 18-11-23 上午10:23
 * @Version 1.0
 **/
public class NioChatServer8_9 {

    public static void main (String args[]) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new NioChatServer8_9Initializer());
            ChannelFuture channelFuture = serverBootstrap.bind(8099).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
