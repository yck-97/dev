
package com.yaorange.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yaorange.ws package. 
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

    private final static QName _Helloworld_QNAME = new QName("http://service.ws.yaorange.com/", "helloworld");
    private final static QName _HelloworldResponse_QNAME = new QName("http://service.ws.yaorange.com/", "helloworldResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yaorange.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Helloworld }
     * 
     */
    public Helloworld createHelloworld() {
        return new Helloworld();
    }

    /**
     * Create an instance of {@link HelloworldResponse }
     * 
     */
    public HelloworldResponse createHelloworldResponse() {
        return new HelloworldResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Helloworld }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.yaorange.com/", name = "helloworld")
    public JAXBElement<Helloworld> createHelloworld(Helloworld value) {
        return new JAXBElement<Helloworld>(_Helloworld_QNAME, Helloworld.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloworldResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.yaorange.com/", name = "helloworldResponse")
    public JAXBElement<HelloworldResponse> createHelloworldResponse(HelloworldResponse value) {
        return new JAXBElement<HelloworldResponse>(_HelloworldResponse_QNAME, HelloworldResponse.class, null, value);
    }

}
