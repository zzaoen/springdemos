package com.stubhub.Async;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-13 14:25
 * @desc:
 */

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class UserAnnotationListener {

    @EventListener
    public void regist(UserRegisterEvent userRegisterEvent) {
        System.out.println("anno" + userRegisterEvent.getMessage());
    }
}
