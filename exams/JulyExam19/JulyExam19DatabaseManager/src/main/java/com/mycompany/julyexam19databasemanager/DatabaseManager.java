/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.julyexam19databasemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author biar
 */
public class DatabaseManager {
    
    private static boolean DEBUG = true;
    
    private static void initDatabase(Connection connection) throws SQLException {
        
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        
        statement.executeUpdate("DROP TABLE IF EXISTS DIRECTORS;");
        statement.executeUpdate("DROP TABLE IF EXISTS MOVIES;");
        statement.executeUpdate("CREATE TABLE DIRECTORS (id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                                                        "name STRING, "     + 
                                                        "year STRING );"
                                );
        statement.executeUpdate("CREATE TABLE MOVIES (id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                                                     "directorId INTEGER, "  +
                                                     "title STRING, "   +
                                                     "year STRING, " + 
                                                     "FOREIGN KEY (directorId) REFERENCES DIRECTORS(id));"
                                );
        statement.executeUpdate("INSERT INTO DIRECTORS VALUES(0, 'Kathryn Bigelow', '1951');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(0, 'Point Break', '1991');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(0, 'K-19: The Widowmaker', '2002');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(0, 'The Hurt Locker', '2008');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(0, 'Zero Dark Thirty', '2012');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(0, 'Detroit', '2017');");

        statement.executeUpdate("INSERT INTO DIRECTORS VALUES(1, 'Neill Blomkamp', '1979');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(1, 'District 9', '2009');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(1, 'Elysium', '2013');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(1, 'Chappie', '2015');");

        statement.executeUpdate("INSERT INTO DIRECTORS VALUES(2, 'Jason Reitman', '1977');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(2, 'Up in the Air', '2009');");

        statement.executeUpdate("INSERT INTO DIRECTORS VALUES(3, 'Quentin Tarantino', '1963');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(3, 'Reservoir Dogs', '1992');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(3, 'Pulp Fiction', '1994');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(3, 'Kill Bill: Volume 1', '2003');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(3, 'Kill Bill: Volume 2', '2004');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(3, 'Inglourious Basterds', '2009');");
        statement.executeUpdate("INSERT INTO MOVIES(directorId, title, year) VALUES(3, 'Django Unchained', '2012');");
        
        if (DEBUG){
            testDatabase(statement);
        }
        
    }
    
    private static void testDatabase(Statement statement) throws SQLException {
        ResultSet rs1 = statement.executeQuery("SELECT * FROM DIRECTORS");
        while (rs1.next()) {
            System.out.println("Director " + rs1.getInt("id")
                               + " is " + rs1.getString("name")
                               + " and was born in " + rs1.getString("year"));
        }

        ResultSet rs2 = statement.executeQuery("SELECT * FROM MOVIES");
        while (rs2.next()) {
            System.out.println("Movie " + rs1.getInt("id")
                               + " is " + rs1.getString("title") + " (" + rs1.getString("year") + ")"
                               + " and was directed by " + rs2.getInt("directorId"));
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/biar/MovieServiceDatabase.db");
            
            initDatabase(connection);
            
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
        
    }

    
}
