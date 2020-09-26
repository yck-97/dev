package com.yaorange.service.impl;

import com.yaorange.service.UserService;
import com.yaorange.ws.MyWebService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "wsTest")
    private MyWebService webService;
    @Override
    public String useWs(String txt) {
        return webService.helloworld(txt);
    }
}
