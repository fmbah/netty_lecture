package com.fmbah.netty.nio33.nio33_mystudy;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName BasicChannelExample
 * @Description
 * @Author root
 * @Date 18-12-24 下午5:48
 * @Version 1.0
 **/
public class BasicChannelExample {
    public static void main(String[] args) throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read = channel.read(buffer);
        while (read != -1) {
            System.out.println("Read: " + read);

            buffer.flip();
            while(buffer.hasRemaining()) {
                System.out.println((char)buffer.get());
            }

            buffer.clear();
            read = channel.read(buffer);
        }
        aFile.close();
    }
}
