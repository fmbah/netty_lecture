package com.fmbah.netty.nio25_28_imitate.custom;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @ClassName ImitategRpcServer
 * @Description
 * @Author root
 * @Date 18-12-11 下午2:49
 * @Version 1.0
 **/
public class ImitategRpcServer {

    final int port;
    final Server server;

    public ImitategRpcServer(int port) {
        this.port = port;
        this.server = ServerBuilder.forPort(port).addService(new ImitategRpcServiceImpl()).build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("ImitategRpcServer start....");
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("runtime getRuntime addShutdownHook run....");
            ImitategRpcServer.this.stop();
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void await() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ImitategRpcServer imitategRpcServer = new ImitategRpcServer(8099);
        imitategRpcServer.start();
        imitategRpcServer.await();
    }



}
