package com.fmbah.netty.nio18.nio18_reload0;

import com.fmbah.netty.nio18.nio18_reload0.genjava.MultiplicationService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @ClassName MultiplicationClient
 * @Description
 * @Author root
 * @Date 18-12-3 下午2:17
 * @Version 1.0
 **/
public class MultiplicationClient {
    public static void main(String[] args) {
        try {
            TTransport tTransport = new TSocket("127.0.0.1", 9090);
            tTransport.open();

            TProtocol tProtocol = new TBinaryProtocol(tTransport);
            MultiplicationService.Client client = new MultiplicationService.Client(tProtocol);

            perform(client);

            tTransport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void perform (MultiplicationService.Client client) throws TException {
        int res = client.multiply(3, 5);
        System.out.println("3*5=" + res);
    }
}
