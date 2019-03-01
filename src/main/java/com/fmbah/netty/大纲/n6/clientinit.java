package com.fmbah.netty.大纲.n6;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import protocol.AddressBookProtosDemo;

/**
 * @ClassName clientinit
 * @Description
 * @Author root
 * @Date 19-2-25 上午9:46
 * @Version 1.0
 **/
public class clientinit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(AddressBookProtosDemo.AddressBookDemo.getDefaultInstance()));
        pipeline.addLast(new ProtobufEncoder());
        pipeline.addLast("clienthandler", new clienthandler());
    }
}
