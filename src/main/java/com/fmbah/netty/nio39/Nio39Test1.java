package com.fmbah.netty.nio39;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @ClassName Nio39Test1
 * @Description
 * @Author root
 * @Date 19-1-22 上午11:26
 * @Version 1.0
 **/
public class Nio39Test1 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("randomFile1.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        FileLock lock = channel.lock(0, 2, true);//文件锁(共享锁/排他锁)

        System.out.println("valid: " + lock.isValid());
        System.out.println("lock type: " + lock.isShared());

        lock.release();

        randomAccessFile.close();
    }
}
