/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.julyexam19soapserver;

import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class Server {
    
    public static void main(String[] args) {
        
        ExamImpl implementor = new ExamImpl();
        String address = "http://localhost:9000/MovieService";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
        
    }
    
}
