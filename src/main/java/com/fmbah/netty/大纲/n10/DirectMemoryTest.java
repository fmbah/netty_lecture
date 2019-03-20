package com.fmbah.netty.大纲.n10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName DirectMemoryTest
 * @Description
 * @Author root
 * @Date 19-3-20 下午1:54
 * @Version 1.0
 **/
public class DirectMemoryTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("in2.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("ou2.txt");

		FileChannel inputStreamChannel = fileInputStream.getChannel();
		FileChannel outputStreamChannel = fileOutputStream.getChannel();

		ByteBuffer buffer = ByteBuffer.allocateDirect(512);

		while (true) {

			buffer.clear();

			int read = inputStreamChannel.read(buffer);

			if (read == -1) {
				break;
			}

			buffer.flip();

			outputStreamChannel.write(buffer);

		}

		fileInputStream.close();
		fileOutputStream.close();
		inputStreamChannel.close();
		outputStreamChannel.close();
	}

}
