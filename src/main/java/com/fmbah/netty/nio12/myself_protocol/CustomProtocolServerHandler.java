package com.fmbah.netty.nio12.myself_protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName CustomProtocolServerHandler
 * @Description
 * @Author root
 * @Date 18-11-30 下午2:37
 * @Version 1.0
 **/
public class CustomProtocolServerHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        //未加入解码器
//        ByteBuf byteBuf = (ByteBuf)msg;
//        byte[] req = new byte[byteBuf.readableBytes()];
//        byteBuf.readBytes(req);
//        String body = new String(req, "utf-8");
//        System.out.println("Server: from client: " + body);


        //加入解码器之后
        Integer body = (Integer)msg;
        System.out.println("Server: from client: " + body);
        ctx.writeAndFlush(33);

    }
}
