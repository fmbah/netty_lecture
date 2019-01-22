package com.fmbah.netty.nio37;

import java.nio.ByteBuffer;

/**
 * @ClassName Nio37Test0
 * @Description
 * @Author root
 * @Date 19-1-3 上午10:05
 * @Version 1.0
 **/
public class Nio37Test0 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(512);

        buffer.putChar('C');
        buffer.putDouble(1.0d);
        buffer.putFloat(2.0f);
        buffer.putInt(3);
        buffer.putLong(4);
        buffer.putShort(new Short("5"));

        buffer.flip();

        System.out.println(buffer.getChar());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getFloat());
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getShort());
    }

}
