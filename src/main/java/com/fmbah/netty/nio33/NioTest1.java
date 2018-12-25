package com.fmbah.netty.nio33;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @ClassName NioTest1
 * @Description
 * @Author root
 * @Date 18-12-14 上午9:39
 * @Version 1.0
 **/
public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i = 0; i < intBuffer.capacity(); ++i) {
            int nextInt = new SecureRandom().nextInt(20);
            intBuffer.put(nextInt);
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }

}
