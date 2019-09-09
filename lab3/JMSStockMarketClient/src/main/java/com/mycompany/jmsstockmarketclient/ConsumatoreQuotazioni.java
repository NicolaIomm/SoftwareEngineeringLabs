/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jmsstockmarketclient;

import java.util.Properties;
import javax.naming.Context;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author biar
 */
public class ConsumatoreQuotazioni implements MessageListener {
    
    private Context jndiContext = null;
    private TopicConnectionFactory connectionFactory = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic destination = null;
    private TopicSubscriber subscriber = null;
    private TopicPublisher publisher = null;

    private InitialContext ctx = null;
    private Properties props = new Properties();
    
    private static final Logger LOG = LoggerFactory.getLogger(ConsumatoreQuotazioni.class);
    
    public void start() throws JMSException, NamingException {
        
        /*
            * Create a JNDI API InitialContext object
        */
        try {
            this.props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            this.props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            this.jndiContext = new InitialContext(props);        

        } catch (NamingException e) {
            LOG.info("ERROR in JNDI: " + e.toString());
            System.exit(1);
        }
        
        this.ctx = new InitialContext(props);
        this.connectionFactory = (TopicConnectionFactory) ctx.lookup("ConnectionFactory");
        this.destination = (Topic) ctx.lookup("dynamicTopics/Quotazioni");

        this.connection = this.connectionFactory.createTopicConnection();
        this.session = this.connection.createTopicSession(
                                false, Session.AUTO_ACKNOWLEDGE
                        );
        this.subscriber = this.session.createSubscriber(this.destination, null, true);
        this.publisher = this.session.createPublisher(this.destination);
        this.connection.start();

        java.util.logging.Logger.getLogger(this.getClass().getName()).info("In attesa di richieste di acquisto...");

        subscriber.setMessageListener(this);
    }

    @Override
    public void onMessage(Message msg) {
        
            String nome;
            float valore;
            
            try {
                nome = msg.getStringProperty("Nome");
                valore = msg.getFloatProperty("Valore");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            
            System.out.println("Nome: " + nome + ", Valore: " + valore);
    }
    
}
