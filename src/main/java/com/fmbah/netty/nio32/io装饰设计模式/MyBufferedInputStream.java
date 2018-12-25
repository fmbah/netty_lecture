package com.fmbah.netty.nio32.io装饰设计模式;

/**
 * @ClassName MyBufferedInputStream
 * @Description
 * @Author root
 * @Date 18-12-13 下午7:40
 * @Version 1.0
 **/
public class MyBufferedInputStream extends MyFilterInputStream{

    public MyBufferedInputStream(MyInputStream myInputStream) {
        super(myInputStream);
        System.out.println("f");
    }

    public void readCustom() {
        System.out.println("g");
        System.out.println("MyBufferedInputStream readCustom run...");
    }

    @Override
    public void read() {
        System.out.println("h");
        super.read();
        this.readCustom();
    }
}
