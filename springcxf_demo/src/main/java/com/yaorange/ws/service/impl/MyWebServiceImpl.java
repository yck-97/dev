package com.yaorange.ws.service.impl;

import com.yaorange.ws.service.MyWebService;

/**
 * @description:
 * @company: yaorange
 * @author: Mr.Huang
 * @version: 1.0
 * @create: 11-06-24 11:10:08
 */
public class MyWebServiceImpl implements MyWebService {
    @Override
    public String helloworld(String txt) {
        System.out.println("客户端请求服务......");
        if("one".equals(txt)){
            return "hello world";
        }else if("two".equals(txt)){
            return "welcome yaorange";
        }else{
            return "null";
        }
    }
}
