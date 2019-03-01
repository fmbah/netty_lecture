package com.fmbah.netty.nio40_43.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @ClassName Nio43Server
 * @Description
 * @Author root
 * @Date 19-1-31 上午9:55
 * @Version 1.0
 **/
public class Nio43Server {
    private static Map<String, SocketChannel> clientMap = new HashMap<>();
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true) {
            try {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    try {
                        final SocketChannel client;
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel();
                            client = server.accept();
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);
                            clientMap.put("["+ UUID.randomUUID() +"]", client);
                        } else if (selectionKey.isReadable()) {
                            client = (SocketChannel)selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            int read = client.read(readBuffer);
                            if (read > 0) {
                                readBuffer.flip();
                                Charset charset = Charset.forName("utf-8");
                                String readMessage = String.valueOf(charset.decode(readBuffer).array());
                                System.out.println(client + ":" + readMessage);

                                String senderKey = null;
                                for (Map.Entry<String, SocketChannel> entry: clientMap.entrySet()) {
                                    if (entry.getValue() == client) {
                                        senderKey = entry.getKey();
                                        break;
                                    }
                                }
                                for (Map.Entry<String, SocketChannel> entry: clientMap.entrySet()) {
                                    SocketChannel value = entry.getValue();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    byteBuffer.put((senderKey + ":" + readMessage).getBytes());
                                    byteBuffer.flip();
                                    value.write(byteBuffer);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                selectionKeys.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
