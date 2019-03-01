package com.fmbah.netty.大纲.n6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.AddressBookProtosDemo;

/**
 * @ClassName clienthandler
 * @Description
 * @Author root
 * @Date 19-2-25 上午9:46
 * @Version 1.0
 **/
public class clienthandler extends SimpleChannelInboundHandler<protocol.AddressBookProtosDemo.AddressBookDemo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddressBookProtosDemo.AddressBookDemo msg) throws Exception {
        System.out.println("client: " + ctx.channel().remoteAddress());
        msg.getPersonsList().forEach(personDemo -> System.out.println(personDemo));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        AddressBookProtosDemo.PersonDemo personDemo = AddressBookProtosDemo.PersonDemo.newBuilder().setId(1).setName("z").setEmail("xxxxx").build();
        AddressBookProtosDemo.AddressBookDemo addressBookDemo = AddressBookProtosDemo.AddressBookDemo.newBuilder().addPersons(personDemo).build();
        ctx.writeAndFlush(addressBookDemo);
    }
}
