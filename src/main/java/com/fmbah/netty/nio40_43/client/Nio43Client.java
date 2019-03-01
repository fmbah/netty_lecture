package com.fmbah.netty.nio40_43.client;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @ClassName Nio43Client
 * @Description
 * @Author root
 * @Date 19-1-31 上午11:10
 * @Version 1.0
 **/
public class Nio43Client {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            socketChannel.connect(new InetSocketAddress("localhost", 8899));


            while (true) {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                selectionKeys.forEach(selectionKey -> {
                    try {
                        if (selectionKey.isConnectable()) {
                            SocketChannel client = (SocketChannel)selectionKey.channel();
                            if (client.isConnectionPending()) {
                                client.finishConnect();

                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                byteBuffer.put((LocalDateTime.now() + " 连接成功").getBytes());
                                byteBuffer.flip();
                                client.write(byteBuffer);
                            }
                        }
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
