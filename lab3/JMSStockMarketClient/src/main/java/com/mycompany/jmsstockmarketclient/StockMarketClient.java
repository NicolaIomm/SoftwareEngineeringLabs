/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jmsstockmarketclient;

import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
public class StockMarketClient {
    
    public static void main(String[] args) throws JMSException, NamingException {
        
        System.out.println("JMS Client is running...");
        
        ConsumatoreQuotazioni c = new ConsumatoreQuotazioni();
		c.start();
                
                
    }
    
}
