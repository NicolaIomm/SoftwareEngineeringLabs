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

@WebService (endpointInterface = "com.mycompany.myaaaws.MyAAAWSInterface")
public class MyAAAWSImpl implements MyAAAWSInterface {
    /*
        java.lang.String[] getClients() - returns all the IDs and names of clients
        stored in the security sub-system 1 .
        The result is returned as an array of strings, each string being the append of a client id, a
        comma and its name; as an example, a possible string might be “1,Massimo
        Mecella” and a complete result might be
        [“1,Massimo Mecella” “2,Miguel Ceriani”]. It is required that the
        operation returns at least the example shown above (in order to have some data matching
        with the ones on the instructor’s Web service).
    */
    public java.lang.String[] getClients(){
        String list[] = new String[2];
        list[0] = "1,Massimo Mecella";
        list[1] = "2,Miguel Ceriani";
        return list;
    }
}
