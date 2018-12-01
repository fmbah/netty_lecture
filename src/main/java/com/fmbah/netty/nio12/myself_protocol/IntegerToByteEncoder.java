package com.fmbah.netty.nio12.myself_protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @ClassName IntegerToByteEncoder
 * @Description 自定义编码器(int->bytes)
 * @Author root
 * @Date 18-11-30 下午2:28
 * @Version 1.0
 **/
public class IntegerToByteEncoder extends MessageToByteEncoder<Integer> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Integer msg, ByteBuf out) throws Exception {
        System.out.println("IntegerToByteEncoder encode msg is " + msg);
        out.writeInt(msg);
    }
}
