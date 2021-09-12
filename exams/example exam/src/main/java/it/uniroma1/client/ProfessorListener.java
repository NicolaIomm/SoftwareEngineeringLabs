/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.client;

import it.uniroma1.generatedsource.Professor;
import java.util.logging.*;
import javax.jms.*;

public class ProfessorListener implements MessageListener {

    private WSProxy SOAPclient = WSProxy.getInstance();
 
    
    @Override
    public void onMessage(Message msg) {
        try {
            String idReceived = msg.getStringProperty("id");

            try { 

                Professor result = SOAPclient.getProfessor(idReceived);
                String name = result.getName();
                String surname = result.getSurname();
                String course = result.getCourse();

                System.out.println("Professor id: " + idReceived + ", name: " + name + ", surname: " + surname + ", course: " + course);
            } catch (Exception ex) {
                
            }

        } catch (JMSException ex) {
            Logger.getLogger(ProfessorListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
