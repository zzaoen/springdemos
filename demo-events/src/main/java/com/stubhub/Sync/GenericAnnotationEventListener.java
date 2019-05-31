package com.stubhub.Sync;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-09 19:09
 * @desc:
 */

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GenericAnnotationEventListener {

    @EventListener(condition = "#event.code == 1")
    public void handleSuccessful(GenericSpringEvent event) {
        System.out.println("generic event: " + event);
    }

}
