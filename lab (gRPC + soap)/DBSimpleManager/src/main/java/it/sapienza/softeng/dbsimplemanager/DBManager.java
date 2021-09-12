/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.dbsimplemanager;

import java.sql.*;



public class DBManager {

    public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");
        Connection conn
                = DriverManager.getConnection("jdbc:sqlite:books");
        Statement stat = conn.createStatement();

        
           
            
        stat.executeUpdate("drop table if exists AUTHORS;");
        stat.executeUpdate("create table AUTHORS (authorID, name, yearOfBirth);");

        stat.executeUpdate("drop table if exists BOOKS;");
        stat.executeUpdate("create table "
                + "BOOKS (ID, title, year, authorID, " 
                + "FOREIGN KEY (authorID) REFERENCES AUTHORS (ID));");

        PreparedStatement prep = conn.prepareStatement(
                "insert into AUTHORS values (?, ?, ?);");
        prep.setString(1, "1");
        prep.setString(2, "Marco Calamo");
        prep.setString(3, "17/02/1999");
        prep.addBatch();
        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);
            
            
        for(int i=0;i<10;i++){
            prep = conn.prepareStatement(
                    "insert into BOOKS values (?, ?, ?, ?);");
            prep.setString(1, Integer.toString(i+1));
            prep.setString(2, "Il Signore degli Anelli ed."+ (i+1));
            
            prep.setString(3, "1/1/201"+i);
           

            prep.setString(4, "1");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
        }
            
           
          
        ResultSet rs = stat.executeQuery("select BOOKS.title, BOOKS.year,BOOKS.ID,"
                + " AUTHORS.name as an,AUTHORS.yearOfBirth as ay "
                + "from BOOKS,AUTHORS" 
                + " where AUTHORS.authorID = BOOKS.authorID" );
        System.out.println("Books:");
        while (rs.next()) {

            System.out.print("Book out on: " + rs.getString("year") + " is : ");

            System.out.println(rs.getString("title"));

            System.out.println(rs.getString("an"));
            System.out.println(rs.getString("ay"));
        }
        rs.close();
       
        conn.close();
    }
}
