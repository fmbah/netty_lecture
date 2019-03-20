package com.fmbah.netty.大纲.n11;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @ClassName GatheringBufferTest
 * @Description 将多个buffer聚集在一个channel中
 * 				将channel中的数据写入到多个buffer中
 * @Author root
 * @Date 19-3-20 下午2:26
 * @Version 1.0
 **/
public class GatheringBufferTest {

	public static void main(String[] args) throws IOException {

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress(8899);
		serverSocketChannel.socket().bind(address);

		int messagelength = 3 + 4 + 5;

		ByteBuffer[] buffers = new ByteBuffer[3];

		buffers[0] = ByteBuffer.allocate(3);
		buffers[1] = ByteBuffer.allocate(4);
		buffers[2] = ByteBuffer.allocate(5);

		SocketChannel socketChannel = serverSocketChannel.accept();

		System.out.println(socketChannel.isConnected());

		while (true) {

			int readBuffer = 0;
			while (readBuffer < messagelength) {
				long read = socketChannel.read(buffers);
				if (read == -1) {
					continue;
				}
				readBuffer += read;

				System.out.println("readBuffer: " + readBuffer);
				Arrays.asList(buffers).stream().map(buffer -> "position: " + buffer.position() + ", limit: " + buffer.limit() + ", capacity: " + buffer.capacity()).forEach(System.out::println);
			}

			Arrays.asList(buffers).stream().forEach(byteBuffer -> byteBuffer.flip());

			int writeBuffer = 0;
			while (writeBuffer < messagelength) {
				long write = socketChannel.write(buffers);
				writeBuffer += write;
			}

			Arrays.asList(buffers).stream().forEach(byteBuffer -> byteBuffer.clear());

			System.out.println("read: " + readBuffer + ", write: " + writeBuffer + ", messagelenth: " + messagelength);

		}

	}

}
