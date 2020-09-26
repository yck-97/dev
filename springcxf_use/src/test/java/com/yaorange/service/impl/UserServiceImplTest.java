package com.yaorange.service.impl;

import com.yaorange.service.UserService;
import com.yaorange.ws.mobile.MobileCodeWSSoap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:applicationContext-ws.xml"})
@SuppressWarnings("all")
public class UserServiceImplTest {
    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "mobileCodeTest")
    private MobileCodeWSSoap mobileCode;

    @Test
    public void useWs() {
        String str = userService.useWs("two");
        System.out.println(str);
    }

    @Test
    public void mobileTest(){
        String codeInfo = mobileCode.getMobileCodeInfo("15882448822", null);
        System.out.println(codeInfo);
    }
}
