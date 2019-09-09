/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juneexam19client;

import edu.uniroma1.msecs.soapserver.Professor;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
public class Client {

    public static Professor getDetails(String id){
        edu.uniroma1.msecs.soapserver.ExamImplService service = new edu.uniroma1.msecs.soapserver.ExamImplService();
        edu.uniroma1.msecs.soapserver.Exam port = service.getExamImplPort();
        return port.getDetails(id);
    }
    
    public static void main(String[] args) throws NamingException, JMSException {
             
        JMSSubscriber msgListener = new JMSSubscriber();
        msgListener.start();
        
    }
    
}
