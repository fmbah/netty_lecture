package com.fmbah.netty.nio12.myself_protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

/**
 * @ClassName CustomProtocolClientHandler
 * @Description
 * @Author root
 * @Date 18-11-30 下午3:04
 * @Version 1.0
 **/
public class CustomProtocolClientHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            Integer body = (Integer)msg;
            System.out.println("Client: from Server: " + body);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(123123);
    }
}
