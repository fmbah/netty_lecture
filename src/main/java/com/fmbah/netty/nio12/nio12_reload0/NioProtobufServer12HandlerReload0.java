package com.fmbah.netty.nio12.nio12_reload0;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName NioProtobufServer12HandlerReload0
 * @Description
 * @Author root
 * @Date 18-11-30 上午9:23
 * @Version 1.0
 **/
public class NioProtobufServer12HandlerReload0 extends SimpleChannelInboundHandler<MessageInfo.AllMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageInfo.AllMessage allMessage) throws Exception {
        if (1 == allMessage.getMessageType().getNumber()) {
            MessageInfo.CarType carType = allMessage.getCarType();
            System.out.println(carType.getBrandName() + ", " + carType.getLocation() + ", " + carType.getYears());
        } else if (2 == allMessage.getMessageType().getNumber()) {
            MessageInfo.HouseType houseType = allMessage.getHouseType();
            System.out.println(houseType.getVillage() + ", " + houseType.getSize() + ", " + houseType.getPrice());
        }
    }
}
