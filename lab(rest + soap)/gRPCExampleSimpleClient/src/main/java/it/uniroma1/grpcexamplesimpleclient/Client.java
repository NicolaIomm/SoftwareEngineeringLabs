package it.uniroma1.grpcexamplesimpleclient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import it.uniroma1.gRPCExample.ListRequest;
import it.uniroma1.gRPCExample.ListResponse;
import it.uniroma1.gRPCExample.ListServiceGrpc;


import soapwsclient.generated.*;
public class Client {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        ListServiceGrpc.ListServiceBlockingStub stub 
          = ListServiceGrpc.newBlockingStub(channel);

        ListResponse listResponse = stub.listOrInfo(ListRequest.newBuilder()
            .setId("-1")
            .build());

        System.out.println("Response received from server:\n" + listResponse.getList());
        listResponse = stub.listOrInfo(ListRequest.newBuilder()
            .setId("1")
            .build());
        
        System.out.println("Response received from server:\n" + listResponse.getList());

        channel.shutdown();
        System.out.println(getCommercialInfo("1"));
        System.out.println(getETA("1", "Marco Calamo 3"));
    }
    
     private static String getCommercialInfo(String arg0) {
        WSImplService service = new WSImplService();
        WSInterface port = service.getWSImplPort();
        return port.getCommercialInfo(arg0);
    }
    
    private static String getETA(String arg0,String arg1) {
        WSImplService service = new WSImplService();
        WSInterface port = service.getWSImplPort();
        return port.getETA(arg0,arg1);
    }
}
