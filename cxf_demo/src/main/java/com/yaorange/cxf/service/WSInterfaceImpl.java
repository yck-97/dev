package com.yaorange.cxf.service;

public class WSInterfaceImpl implements WSInterface {
    @Override
    public String sayHello(String name) {
        return name+"欢迎你.......";
    }
}
