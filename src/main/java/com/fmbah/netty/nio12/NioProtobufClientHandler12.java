package com.fmbah.netty.nio12;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName NioProtobufClientHandler12
 * @Description
 * @Author root
 * @Date 18-11-28 下午1:58
 * @Version 1.0
 **/
public class NioProtobufClientHandler12 extends SimpleChannelInboundHandler<AddressBookProtos.AddressBook> {

    private static final Logger logger = LoggerFactory.getLogger(NioProtobufClientHandler12.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddressBookProtos.AddressBook msg) throws Exception {
        logger.info("ctx.channel: {},  msg.getPeopleCount(): {}", ctx.channel(), msg.getPeopleCount());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        AddressBookProtos.Person john =
                AddressBookProtos.Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhones(
                                AddressBookProtos.Person.PhoneNumber.newBuilder()
                                        .setNumber("555-4321")
                                        .setType(AddressBookProtos.Person.PhoneType.HOME))
                        .build();
        AddressBookProtos.AddressBook addressBook =
                AddressBookProtos.AddressBook.newBuilder().addPeople(john).build();

        ctx.channel().writeAndFlush(addressBook);
    }
}
