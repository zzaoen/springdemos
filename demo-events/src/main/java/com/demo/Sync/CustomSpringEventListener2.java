package com.demo.Sync;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-08 14:49
 * @desc:
 */

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomSpringEventListener2 implements ApplicationListener<CustomSpringEvent> {
    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
        try {
            System.out.println(new Date().getTime());
            Thread.sleep(1000);
            System.out.println(new Date().getTime());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("listner sleep finished");
        }
    }
}
