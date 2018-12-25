package com.fmbah.netty.nio33;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NioTest3
 * @Description
 * @Author root
 * @Date 18-12-14 上午9:45
 * @Version 1.0
 **/
public class NioTest3 {

    public static void main(String[] args) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byte[] bytes = "hello world!".getBytes();

        for (int i = 0; i < bytes.length; i++) {
            byteBuffer.put(bytes[i]);
        }

        byteBuffer.flip();

        channel.write(byteBuffer);

        fileOutputStream.close();
    }

}
