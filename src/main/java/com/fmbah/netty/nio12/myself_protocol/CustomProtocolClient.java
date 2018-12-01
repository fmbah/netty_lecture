package com.fmbah.netty.nio12.myself_protocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName CustomProtocolClient
 * @Description
 * @Author root
 * @Date 18-11-30 下午2:41
 * @Version 1.0
 **/
public class CustomProtocolClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new IntegerToByteEncoder());
                            pipeline.addLast(new ByteToIntegerDecoder());

                            pipeline.addLast("CustomProtocolClientHandler", new CustomProtocolClientHandler());
                        }
                    });
            Channel channel = bootstrap.connect("localhost", 8099).sync().channel();
            channel.closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
