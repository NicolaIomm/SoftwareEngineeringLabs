
package com.mycompany.julyexam19soapserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.julyexam19soapserver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMovies_QNAME = new QName("http://julyexam19soapserver.mycompany.com/", "getMovies");
    private final static QName _GetMovieById_QNAME = new QName("http://julyexam19soapserver.mycompany.com/", "getMovieById");
    private final static QName _GetDirectorById_QNAME = new QName("http://julyexam19soapserver.mycompany.com/", "getDirectorById");
    private final static QName _GetMoviesResponse_QNAME = new QName("http://julyexam19soapserver.mycompany.com/", "getMoviesResponse");
    private final static QName _Movie_QNAME = new QName("http://julyexam19soapserver.mycompany.com/", "movie");
    private final static QName _Director_QNAME = new QName("http://julyexam19soapserver.mycompany.com/", "director");
    private final static QName _GetDirectorByIdResponse_QNAME = new QName("http://julyexam19soapserver.mycompany.com/", "getDirectorByIdResponse");
    private final static QName _GetMovieByIdResponse_QNAME = new QName("http://julyexam19soapserver.mycompany.com/", "getMovieByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.julyexam19soapserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMovieById }
     * 
     */
    public GetMovieById createGetMovieById() {
        return new GetMovieById();
    }

    /**
     * Create an instance of {@link GetMovies }
     * 
     */
    public GetMovies createGetMovies() {
        return new GetMovies();
    }

    /**
     * Create an instance of {@link GetDirectorById }
     * 
     */
    public GetDirectorById createGetDirectorById() {
        return new GetDirectorById();
    }

    /**
     * Create an instance of {@link GetMoviesResponse }
     * 
     */
    public GetMoviesResponse createGetMoviesResponse() {
        return new GetMoviesResponse();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Director }
     * 
     */
    public Director createDirector() {
        return new Director();
    }

    /**
     * Create an instance of {@link GetDirectorByIdResponse }
     * 
     */
    public GetDirectorByIdResponse createGetDirectorByIdResponse() {
        return new GetDirectorByIdResponse();
    }

    /**
     * Create an instance of {@link GetMovieByIdResponse }
     * 
     */
    public GetMovieByIdResponse createGetMovieByIdResponse() {
        return new GetMovieByIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://julyexam19soapserver.mycompany.com/", name = "getMovies")
    public JAXBElement<GetMovies> createGetMovies(GetMovies value) {
        return new JAXBElement<GetMovies>(_GetMovies_QNAME, GetMovies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://julyexam19soapserver.mycompany.com/", name = "getMovieById")
    public JAXBElement<GetMovieById> createGetMovieById(GetMovieById value) {
        return new JAXBElement<GetMovieById>(_GetMovieById_QNAME, GetMovieById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectorById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://julyexam19soapserver.mycompany.com/", name = "getDirectorById")
    public JAXBElement<GetDirectorById> createGetDirectorById(GetDirectorById value) {
        return new JAXBElement<GetDirectorById>(_GetDirectorById_QNAME, GetDirectorById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://julyexam19soapserver.mycompany.com/", name = "getMoviesResponse")
    public JAXBElement<GetMoviesResponse> createGetMoviesResponse(GetMoviesResponse value) {
        return new JAXBElement<GetMoviesResponse>(_GetMoviesResponse_QNAME, GetMoviesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://julyexam19soapserver.mycompany.com/", name = "movie")
    public JAXBElement<Movie> createMovie(Movie value) {
        return new JAXBElement<Movie>(_Movie_QNAME, Movie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Director }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://julyexam19soapserver.mycompany.com/", name = "director")
    public JAXBElement<Director> createDirector(Director value) {
        return new JAXBElement<Director>(_Director_QNAME, Director.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectorByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://julyexam19soapserver.mycompany.com/", name = "getDirectorByIdResponse")
    public JAXBElement<GetDirectorByIdResponse> createGetDirectorByIdResponse(GetDirectorByIdResponse value) {
        return new JAXBElement<GetDirectorByIdResponse>(_GetDirectorByIdResponse_QNAME, GetDirectorByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://julyexam19soapserver.mycompany.com/", name = "getMovieByIdResponse")
    public JAXBElement<GetMovieByIdResponse> createGetMovieByIdResponse(GetMovieByIdResponse value) {
        return new JAXBElement<GetMovieByIdResponse>(_GetMovieByIdResponse_QNAME, GetMovieByIdResponse.class, null, value);
    }

}
