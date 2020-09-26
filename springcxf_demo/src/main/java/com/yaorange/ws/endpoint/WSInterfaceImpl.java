package com.yaorange.ws.endpoint;

public class WSInterfaceImpl implements WSInterface {
    @Override
    public String getName(String str) {
        System.out.println("服务调用");
        if("zhangsan".equals(str)){
            return "张三";
        }
        return null;
    }
}
