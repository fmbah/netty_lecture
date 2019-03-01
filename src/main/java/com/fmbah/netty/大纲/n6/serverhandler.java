package com.fmbah.netty.大纲.n6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.AddressBookProtosDemo;

/**
 * @ClassName serverhandler
 * @Description
 * @Author root
 * @Date 19-2-25 上午9:32
 * @Version 1.0
 **/
public class serverhandler extends SimpleChannelInboundHandler<protocol.AddressBookProtosDemo.AddressBookDemo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddressBookProtosDemo.AddressBookDemo msg) throws Exception {
        System.out.println("server: " + ctx.channel().remoteAddress());
        msg.getPersonsList().forEach(personDemo -> System.out.println(personDemo));
        ctx.writeAndFlush(msg);
    }
}
