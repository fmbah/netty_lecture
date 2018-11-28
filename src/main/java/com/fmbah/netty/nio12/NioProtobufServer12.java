package com.fmbah.netty.nio12;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @ClassName NioProtobufServer12
 * @Description
 *
 * 使用google protobuf进行不同jvm间的数据传输
 * 利用protobuf编译器生成java源码
 * ./protoc -I=/root --java_out=/root/IdeaProjects/distributed/netty_lecture/src/main/java/  /root/IdeaProjects/distributed/netty_lecture/src/main/resources/protobuf/addressbook.proto
 *
 * @Author root
 * @Date 18-11-28 上午11:02
 * @Version 1.0
 **/
public class NioProtobufServer12 {

    public static void main(String[] args) throws Exception{
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try {
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new NioProtobufServerInitializer12());

            ChannelFuture channelFuture = serverBootstrap.bind(8099).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
