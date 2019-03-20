package com.fmbah.netty.大纲.n10;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName RandomAccessFileTest
 * @Description
 * @Author root
 * @Date 19-3-20 下午2:12
 * @Version 1.0
 **/
public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("randomFile.txt", "rw");
		FileChannel channel = randomAccessFile.getChannel();

		MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, 3L);

		map.put(0, (byte)'a');
		map.put(1, (byte)'b');

	}

}
