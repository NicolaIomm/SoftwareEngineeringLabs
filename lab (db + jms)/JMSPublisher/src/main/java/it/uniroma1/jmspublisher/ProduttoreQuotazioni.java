/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.jmspublisher;

import javax.jms.*;
import javax.naming.*;

import java.util.Properties;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ProduttoreQuotazioni {

    private List<String> titoli = new ArrayList<>();
    private static final String DATABASE_POSITION = "/home/biar/database";

    public ProduttoreQuotazioni() {
        java.sql.Connection conn;
            
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_POSITION);
            PreparedStatement ps = conn.prepareStatement("select * from stocks;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                titoli.add(rs.getString("name"));
            }
            rs.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProduttoreQuotazioni.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProduttoreQuotazioni.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
}

    private String scegliTitolo() {
        int whichMsg;
        Random randomGen = new Random();

        whichMsg = randomGen.nextInt(this.titoli.size());
        return this.titoli.get(whichMsg);
    }

    private float valore() {
        Random randomGen = new Random();
        float val = randomGen.nextFloat() * this.titoli.size() * 10;
        return val;
    }

    private static final Logger LOG = LoggerFactory.getLogger(ProduttoreQuotazioni.class);

    public void start() throws NamingException, JMSException {

        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        javax.jms.Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageProducer producer = null;
        String destinationName = "dynamicTopics/students";

        /*
         * Create a JNDI API InitialContext object
         */
        try {

            Properties props = new Properties();

            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://192.168.50.83:61616");
            jndiContext = new InitialContext(props);

        } catch (NamingException e) {
            LOG.info("ERROR in JNDI: " + e.toString());
            System.exit(1);
        }

        /*
         * Look up connection factory and destination.
         */
        try {
            connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            destination = (Destination) jndiContext.lookup(destinationName);
        } catch (NamingException e) {
            LOG.info("JNDI API lookup failed: " + e);
            System.exit(1);
        }

        /*
         * Create connection. Create session from connection; false means
         * session is not transacted. Create sender and text message. Send
         * messages, varying text slightly. Send end-of-messages message.
         * Finally, close connection.
         */
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);

            TextMessage message = null;
            String stock = null;

            message = session.createTextMessage();

            float quotazione;
            String myID = "1947850";
            int i = 0;
            while (true) {
                i++;
                stock = scegliTitolo();
                quotazione = valore();
                message.setStringProperty("student", myID);
                message.setStringProperty("name", stock);
                message.setFloatProperty("value", quotazione);
                message.setText(
                        "Item " + i +" from student "+myID+": "+ stock + ", Valore: "
                        + quotazione);

                LOG.info(
                        this.getClass().getName()
                        + "Invio quotazione -> " + message.getText());

                producer.send(message);

                try {
                    Thread.sleep(5000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (JMSException e) {
            LOG.info("Exception occurred: " + e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                }
            }
        }
    }
}
