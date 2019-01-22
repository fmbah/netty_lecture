package com.fmbah.netty.nio36;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName Nio36
 * @Description 这次应该是目前为止讲课人最囧的一次了
 * @Author root
 * @Date 19-1-2 下午7:47
 * @Version 1.0
 **/
public class Nio36 {

    /**
     *
     * 功能描述:
     * 0. 初始化buffer(position = 0, limit = capaticy = 512)
     * 1. 从管道中读取数据到buffer内存里, (p = 34, limit = capaticy = 512)
     * 2. flip反转后, (p = 0, l = 上一次p的位置, capaticy = 512)
     * 3. write后 (p = limit = 34, capaticy = 512)
     * 4. clear( p =0, limit = capaticy = 512)
     *    如果注释了clear方法, 则 p = limit了 所以返回读取数据为0,也就继续循环了
     *    flip(p = 0, limit = 上次p的位置, capaticy = 512)
     *    write( p = l = 34, c = 512), 因为buffer中有数据,所以一直往文件中写内容.........
     * 5. 从管道里读取数据到buffer中,已经无数据可读取了....-1,退出循环
     *
     * @param:
     * @return:
     * @auther: Fmbah
     * @date: 19-1-2 下午7:52
     */
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("inputStream.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("outputStream.txt");

        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        while (true) {
            buffer.clear();//为什么要加这句话,如果去掉会怎么样

            int read = inputStreamChannel.read(buffer);
            System.out.println("read: " + read);
            if (read == -1) {
                break;
            }

            buffer.flip();

            outputStreamChannel.write(buffer);
        }
    }

}
