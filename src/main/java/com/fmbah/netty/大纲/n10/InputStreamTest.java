package com.fmbah.netty.大纲.n10;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName InputStreamTest
 * @Description
 * @Author root
 * @Date 19-3-13 下午4:12
 * @Version 1.0
 **/
public class InputStreamTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("NioTest2.txt");
		FileChannel fileChannel = fileInputStream.getChannel();

		ByteBuffer byteBuffer = ByteBuffer.allocate(fileInputStream.available());
		System.out.println("allocate ByteBuffer: " + byteBuffer);
		fileChannel.read(byteBuffer);
		System.out.println("read ByteBuffer: " + byteBuffer);

		byteBuffer.flip();
		System.out.println("flip ByteBuffer: " + byteBuffer);

		while (byteBuffer.hasRemaining()) {
			System.out.print((char)byteBuffer.get());
			System.out.println("get ByteBuffer: " + byteBuffer);
		}

	}

}
