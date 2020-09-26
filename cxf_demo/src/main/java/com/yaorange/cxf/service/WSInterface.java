package com.yaorange.cxf.service;
import javax.jws.WebService;

@WebService//标识当前服务接口为webService的SEI
public interface WSInterface {
    String sayHello(String name);
}
