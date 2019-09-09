/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.julyexam19soapserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author biar
 */

@WebService(endpointInterface = "com.mycompany.julyexam19soapserver.ExamInterface")
public class ExamImpl implements ExamInterface {

    private Connection connection;
    
    public ExamImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/biar/MovieServiceDatabase.db");
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new LinkedList<>();
        
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MOVIES;");
            statement.setQueryTimeout(30);
            
            ResultSet ret = statement.executeQuery();
            while (ret.next()){
                Movie movie =  new Movie(ret.getInt("id"), ret.getString("title"), ret.getString("year"), ret.getInt("directorId"));
                movies.add(movie);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return movies;
    }
    
    @Override
    public Movie getMovieById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MOVIES WHERE id = ?;");
            statement.setInt(1, id);
            statement.setQueryTimeout(30);
            
            ResultSet ret = statement.executeQuery();
            if (ret.next()){
                return new Movie(ret.getInt("id"), ret.getString("title"), ret.getString("year"), ret.getInt("directorId"));
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Director getDirectorById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DIRECTORS WHERE id = ?;");
            statement.setInt(1, id);
            statement.setQueryTimeout(30);
            
            ResultSet ret = statement.executeQuery();
            if(ret.next()) {
                return new Director(ret.getInt("id"), ret.getString("name"), ret.getString("year"));
            }
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public void close() throws SQLException {
        connection.close();
    }

    
}
