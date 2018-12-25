package com.fmbah.netty.nio32.io装饰设计模式;

/**
 * @ClassName MyFilterInputStream
 * @Description
 * @Author root
 * @Date 18-12-13 下午7:39
 * @Version 1.0
 **/
public abstract class MyFilterInputStream implements MyInputStream{

    MyInputStream myInputStream;

    public MyFilterInputStream(MyInputStream myInputStream) {
        System.out.println("a");
        this.myInputStream = myInputStream;
    }

    @Override
    public void read() {
        System.out.println("b");
        this.myInputStream.read();
    }

}
