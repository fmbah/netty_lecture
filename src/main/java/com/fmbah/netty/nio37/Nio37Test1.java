package com.fmbah.netty.nio37;

import java.nio.ByteBuffer;

/**
 * @ClassName Nio37Test1
 * @Description
 * @Author root
 * @Date 19-1-3 上午10:10
 * @Version 1.0
 **/
public class Nio37Test1 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i= 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }
        System.out.println(buffer.position() + "=" + buffer.limit() + "=" + buffer.capacity());
        buffer.position(2).limit(6);
        System.out.println(buffer.position() + "=" + buffer.limit() + "=" + buffer.capacity());
        ByteBuffer sliceBuffer = buffer.slice();
        System.out.println(sliceBuffer.position() + "=" + sliceBuffer.limit() + "=" + sliceBuffer.capacity());
        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get();
            b *= 2;
            sliceBuffer.put(i, b);
        }

        buffer.position(0).limit(buffer.capacity());

        for (int i= 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.get());
        }
    }

}
