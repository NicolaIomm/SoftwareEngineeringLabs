/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankclient;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;

/**
 *
 * @author biar
 */
public class Client {
    
    private static java.util.List<java.lang.String> getOperationDetailsByID(int i){
        com.mycompany.BankSoapServer.BankImplService service = new com.mycompany.BankSoapServer.BankImplService();
        com.mycompany.BankSoapServer.BankInterface port = service.getBankImplPort();
        return port.getOperationDetailsByID(i);
    }
    
    private static java.util.List<java.lang.String> getOperationsByClientID(int i) {
        com.mycompany.BankSoapServer.BankImplService service = new com.mycompany.BankSoapServer.BankImplService();
        com.mycompany.BankSoapServer.BankInterface port = service.getBankImplPort();
        return port.getOperationsByClientID(i);
    }
    
    private static java.util.List<java.lang.String> getClients() {
        com.mycompany.MyAAAWS.MyAAAWSImplService service = new com.mycompany.MyAAAWS.MyAAAWSImplService();
        com.mycompany.MyAAAWS.MyAAAWSInterface port = service.getMyAAAWSImplPort();
        return port.getClients();
    }
    
    public static void main(String[] args) {
        
        System.out.println("Clients:");
        List<String> clients = getClients();
        ListIterator<String> iter1 = clients.listIterator();
        while (iter1.hasNext()){
            String client = iter1.next();
            int i = Character.getNumericValue(client.charAt(0));
            System.out.println(client);
            
            List<String> operations = getOperationsByClientID(i);
            ListIterator<String> iter2 = operations.listIterator();
            while (iter2.hasNext()){
                String operation = iter2.next();
                int opID = Integer.parseInt(operation);
                
                List<String> datails = getOperationDetailsByID(opID);
                System.out.println(datails);
            }
        }
        
        int i;
        for(i = 1; i < 5; i++) {
            System.out.println("Operations of client " + i);
            List<String> operations = getOperationsByClientID(i);
            for(String s : operations) {
                List<String> details = getOperationDetailsByID(Integer.parseInt(s));
                System.out.println(details);
            }
        }
        
    }
    
}
