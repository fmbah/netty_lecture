package com.fmbah.netty.nio25_28_imitate.custom;

import com.fmbah.netty.nio25_28_imitate.ImitategRpcGrpc;
import com.fmbah.netty.nio25_28_imitate.Preq;
import com.fmbah.netty.nio25_28_imitate.Pres;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;

/**
 * @ClassName ImitategRpcClient
 * @Description
 * @Author root
 * @Date 18-12-11 下午3:05
 * @Version 1.0
 **/
public class ImitategRpcClient {

    private final ManagedChannel channel;
    private final ImitategRpcGrpc.ImitategRpcBlockingStub imitategRpcBlockingStub;
    private final ImitategRpcGrpc.ImitategRpcStub imitategRpcStub;

    public ImitategRpcClient(String address, int port) {
        ManagedChannelBuilder<?> managedChannelBuilder = ManagedChannelBuilder.forAddress(address, port).usePlaintext();
        channel = managedChannelBuilder.build();
        imitategRpcBlockingStub = ImitategRpcGrpc.newBlockingStub(channel);
        imitategRpcStub = ImitategRpcGrpc.newStub(channel);
    }

    public static void main(String[] args) {

        ImitategRpcClient imitategRpcClient = new ImitategRpcClient("127.0.0.1", 8099);
        try {

            Pres pres = imitategRpcClient.imitategRpcBlockingStub.p2p(Preq.newBuilder().setReq(1).build());
            System.out.println("p2p from server message: " + pres.getRes());

            Iterator<Pres> presIterator = imitategRpcClient.imitategRpcBlockingStub.p2s(Preq.newBuilder().setReq(1).build());
            while (presIterator.hasNext()) {
                Pres next = presIterator.next();
                System.out.println("p2s from server message: " + next.getRes());
            }

            StreamObserver<Preq> preqStreamObserver = imitategRpcClient.imitategRpcStub.s2p(new StreamObserver<Pres>() {
                @Override
                public void onNext(Pres value) {
                    System.out.println("s2p from server message: " + value.getRes());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println(t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("s2p from server message onCompleted....");
                }
            });

            preqStreamObserver.onNext(Preq.newBuilder().setReq(1111).build());
            preqStreamObserver.onNext(Preq.newBuilder().setReq(1112).build());
            preqStreamObserver.onCompleted();


            StreamObserver<Preq> preqStreamObserver1 = imitategRpcClient.imitategRpcStub.s2s(new StreamObserver<Pres>() {
                @Override
                public void onNext(Pres value) {
                    System.out.println("s2s from server message: " + value.getRes());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println(t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("s2s from server message onCompleted....");
                }
            });
            preqStreamObserver1.onNext(Preq.newBuilder().setReq(222).build());
            preqStreamObserver1.onNext(Preq.newBuilder().setReq(2221).build());
            preqStreamObserver1.onNext(Preq.newBuilder().setReq(2222).build());
            preqStreamObserver1.onCompleted();

            Thread.sleep(2000);//保证方法执行完成,否则方法调完之后,可能回调还没走过来,所以加上延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (imitategRpcClient.channel != null) {
                imitategRpcClient.channel.shutdown();
            }
        }
    }
}
