package com.fmbah.netty.nio32.io装饰设计模式;

/**
 * @ClassName MyPipedInputStream
 * @Description
 * @Author root
 * @Date 18-12-13 下午8:07
 * @Version 1.0
 **/
public class MyPipedInputStream extends MyFilterInputStream{

    public MyPipedInputStream(MyInputStream myInputStream) {
        super(myInputStream);
        System.out.println("c");
    }

    public void readCustom() {
        System.out.println("d");
        System.out.println("MyPipedInputStream readCustom run...");
    }

    @Override
    public void read() {
        System.out.println("e");
        super.read();
        readCustom();
    }
}
