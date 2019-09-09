/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myaaaws;

import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class Server {
    public static void main(String args[]) throws InterruptedException {
        MyAAAWSImpl implementor = new MyAAAWSImpl();
        String address = "http://127.0.0.1:8000/myaaaws";
        Endpoint.publish(address, implementor);
        System.out.println("MyAAAWS Server Started ...");
        Thread.sleep(36000 * 1000);
        System.out.println("MyAAAWS Server Closing ...");
        System.exit(0);
    }
}
