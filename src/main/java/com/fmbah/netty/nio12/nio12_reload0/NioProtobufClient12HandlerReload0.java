package com.fmbah.netty.nio12.nio12_reload0;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @ClassName NioProtobufClient12HandlerReload0
 * @Description
 * @Author root
 * @Date 18-11-30 上午9:27
 * @Version 1.0
 **/
public class NioProtobufClient12HandlerReload0 extends SimpleChannelInboundHandler<MessageInfo.AllMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageInfo.AllMessage msg) throws Exception {
        //discard
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int anInt = new Random().nextInt(2);
        MessageInfo.AllMessage allMessage = null;
        if (0 == anInt) {
            allMessage = MessageInfo.AllMessage.newBuilder().
                    setMessageType(MessageInfo.AllMessage.MessageType.HOUSE).
                    setHouseType(MessageInfo.HouseType.newBuilder().setPrice(999).setSize(300).setVillage("世纪花园").build()).
                    build();
        } else if (1 == anInt) {
            allMessage = MessageInfo.AllMessage.newBuilder().
                    setMessageType(MessageInfo.AllMessage.MessageType.CAR).
                    setCarType(MessageInfo.CarType.newBuilder().setBrandName("宝马X5").setLocation("上海").setYears(2017).build()).
                    build();
        }

        ctx.writeAndFlush(allMessage);
    }
}
