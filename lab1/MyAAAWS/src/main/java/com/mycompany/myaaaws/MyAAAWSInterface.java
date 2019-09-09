/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myaaaws;

import javax.jws.WebService;
/**
 *
 * @author biar
 */
@WebService
public interface MyAAAWSInterface {
    /*
        java.lang.String[] getClients() - returns all the IDs and names of clients
        stored in the security sub-system 1 .
    */
    public java.lang.String[] getClients();
    
}
