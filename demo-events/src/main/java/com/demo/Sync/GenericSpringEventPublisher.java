package com.demo.Sync;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-09 19:12
 * @desc:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class GenericSpringEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void doStuffAndPublishAnEvent(final String message) {
        GenericSpringEvent<String> genericSpringEvent = new GenericSpringEvent("OK", 1);
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }
}
