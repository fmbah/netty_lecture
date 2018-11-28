package com.fmbah.netty.nio7.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName NioDiscardClientHandler
 * @Description
 * @Author root
 * @Date 18-11-27 下午5:13
 * @Version 1.0
 **/
public class NioDiscardClientHandler extends SimpleChannelInboundHandler<Object> {
    static final Logger logger = LoggerFactory.getLogger(NioDiscardClientHandler.class);
    private ByteBuf content;
    private ChannelHandlerContext ctx;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("{} {}", ctx.channel(), msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
        content = ctx.alloc().directBuffer(NioDiscardClient.SIZE).writeZero(NioDiscardClient.SIZE);// Initialize the message.


        generateTraffic();// Send the initial messages.
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        content.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private void generateTraffic() throws InterruptedException {
        ctx.writeAndFlush(content.retainedDuplicate()).addListener(trafficGenerator);
        Thread.sleep(1000);
    }

    private final ChannelFutureListener trafficGenerator = new ChannelFutureListener(){

        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            if (future.isSuccess()) {
                generateTraffic();
            } else {
                future.cause().printStackTrace();
                future.channel().close();
            }
        }
    };
}
