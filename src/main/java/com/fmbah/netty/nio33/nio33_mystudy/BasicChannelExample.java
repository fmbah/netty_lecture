package com.fmbah.netty.nio33.nio33_mystudy;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;

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
        System.out.println("channel size: " + channel.size());
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int read = channel.read(buffer);//read into buffer
        while (read != -1) {
            System.out.println("Read: " + read);

            buffer.flip();//make buffer ready for read
            while(buffer.hasRemaining()) {
                System.out.print((char)buffer.get());//read 1 bytes at a time
            }

            buffer.clear();//clear the whole buffer, make buffer ready to writing
//            buffer.compact();//only clean the data which you have alredy read, any unread data is moved to the beginning of the buffer, and data will now be written into the buffer after the unread data.
            read = channel.read(buffer);
        }


//        ByteBuffer header = ByteBuffer.allocate(10);//固定大小,不适合动态容量
//        ByteBuffer body = ByteBuffer.allocate(5);//固定大小,不适合动态容量
//
//        ByteBuffer[] bufferArray = {header, body};
//        channel.read(bufferArray);
//
//        channel.write(bufferArray);


        RandomAccessFile toFile = new RandomAccessFile("data/nio-to-data.txt", "rw");
        FileChannel toFileChannel = toFile.getChannel();

//        channel.transferTo(0, channel.size(), toFileChannel);
        toFileChannel.transferFrom(channel, 0, channel.size());

        int i = SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT;


        aFile.close();
    }
}
