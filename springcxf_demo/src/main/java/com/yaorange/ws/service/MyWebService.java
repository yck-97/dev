package com.yaorange.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MyWebService {
    public String helloworld(String txt);
}
