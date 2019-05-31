package com.stubhub.Sync;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-09 19:53
 * @desc:
 */

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Component
public class CustomAnnotationEventListener {

    @EventListener
    public void handleCustemEvent(CustomSpringEvent customSpringEvent) {
        System.out.println("111" + customSpringEvent.getMessage());
    }
}
