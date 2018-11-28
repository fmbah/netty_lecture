package com.fmbah.netty.nio12;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName NioProtobufServerHandler12
 * @Description
 * @Author root
 * @Date 18-11-28 下午1:48
 * @Version 1.0
 **/
public class NioProtobufServerHandler12 extends SimpleChannelInboundHandler<AddressBookProtos.AddressBook> {

    private static final Logger logger = LoggerFactory.getLogger(NioProtobufServerHandler12.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddressBookProtos.AddressBook msg) throws Exception {

        logger.info("ctx.channel: {},  msg.getPeopleCount(): {}", ctx.channel(), msg.getPeopleCount());

        for (AddressBookProtos.Person person : msg.getPeopleList()) {
            logger.info("id: {}, name: {}, email: {}, phone num: {}, phone type: {}",
                    person.getId(), person.getName(), person.getEmail(),
                    person.getPhonesList().get(0).getNumber(), person.getPhonesList().get(0).getType());
        }
    }
}
