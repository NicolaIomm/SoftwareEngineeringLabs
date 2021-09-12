
package soapwsclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soapwsclient.generated package. 
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

    private final static QName _GetCommercialInfo_QNAME = new QName("http://soapws.softeng.sapienza.it/", "getCommercialInfo");
    private final static QName _GetCommercialInfoResponse_QNAME = new QName("http://soapws.softeng.sapienza.it/", "getCommercialInfoResponse");
    private final static QName _GetETA_QNAME = new QName("http://soapws.softeng.sapienza.it/", "getETA");
    private final static QName _GetETAResponse_QNAME = new QName("http://soapws.softeng.sapienza.it/", "getETAResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapwsclient.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCommercialInfo }
     * 
     */
    public GetCommercialInfo createGetCommercialInfo() {
        return new GetCommercialInfo();
    }

    /**
     * Create an instance of {@link GetCommercialInfoResponse }
     * 
     */
    public GetCommercialInfoResponse createGetCommercialInfoResponse() {
        return new GetCommercialInfoResponse();
    }

    /**
     * Create an instance of {@link GetETA }
     * 
     */
    public GetETA createGetETA() {
        return new GetETA();
    }

    /**
     * Create an instance of {@link GetETAResponse }
     * 
     */
    public GetETAResponse createGetETAResponse() {
        return new GetETAResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommercialInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCommercialInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.softeng.sapienza.it/", name = "getCommercialInfo")
    public JAXBElement<GetCommercialInfo> createGetCommercialInfo(GetCommercialInfo value) {
        return new JAXBElement<GetCommercialInfo>(_GetCommercialInfo_QNAME, GetCommercialInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommercialInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCommercialInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.softeng.sapienza.it/", name = "getCommercialInfoResponse")
    public JAXBElement<GetCommercialInfoResponse> createGetCommercialInfoResponse(GetCommercialInfoResponse value) {
        return new JAXBElement<GetCommercialInfoResponse>(_GetCommercialInfoResponse_QNAME, GetCommercialInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetETA }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetETA }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.softeng.sapienza.it/", name = "getETA")
    public JAXBElement<GetETA> createGetETA(GetETA value) {
        return new JAXBElement<GetETA>(_GetETA_QNAME, GetETA.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetETAResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetETAResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.softeng.sapienza.it/", name = "getETAResponse")
    public JAXBElement<GetETAResponse> createGetETAResponse(GetETAResponse value) {
        return new JAXBElement<GetETAResponse>(_GetETAResponse_QNAME, GetETAResponse.class, null, value);
    }

}
