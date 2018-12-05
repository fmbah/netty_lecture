package com.fmbah.netty.nio18.nio18_reload0;

import com.fmbah.netty.nio18.nio18_reload0.genjava.MultiplicationService;
import org.apache.thrift.TException;

/**
 * @ClassName MultiplicationHandler
 * @Description
 * @Author root
 * @Date 18-12-3 下午2:09
 * @Version 1.0
 **/
public class MultiplicationHandler implements MultiplicationService.Iface {
    @Override
    public int multiply(int n1, int n2) throws TException {
        System.out.println("Multiply(" + n1 + "," + n2 + ")");
        return n1 * n2;
    }
}
