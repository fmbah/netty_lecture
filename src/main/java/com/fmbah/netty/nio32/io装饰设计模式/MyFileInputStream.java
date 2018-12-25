package com.fmbah.netty.nio32.io装饰设计模式;

/**
 * @ClassName MyFileInputStream
 * @Description
 * @Author root
 * @Date 18-12-13 下午7:45
 * @Version 1.0
 **/
public class MyFileInputStream implements MyInputStream{
    @Override
    public void read() {
        System.out.println("实现基本的读功能....");
    }
}
