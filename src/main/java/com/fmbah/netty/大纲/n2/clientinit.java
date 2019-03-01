package com.fmbah.netty.大纲.n2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @ClassName clientinit
 * @Description
 * @Author root
 * @Date 19-2-22 上午10:37
 * @Version 1.0
 **/
public class clientinit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
        pipeline.addLast(new LengthFieldPrepender(4));
        pipeline.addLast("StringEncoder", new StringEncoder());
        pipeline.addLast("StringDecoder", new StringDecoder());
        pipeline.addLast("serverhandler", new clienthandler());
    }
}
