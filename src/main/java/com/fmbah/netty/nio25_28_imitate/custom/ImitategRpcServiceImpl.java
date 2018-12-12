package com.fmbah.netty.nio25_28_imitate.custom;

import com.fmbah.netty.nio25_28_imitate.ImitategRpcGrpc;
import com.fmbah.netty.nio25_28_imitate.Preq;
import com.fmbah.netty.nio25_28_imitate.Pres;
import io.grpc.stub.StreamObserver;

/**
 * @ClassName ImitategRpcServiceImpl
 * @Description
 * @Author root
 * @Date 18-12-11 下午2:47
 * @Version 1.0
 **/
public class ImitategRpcServiceImpl extends ImitategRpcGrpc.ImitategRpcImplBase {

    @Override
    public void p2p(Preq request, StreamObserver<Pres> responseObserver) {
        System.out.println("p2p receive Client message: " + request.getReq());

        Pres pres = Pres.newBuilder().setRes(request.getReq() + 100).build();
        responseObserver.onNext(pres);
        responseObserver.onCompleted();
    }

    @Override
    public void p2s(Preq request, StreamObserver<Pres> responseObserver) {
        System.out.println("p2s receive Client message: " + request.getReq());

        Pres pres0 = Pres.newBuilder().setRes(request.getReq() + 100).build();
        Pres pres1 = Pres.newBuilder().setRes(request.getReq() + 101).build();
        responseObserver.onNext(pres0);
        responseObserver.onNext(pres1);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Preq> s2p(StreamObserver<Pres> responseObserver) {
        return new StreamObserver<Preq>() {
            @Override
            public void onNext(Preq value) {
                System.out.println("s2p receive Client message: " + value.getReq());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                Pres pres = Pres.newBuilder().setRes(101).build();
                //Cancelling the stream with status Status{code=INTERNAL, description=Too many responses, cause=null}
//                Pres pres1 = Pres.newBuilder().setRes(101101).build();
                responseObserver.onNext(pres);
//                responseObserver.onNext(pres1);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<Preq> s2s(StreamObserver<Pres> responseObserver) {

        StreamObserver<Preq> streamObserver = new StreamObserver<Preq>() {
            @Override
            public void onNext(Preq value) {
                System.out.println("s2s receive Client message: " + value.getReq());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                Pres pres0 = Pres.newBuilder().setRes(100).build();
                Pres pres1 = Pres.newBuilder().setRes(101).build();
                responseObserver.onNext(pres0);
                responseObserver.onNext(pres1);
                responseObserver.onCompleted();
            }
        };

        return streamObserver;
    }
}
