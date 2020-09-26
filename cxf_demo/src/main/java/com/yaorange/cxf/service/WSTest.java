package com.yaorange.cxf.service;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class WSTest {
    public static void main(String[] args) {
        //使用JaxWsServerFactoryBean发布
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        //设置服务接口
        factoryBean.setServiceClass(WSInterface.class);
        //设置服务实现对象
        factoryBean.setServiceBean(new WSInterfaceImpl());
        //设置服务地址
        factoryBean.setAddress("http://127.0.0.1:1234/hello");
        //发布服务
        factoryBean.create();
        System.out.println("服务发布成功");
    }
}
