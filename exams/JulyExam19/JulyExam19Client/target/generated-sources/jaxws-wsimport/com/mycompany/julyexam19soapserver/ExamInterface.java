
package com.mycompany.julyexam19soapserver;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ExamInterface", targetNamespace = "http://julyexam19soapserver.mycompany.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ExamInterface {


    /**
     * 
     * @return
     *     returns java.util.List<com.mycompany.julyexam19soapserver.Movie>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMovies", targetNamespace = "http://julyexam19soapserver.mycompany.com/", className = "com.mycompany.julyexam19soapserver.GetMovies")
    @ResponseWrapper(localName = "getMoviesResponse", targetNamespace = "http://julyexam19soapserver.mycompany.com/", className = "com.mycompany.julyexam19soapserver.GetMoviesResponse")
    public List<Movie> getMovies();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.mycompany.julyexam19soapserver.Movie
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMovieById", targetNamespace = "http://julyexam19soapserver.mycompany.com/", className = "com.mycompany.julyexam19soapserver.GetMovieById")
    @ResponseWrapper(localName = "getMovieByIdResponse", targetNamespace = "http://julyexam19soapserver.mycompany.com/", className = "com.mycompany.julyexam19soapserver.GetMovieByIdResponse")
    public Movie getMovieById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.mycompany.julyexam19soapserver.Director
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDirectorById", targetNamespace = "http://julyexam19soapserver.mycompany.com/", className = "com.mycompany.julyexam19soapserver.GetDirectorById")
    @ResponseWrapper(localName = "getDirectorByIdResponse", targetNamespace = "http://julyexam19soapserver.mycompany.com/", className = "com.mycompany.julyexam19soapserver.GetDirectorByIdResponse")
    public Director getDirectorById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
