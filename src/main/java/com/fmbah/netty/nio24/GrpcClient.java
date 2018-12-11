package com.fmbah.netty.nio24;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * @ClassName GrpcClient
 * @Description
 * @Author root
 * @Date 18-12-7 上午9:18
 * @Version 1.0
 **/
public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8099).usePlaintext().build();

        StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);

        MyResponse myResponse = studentServiceBlockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("张三").build());
        System.out.println(myResponse.getRealname());


        System.out.println("================");


        Iterator<StudentResponse> iter = studentServiceBlockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(20).build());

        while (iter.hasNext()) {
            StudentResponse studentResponse = iter.next();
            System.out.println(studentResponse.getName() + ", " + studentResponse.getAge() + ", " + studentResponse.getCity());
        }

        StudentServiceGrpc.StudentServiceStub studentServiceStub = StudentServiceGrpc.newStub(managedChannel);
//        System.out.println("================");
//
//        StreamObserver<StudentResponseList> streamObserver = new StreamObserver<StudentResponseList>() {
//            @Override
//            public void onNext(StudentResponseList value) {
//                value.getStudentResponseList().forEach(studentResponse->{
//                    System.out.println(studentResponse.getName() + ", " + studentResponse.getAge() + ", " + studentResponse.getCity());
//                    System.out.println("---------------------------------------");
//                });
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println(t.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("completed!!!");
//            }
//        };
//
//        StreamObserver<StudentRequest> studentsWrapperByAges = studentServiceStub.getStudentsWrapperByAges(streamObserver);
//        studentsWrapperByAges.onNext(StudentRequest.newBuilder().setAge(20).build());
//        studentsWrapperByAges.onCompleted();


        System.out.println("================");

        StreamObserver<StreamRequest> biTalk = studentServiceStub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
            }
        });




        try {
            for (int i = 0; i < 10; i++) {
                biTalk.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
                Thread.sleep(1000);
            }
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
