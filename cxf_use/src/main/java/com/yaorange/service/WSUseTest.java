package com.yaorange.service;


import com.yaorange.service.ws.WSInterface;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class WSUseTest {
    public static void main(String[] args) {
        //通过JaxWsProxyFactoryBean调用服务
        JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
        //设置服务接口
        proxyFactoryBean.setServiceClass(WSInterface.class);
        //设置服务地址
        proxyFactoryBean.setAddress("http://127.0.0.1:1234/hello");
        //设置服务接口实现对象
        WSInterface wsInterface = proxyFactoryBean.create(WSInterface.class);
        String s = wsInterface.sayHello("张三");
        System.out.println(s);
    }
}
