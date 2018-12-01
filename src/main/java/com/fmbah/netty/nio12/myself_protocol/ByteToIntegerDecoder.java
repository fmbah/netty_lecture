package com.fmbah.netty.nio12.myself_protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ClassName ByteToIntegerDecoder
 * @Description 自定义解码器(bytes->int)
 * @Author root
 * @Date 18-11-30 下午2:30
 * @Version 1.0
 **/
public class ByteToIntegerDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //Check if there are at least 4 bytes readable
        if (in.readableBytes() >= 4) {
            int n = in.readInt();
            System.out.println("ByteToIntegerDecoder decode msg is " + n);
            // Read integer from inbound ByteBuf
            // add to the List of decodec messages
            out.add(n);
        }
    }
}
