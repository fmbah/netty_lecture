package com.fmbah.netty.nio18;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TSocket;

/**
 * @ClassName ThriftServer
 * @Description
 *
 * apache thrift框架
 *
 * 客户端
 * 代码
 * 协议
 * 传输层
 * 网络层
 *
 * @Author root
 * @Date 18-12-1 上午8:58
 * @Version 1.0
 **/
public class ThriftServer {
    public static void main(String[] args) throws Exception{
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServerImpl> processor = new PersonService.Processor<>(new PersonServerImpl());
        arg.protocolFactory(new TCompactProtocol.Factory());//协议层(压缩格式)(TBinaryProtocol.Factory(),TJSONProtocol.Factory(),TSimpleJSONProtocol.Factory())


        arg.transportFactory(new TFramedTransport.Factory());//传输层(非阻塞式, ;new TSocket();阻塞式)
        arg.processorFactory(new TProcessorFactory(processor));//网络层字节流传输

        THsHaServer server = new THsHaServer(arg);//线程池,半同步半异步,传输层固定TFramedTransport
//        TSimpleServer//简单的单线程服务器
//        TThreadPoolServer//线程池服务器,阻塞式io,每一个请求一个线程
//        TNonblockingServer//非阻塞式服务器


        server.serve();
    }
}
