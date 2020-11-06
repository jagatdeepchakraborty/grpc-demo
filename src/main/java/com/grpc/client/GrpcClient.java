package com.grpc.client;

import com.grpc.gen.HelloRequest;
import com.grpc.gen.HelloResponse;
import com.grpc.gen.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
          .usePlaintext()
          .build();
 
        HelloServiceGrpc.HelloServiceBlockingStub stub
          = HelloServiceGrpc.newBlockingStub(channel);
 
        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
          .setFirstName("John")
          .setLastName("Doe")
          .build());
 
        channel.shutdown();
    }
}