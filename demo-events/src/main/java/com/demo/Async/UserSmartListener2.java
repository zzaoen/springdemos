package com.demo.Async;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-13 14:44
 * @desc:
 */

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class UserSmartListener2 implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == UserRegisterEvent.class;
    }

    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        try {
            Thread.sleep(3000);//静静的沉睡3秒钟
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        UserRegisterEvent userRegisterEvent = (UserRegisterEvent) applicationEvent;
        System.out.println("2" + userRegisterEvent.getMessage());
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
