/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.julyexam19client;

import com.mycompany.julyexam19soapserver.Movie;
import com.mycompany.julyexam19soapserver.Director;
import com.mycompany.julyexam19soapserver.ExamImplService;
import com.mycompany.julyexam19soapserver.ExamInterface;
import java.util.List;

/**
 *
 * @author biar
 */
public class Client {
    
    private static Movie getMovieById(int id) {
        ExamImplService service = new ExamImplService();
        ExamInterface port = service.getExamImplPort();
        return port.getMovieById(id);
    }
    
    private static List<Movie> getMovies() {
        ExamImplService service = new ExamImplService();
        ExamInterface port = service.getExamImplPort();
        return port.getMovies();
    }
    
    private static Director getDirectorById(int id) {
        ExamImplService service = new ExamImplService();
        ExamInterface port = service.getExamImplPort();
        return port.getDirectorById(id);
    }
    
    private static void printMovie(Movie m) {
        String ret = "";
        ret += "Movie ID: "+m.getId()+",\n";
        ret += "Title: "+m.getTitle()+",\n";
        ret += "Year: "+m.getYear()+",";
        
        System.out.println(ret);
    }
    
    private static void printDirector(Director d) {
        String ret = "";
        ret += "Director ID: "+d.getId()+",\n";
        ret += "Director name: "+d.getName()+",\n";
        ret += "Director year: "+d.getYear()+".\n";
        
        System.out.println(ret);
    }
    
    public static void main(String[] args) {
        
        List<Movie> movies = getMovies();
        for (Movie movie: movies) {
            printMovie(movie);
            Director director = getDirectorById(movie.getDirector());
            printDirector(director);
        }
        
    }
    
}
