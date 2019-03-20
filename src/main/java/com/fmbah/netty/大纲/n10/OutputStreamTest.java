package com.fmbah.netty.大纲.n10;

import io.netty.util.CharsetUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName OutputStreamTest
 * @Description
 * @Author root
 * @Date 19-3-13 下午4:29
 * @Version 1.0
 **/
public class OutputStreamTest {

	public static void main(String[] args) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("OutputStreamTest.txt");
		FileChannel channel = fileOutputStream.getChannel();

		ByteBuffer byteBuffer = ByteBuffer.allocate(256);

		byte[] bytes = "haha, i'm in bytebuffer.....".getBytes(CharsetUtil.UTF_8);
		byteBuffer.put(bytes);

		byteBuffer.flip();

		channel.write(byteBuffer);

		fileOutputStream.close();
		channel.close();

	}

}
