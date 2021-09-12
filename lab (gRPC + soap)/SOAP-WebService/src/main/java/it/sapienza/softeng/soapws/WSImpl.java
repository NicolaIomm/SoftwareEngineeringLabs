/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.soapws;

import java.util.ArrayList;
import java.util.Arrays;
import javax.jws.WebService;

@WebService(endpointInterface = "it.sapienza.softeng.soapws.WSInterface")
public class WSImpl implements WSInterface {

    ArrayList<Book> bookList = new ArrayList<Book>();
    
    {
        for(int i=0;i<10;i++){
           
            Book book = new Book();
            
            book.setID(Integer.toString(i+1));
            book.setPrice(9.99f);
            book.setSellers(new String[]{"Marco Calamo 3"});
            book.setEtas(new String[]{"1/1/2022"});
           
            bookList.add(book);

            
        }
    }
    public WSImpl() {}
   
    public String getCommercialInfo(String bookID){
        String result = "";
        for(Book book : bookList){
            if(book.getID().equals(bookID)){
                result += "Price: "+book.getPrice()+"\n";
                result += "Sellers: "+Arrays.toString(book.getSellers())+"\n\n";
            }
        }
        return result;
    }
    
    public String getETA(String bookID,String sellerName){
        String result = "";
        for(Book book : bookList){
            if(book.getID().equals(bookID)){
                for(int i=0;i<book.getSellers().length;i++){
                    if(book.getSellers()[i].equals(sellerName)){
                        result += "ETA for seller "+sellerName+": "+book.getEtas()[i]+"\n";
                    }
                }
            }
        }
        return result;
    }
  
}
