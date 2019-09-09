/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankaccountsserver;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author biar
 */
public class BankAccountServer {
    
    public static void main(String[] args) throws InterruptedException {
        
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(AccountRepository.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new AccountRepository()));
        factoryBean.setAddress("http://localhost:8080/");
        Server server = factoryBean.create();

        System.out.println("Server ready...");
        Thread.sleep(600 * 1000);
        System.out.println("Server exiting");
        server.destroy();
        System.exit(0);
        
    }
    
}
