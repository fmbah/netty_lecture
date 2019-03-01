package com.fmbah.netty.大纲.n3;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

/**
 * @ClassName client
 * @Description
 * @Author root
 * @Date 19-2-23 上午9:48
 * @Version 1.0
 **/
public class client {
    public static void main(String[] args) {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap client = new Bootstrap();
            client.group(worker).channel(NioSocketChannel.class).handler(new clientinit());
            Channel channel = client.connect(new InetSocketAddress("localhost", 8099)).sync().channel();


            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for(;;) {
                String line = reader.readLine();
                if(null == line || "".equals(line)) {
                    continue;
                }



                if ("bye".equals(line)) {
                    channel.closeFuture().sync();
                }

                channel.writeAndFlush(line + "\r\n");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }
    }
}
