package com.fmbah.netty.nio39;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName Nio39Test0
 * @Description 内存映射文件
 * @Author root
 * @Date 19-1-22 上午11:19
 * @Version 1.0
 **/
public class Nio39Test0 {

    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("randomFile.txt", "rw");
        FileChannel randomAccessFileChannel = randomAccessFile.getChannel();

        // 堆外内存,直接操作内存
        MappedByteBuffer map = randomAccessFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 3);

        map.put(0, (byte)'z');
        map.put(2, (byte)'z');

    }

}
