/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.client;

import java.util.Properties;
import javax.jms.*;
import javax.naming.*;

public class MainClient {

    public static void main(String[] args) throws NamingException, JMSException {

        String destName = "dynamicTopics/professors";

        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");

        Context ctx = new InitialContext(props);
        ConnectionFactory connFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
        Destination dest = (Destination) ctx.lookup(destName);
        Connection connection = connFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageConsumer consumer = session.createConsumer(dest);

        ProfessorListener listener = new ProfessorListener();
        consumer.setMessageListener((MessageListener) listener);
        connection.start();
        
        System.out.println(" ... connessione JMS stabilita ...");

    }

}
