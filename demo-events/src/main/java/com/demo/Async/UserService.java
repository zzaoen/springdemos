package com.demo.Async;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-13 14:29
 * @desc:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    ApplicationContext applicationContext;

    public void register(String user)
    {
        //../省略其他逻辑

        //发布UserRegisterEvent事件
        applicationContext.publishEvent(new UserRegisterEvent(this,user));
    }

}
