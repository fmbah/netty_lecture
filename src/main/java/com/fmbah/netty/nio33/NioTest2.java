package com.fmbah.netty.nio33;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NioTest2
 * @Description
 * @Author root
 * @Date 18-12-14 上午9:42
 * @Version 1.0
 **/
public class NioTest2 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("NioTest2.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(fileInputStream.available());
        channel.read(byteBuffer);

        byteBuffer.flip();

        while(byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            System.out.println("Character: " + (char)b);
        }

        fileInputStream.close();
    }
}
