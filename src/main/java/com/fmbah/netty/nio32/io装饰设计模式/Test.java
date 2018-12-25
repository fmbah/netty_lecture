package com.fmbah.netty.nio32.io装饰设计模式;

/**
 * @ClassName Test
 * @Description
 * @Author root
 * @Date 18-12-13 下午7:50
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
//        MyFileInputStream myFileInputStream = new MyFileInputStream();
//        myFileInputStream.read();
//
//
//        MyPipedInputStream myPipedInputStream = new MyPipedInputStream();
//        myPipedInputStream.read();
//
//        MyBufferedInputStream myBufferedInputStream = new MyBufferedInputStream(myFileInputStream);
//        myBufferedInputStream.read();

        MyBufferedInputStream myBufferedInputStream1 = new MyBufferedInputStream(new MyPipedInputStream(new MyFileInputStream()));
        myBufferedInputStream1.read();

        MyPipedInputStream myBufferedInputStream12 = new MyPipedInputStream(new MyPipedInputStream(new MyFileInputStream()));
        myBufferedInputStream12.read();
    }
}
