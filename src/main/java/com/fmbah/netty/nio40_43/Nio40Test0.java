package com.fmbah.netty.nio40_43;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName Nio40Test0
 * @Description  客户端使用 linux/mac: nc ip port   windows: telnet ip port
 *
 * Nio组件: Buffer Channel Selector
 *
 * Nio网络编程/io网络编程
 *
 * ServerSocket serverSocket = ..
 * serverSocket.bind(8899)
 *
 * while (true) {
 *  Socket socket = serverSocket.accept();//阻塞
 *  new Thread() {
 *      run{
 *          socket.getInputStream()
 *      }
 *  }
 * }
 *
 * new Socket("localhost", 8899)
 * socket.connect();
 *
 * 建立链接在服务端的8899端口上,数据传输上是在系统上随机选择一个当前未被占用的端口进行传输,然后这个比较简单适合小数据量的并发场景
 *
 * @Author root
 * @Date 19-1-22 下午2:06
 * @Version 1.0
 **/
public class Nio40Test0 {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        int[] ports = new int[5];
        ports[0] = 9990;
        ports[1] = 9991;
        ports[2] = 9992;
        ports[3] = 9993;
        ports[4] = 9994;

        Selector selector = Selector.open();

//        System.out.println(SelectorProvider.provider().getClass());
//        System.out.println(sun.nio.ch.DefaultSelectorProvider.create().getClass());

        for (int i = 0; i < 5; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(ports[i]);
            serverSocket.bind(inetSocketAddress);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("监听端口: " + ports[i]);
        }

        while (true) {
            int numbers = selector.select();
            System.out.println("numbers: " + numbers);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys; " + selectionKeys);

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);

                    socketChannel.register(selector, SelectionKey.OP_READ);

                    System.out.println("获取客户端链接: " + socketChannel);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int bytesRead = 0;
                    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                    while (true) {
                        byteBuffer.clear();
                        int read = socketChannel.read(byteBuffer);
                        if (read == -1) {
                            System.out.println("======");
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        bytesRead += read;
                    }

                    System.out.println("读取: " + bytesRead + ", 来自于: " + socketChannel);
                }
                iterator.remove();
            }
        }
    }
}
