package com.fmbah.netty.大纲.n10;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @ClassName IntBufferTest
 * @Description
 * @Author root
 * @Date 19-3-13 下午3:39
 * @Version 1.0
 **/
public class IntBufferTest {


	public static void main(String[] args) {
		IntBuffer intBuffer = IntBuffer.allocate(10);

		for (int i = 0; i < intBuffer.capacity(); i++) {
			intBuffer.put(new SecureRandom().nextInt(20));
			System.out.println(intBuffer);
		}
		System.out.println();
		System.out.println();
		intBuffer.flip();
		System.out.println(intBuffer);
		System.out.println();
		System.out.println();

		intBuffer.limit(5);
		System.out.println(intBuffer);
		System.out.println();
		System.out.println();
		intBuffer.position(3);
		System.out.println(intBuffer);
		System.out.println();
		System.out.println();
		while (intBuffer.hasRemaining()) {
			System.out.println(intBuffer.get());
			System.out.println(intBuffer);
		}


	}
}
