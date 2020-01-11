package com.demo.Async;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-13 14:25
 * @desc:
 */

import org.springframework.context.event.EventListener;

//@Component
public class UserAnnotationListener {

    @EventListener
    public void regist(UserRegisterEvent userRegisterEvent) {
        System.out.println("anno" + userRegisterEvent.getMessage());
    }
}
