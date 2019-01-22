package com.fmbah.netty.nio37;

import java.nio.ByteBuffer;

/**
 * @ClassName Nio37Test2
 * @Description
 * @Author root
 * @Date 19-1-3 上午10:21
 * @Version 1.0
 **/
public class Nio37Test2 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }
        ByteBuffer asReadOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(asReadOnlyBuffer.position() + "=" + asReadOnlyBuffer.limit() + "=" + asReadOnlyBuffer.capacity());
        asReadOnlyBuffer.flip();
        System.out.println(asReadOnlyBuffer.position() + "=" + asReadOnlyBuffer.limit() + "=" + asReadOnlyBuffer.capacity());
        for (int i = 0; i < asReadOnlyBuffer.capacity(); i++) {
            System.out.println(asReadOnlyBuffer.get());
        }
    }
}
