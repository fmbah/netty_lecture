package com.fmbah.netty.nio38;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName Nio38Test0
 * @Description
 * @Author root
 * @Date 19-1-22 上午10:53
 * @Version 1.0
 **/
public class Nio38Test0 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("in2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("ou2.txt");

        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);//堆外内存,从内存拷贝到系统中,address成员变量维护着堆外内存的地址,

        while (true) {
            byteBuffer.clear();

            int read = inputStreamChannel.read(byteBuffer);

            if (read == -1) {
                break;
            }

            byteBuffer.flip();

            outputStreamChannel.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
        inputStreamChannel.close();
        outputStreamChannel.close();
    }
}
