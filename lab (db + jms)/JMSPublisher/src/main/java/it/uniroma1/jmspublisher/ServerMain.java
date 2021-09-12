/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.jmspublisher;

import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
public class ServerMain {
    public static void main(String[] args) throws NamingException, JMSException {
        ProduttoreQuotazioni q = new ProduttoreQuotazioni();
	q.start();
    }
}
