package com.fmbah.netty.nio7.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

/**
 * @ClassName NioDiscardServer
 * @Description 演示客户端向服务器端发送洪水数据流
 *
 *
 * refer to: https://stackoverflow.com/questions/51213949/netty-echo-server-client-ssl-doesnt-work
 * If you want to enable SSL in this example you should start it with "-Dssl" which will enable SSL for the example.
 *
 * Netty itself also includes some scripts to make it easier when you checkout the source from git:
 *
 * ./run-example.sh -Dssl echo-server
 * ./run-example.sh -Dssl echo-client
 *
 *
 * @Author root
 * @Date 18-11-27 下午4:50
 * @Version 1.0
 **/
public class NioDiscardServer {

    static final boolean SSL = System.getProperty("ssl") != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", "8099"));

    public static void main (String args[]) throws Exception{
        final SslContext sslContext;//Configure ssl
        if (SSL) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslContext = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        } else {
            sslContext = null;
        }

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            if (sslContext != null) {
                                pipeline.addLast(sslContext.newHandler(ch.alloc()));
                            }

                            pipeline.addLast("NioDiscardServerHandler", new NioDiscardServerHandler());

                        }
                    });
            Channel channel = serverBootstrap.bind(PORT).sync().channel();
            channel.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
