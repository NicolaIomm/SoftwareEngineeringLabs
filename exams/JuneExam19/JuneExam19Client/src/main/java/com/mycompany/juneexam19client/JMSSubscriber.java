/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juneexam19client;

import edu.uniroma1.msecs.soapserver.Professor;
import java.util.Properties;

import javax.jms.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.Logger;

import org.slf4j.LoggerFactory;

/**
 *
 * @author biar
 */
public class JMSSubscriber implements MessageListener{

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(JMSSubscriber.class);  
    
    
    private TopicConnectionFactory connectionFactory = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic topic = null;
    private TopicSubscriber subscriber = null;
    private TopicPublisher publisher = null;
    
    public JMSSubscriber() throws NamingException, JMSException {
        Properties properties = null;
        InitialContext ctx = null;
        Context jndiContext = null;

        try {
            properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            jndiContext = new InitialContext(properties);        
            ctx = new InitialContext(properties);
        } catch (NamingException e) {
            LOG.info("ERROR in JNDI: " + e.toString());
            System.exit(1);
        }
        this.connectionFactory = (TopicConnectionFactory) ctx.lookup("ConnectionFactory");
        this.topic = (Topic) ctx.lookup("dynamicTopics/professors");
        this.connection = this.connectionFactory.createTopicConnection();
        this.session = this.connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        this.subscriber = this.session.createSubscriber(this.topic, null, true);
        this.publisher = this.session.createPublisher(this.topic);

        Logger.getLogger(this.getClass().getName()).info("Listening the topic 'professors' ...");

        subscriber.setMessageListener(this);
    }
    
    public void start() throws JMSException {
        this.connection.start();
    }
    
    public void stop() throws JMSException {
        this.connection.stop();
    }
    
    
    
    @Override
    public void onMessage(Message msg) {
        String id;
        float rank;

        try {
            id = msg.getStringProperty("id");
            rank = msg.getFloatProperty("rank");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        Professor prof = Client.getDetails(id);
               
        String ret = "Received id: "+id+" with ranking "+rank+" ... good job "+prof.getName()+ " " +prof.getSurname();
        System.out.println(ret);
        
    }
    
    
}
