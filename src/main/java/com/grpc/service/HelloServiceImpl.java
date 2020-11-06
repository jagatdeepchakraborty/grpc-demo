package com.grpc.service;

import com.grpc.gen.HelloRequest;
import com.grpc.gen.HelloResponse;
import com.grpc.gen.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(
            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .setDetail(request)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
