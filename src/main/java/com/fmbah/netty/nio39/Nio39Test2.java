package com.fmbah.netty.nio39;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @ClassName Nio39Test2
 * @Description
 *
 * 关于Buffer的分散/汇集
 * gathering(聚集): 写入Channel是指在写操作时将多个Buffer的数据写入到同一个Channel,因此, Channel将多个Buffer中的数据聚集后发送到Channel
 *
 * scattering(分散): 从Channel中读取是指在读操作时将读取的数据写入多个buffer中,因此,Channel将从Channel中读取的数据分散到多个Buffer中
 *
 *
 * @Author root
 * @Date 19-1-22 上午11:29
 * @Version 1.0
 **/
public class Nio39Test2 {

    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(inetSocketAddress);

        int messageLength = 2 + 3 + 4;

        ByteBuffer[] buffers = new ByteBuffer[3];

        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int bytesRead = 0;
            while (bytesRead < messageLength) {
                long read = socketChannel.read(buffers);
                if (read == -1) {
                    continue;
                }
                bytesRead += read;

                System.out.println("bytesRead: " + bytesRead);

                Arrays.asList(buffers).stream().map(buffer -> "position:" + buffer.position() + ", limit: " + buffer.limit()).forEach(System.out::println);
            }

            Arrays.asList(buffers).forEach(buffer -> {
                buffer.flip();
            });

            long bytesWritten = 0;
            while (bytesWritten < messageLength) {
                long r = socketChannel.write(buffers);
                bytesWritten += r;
            }

            Arrays.asList(buffers).forEach(buffer -> {
                buffer.clear();
            });

            System.out.println("bytesRead: " + bytesRead + ", bytesWritten: " + bytesWritten + ", messageLength: " + messageLength);
        }
    }

}
