package com.fmbah.netty.nio33.nio33_reload;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NioTest1to3
 * @Description
 * @Author root
 * @Date 18-12-21 上午9:41
 * @Version 1.0
 **/
public class NioTest1to3 {

    public static void main(String[] args) throws IOException {

        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0; i < 10; i++) {
            intBuffer.put(i);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

        System.out.println("===================================");


        FileInputStream fileInputStream = new FileInputStream("NioTest2.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            System.out.print((char)b);
        }

        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel channel1 = fileOutputStream.getChannel();

        byte[] bytes = "hi, i'm fmbah!".getBytes();

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(512);
        for(byte b : bytes) {
            byteBuffer1.put(b);
        }

        byteBuffer1.flip();

        channel1.write(byteBuffer1);

        fileOutputStream.close();
    }

}
