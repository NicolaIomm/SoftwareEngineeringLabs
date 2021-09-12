/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.jmssubscriber;

import java.util.Properties;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
public class ClientMain {

    private static TopicConnection topicConnection;
    private static TopicSession topicSession = null;
    private static Destination destination = null;
    private static MessageProducer producer = null;
    private static TopicSubscriber topicSubscriber = null;
    
    public static void main(String[] args) {
        System.out.println("Welcome! I will show you the stocks updates created by the student 1947850\n"
                + "--------------------------------------------------------------------------");
        System.out.println("Connecting to the JMS provider...");
        Context jndiContext = null;
        ConnectionFactory topicConnectionFactory = null;

        String destinationName = "dynamicTopics/students";

        try {

            Properties props = new Properties();

            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://192.168.50.83:61616");
            jndiContext = new InitialContext(props);

            topicConnectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            destination = (Destination) jndiContext.lookup(destinationName);
            topicConnection = (TopicConnection) topicConnectionFactory.createConnection();
            topicSession = (TopicSession) topicConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            topicSubscriber = topicSession.createSubscriber((Topic) destination);

            topicSubscriber.setMessageListener(JMSListener.getInstance());
            topicConnection.start();
            
            System.out.println("Ready!\n--------------------------------------------------------------------------");
        } catch (JMSException err) {
            err.printStackTrace();
        } catch (NamingException err) {
            err.printStackTrace();
        }
    }
}
