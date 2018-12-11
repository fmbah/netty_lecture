package com.fmbah.netty.nio24;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @ClassName GrpcServer
 * @Description
 * @Author root
 * @Date 18-12-7 上午9:14
 * @Version 1.0
 **/
public class GrpcServer {
    private Server server;

    private void start() throws Exception {
        this.server = ServerBuilder.forPort(8099).addService(new StudentServiceImpl()).build().start();
        System.out.printf("server started!");

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("关闭jvm");
            GrpcServer.this.stop();
        }));
        System.out.println("执行到这里");
    }

    private void stop() {
        if (null != this.server) {
            this.server.shutdown();
        }
    }

    private void awaitTermination() throws Exception {
        if (null != this.server) {
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        grpcServer.awaitTermination();
    }
}
