/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.julyexam19soapserver;

import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author biar
 */

@WebService
public interface ExamInterface {
    
    List<Movie> getMovies();
    
    Movie getMovieById(int id);
    
    Director getDirectorById(int id);
    
}
