package com.yaorange.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.13
 * 2020-06-24T10:36:39.617+08:00
 * Generated source version: 3.2.13
 *
 */
@WebService(targetNamespace = "http://service.cxf.yaorange.com/", name = "WSInterface")
@XmlSeeAlso({ObjectFactory.class})
public interface WSInterface {

    @WebMethod
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://service.cxf.yaorange.com/", className = "com.yaorange.service.ws.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://service.cxf.yaorange.com/", className = "com.yaorange.service.ws.SayHelloResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}