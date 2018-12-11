package com.fmbah.netty.nio24;

import io.grpc.stub.StreamObserver;

import java.util.UUID;

/**
 * @ClassName StudentServiceImpl
 * @Description
 * @Author root
 * @Date 18-12-7 上午9:12
 * @Version 1.0
 **/
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase{

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("客户端消息: " + request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("客户端消息: " + request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(20).setCity("杭州").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(20).setCity("杭州").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(20).setCity("杭州").build());

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {

        StreamObserver<StudentRequest> streamObserver = new StreamObserver<StudentRequest>() {

            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext: " + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError");
            }

            @Override
            public void onCompleted() {
                StudentResponse studentResponse = StudentResponse.newBuilder().setName("张三").setAge(20).setCity("杭州").build();
                StudentResponse studentResponse1 = StudentResponse.newBuilder().setName("张三").setAge(20).setCity("杭州").build();
                StudentResponseList studentResponseList = StudentResponseList.newBuilder().addStudentResponse(studentResponse).addStudentResponse(studentResponse1).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }
        };


        return streamObserver;
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {

        StreamObserver<StreamRequest> streamObserver = new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());

                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };

        return streamObserver;
    }
}
