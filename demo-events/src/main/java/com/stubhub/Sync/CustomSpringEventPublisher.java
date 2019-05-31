package com.stubhub.Sync;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-08 14:47
 * @desc:
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class CustomSpringEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void doStuffAndPublishAnEvent(final String message) {
        System.out.println("Publishing custom event. ");
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);

        System.out.println("before publish event");

        applicationEventPublisher.publishEvent(customSpringEvent);
        System.out.println("publisher finished" + new Date().getTime());
    }
}
