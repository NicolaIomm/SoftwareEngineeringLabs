/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import it.uniroma1.generatedsource.*;

/**
 *
 * @author mecellone-dev
 */
public class WSProxy {
    
    private static final QName SERVICE_NAME
            = new QName("http://exam.softeng.sapienza.it/", "Interface");
    private static final QName PORT_NAME
            = new QName("http://exam.softeng.sapienza.it/", "InterfaceImplPort");

    private static Service service = null;
    private static Interface proxy = null;
    
        private static WSProxy instance = null;
    private static int count = 0;
    
    private WSProxy() {
    
        service = Service.create(SERVICE_NAME);
            final String endpointAddress = "http://localhost:8080/Interface";
            service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        proxy = service.getPort(PORT_NAME, Interface.class);
        
        System.out.println("... SOAP client pronto ...");
    }

    public static WSProxy getInstance() {
        
        if (count == 0) {
            count = 1;
            instance = new WSProxy();
        }
        
        return instance;
    }
      
    public Professor getProfessor(String id) {
        
        System.out.println(" ... chiedo professore " + id + " al Web service ...");
        return proxy.getDetails(id);
        
    }    
}
