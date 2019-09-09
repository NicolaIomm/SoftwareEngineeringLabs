/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankaccountclient;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;

/**
 *
 * @author biar
 */
public class BankAccountClient {
    
    public static void main(String[] args) {
        
        WebClient client = WebClient.create("http://localhost:8080");
        client.path("/");
        //client.type("text/xml").accept("text/xml");
        
            // GET 1
        System.out.println("\nGET accounts/1");
        Account a1 = client.replacePath("/accounts/1").get(Account.class);
        System.out.println(a1.getId() + " - " + a1.getName());
        List<Operation> a1ops = a1.getOperations();
        System.out.println("ops: ");
        for (Operation o : a1ops){
            System.out.println(o.getId() + "- "+ o.getName());
        }

            // GET 2
        // Invocation
        System.out.println("\nGET accounts/2");
        Account a2 = client.replacePath("/accounts/2").get(Account.class);
        
        System.out.println(a2.getId() + " - " + a2.getName());
        List<Operation> a2ops = a2.getOperations();
        System.out.println("ops: ");
        for (Operation o : a2ops){
            System.out.println(o.getId() + "- "+ o.getName());
        }
        
            // POST 10
        Operation a3o1 = new Operation();
        a3o1.setId(1);
        a3o1.setName("PC");

        Operation a3o2 = new Operation();
        a3o2.setId(2);
        a3o2.setName("Auto");
            
        List<Operation> a3ops = new ArrayList<>();
        a3ops.add(a3o1);
        a3ops.add(a3o2);
        
        Account a3 = new Account();
        a3.setId(10);
        a3.setName("Nicola");
        a3.setOperations(a3ops);
        
        // Invocation
        System.out.println("\nPOST /accounts (10)");
        Response r = client.replacePath("/accounts").post(a3);
        System.out.println(r.getStatus() + " - " + r.getStatusInfo().getReasonPhrase());
        
            // DELETE 2
        // Invocation
        System.out.println("\nDELETE /accounts/2");
        Response rr = client.replacePath("/accounts/2").delete();
        System.out.println(rr.getStatus() + " - " + rr.getStatusInfo().getReasonPhrase());
        
            // UPDATE 1
        a1.setId(99);
        a1.setName("New account of 1");
        
        // Invocation
        System.out.println("\nUPDATE /accounts/1");
        Response rrr = client.replacePath("/accounts/1").put(a1);
        System.out.println(rrr.getStatus() + " - " + rrr.getStatusInfo().getReasonPhrase());
        
            // RQST on accounts/99/operations
        
        
    }
    
}
