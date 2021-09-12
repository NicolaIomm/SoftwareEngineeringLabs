/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.jmssubscriber;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author biar
 */
public class JMSListener implements MessageListener {

    private static JMSListener instance = null;
    private static String myID = "1947850";

    private JMSListener() {
    }

    public static MessageListener getInstance() {
        if (instance == null) {
            instance = new JMSListener();
        }
        return instance;
    }

    @Override
    public void onMessage(Message msg) {
        try {
            String student = msg.getStringProperty("student");

            if(student.equals(myID)) {
                
                String name = msg.getStringProperty("name");
                float value = msg.getFloatProperty("value");
                System.out.println("New stock update for student "+myID+" -> Name:"+name+" Value: "+value);
            }
                
            
        } catch (JMSException err) {
            err.printStackTrace();
        } catch (NullPointerException exc) {
            //staysilent
        }
    }

}
