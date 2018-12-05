package com.fmbah.netty.nio18.nio18_reload0;

import com.fmbah.netty.nio18.nio18_reload0.genjava.MultiplicationService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * @ClassName MultiplicationServer
 * @Description
 * @Author root
 * @Date 18-12-3 下午2:10
 * @Version 1.0
 **/
public class MultiplicationServer {
    public static MultiplicationHandler handler;
    public static MultiplicationService.Processor processor;

    public static void main (String args[]) {
        try {
            handler = new MultiplicationHandler();
            processor = new MultiplicationService.Processor(handler);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        simple(processor);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(runnable).start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void simple(MultiplicationService.Processor processor) throws Exception{
        TServerTransport tServerTransport = new TServerSocket(9090);
        TServer tServer = new TSimpleServer(new TServer.Args(tServerTransport).processor(processor));
        System.out.println("Starting the simple server...");
        tServer.serve();
    }

}
