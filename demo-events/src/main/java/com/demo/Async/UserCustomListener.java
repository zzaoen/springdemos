package com.demo.Async;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-13 14:36
 * @desc:
 */

import org.springframework.context.ApplicationListener;

//@Component
public class UserCustomListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("custom" + userRegisterEvent.getMessage());
    }
}
