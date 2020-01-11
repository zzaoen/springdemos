package com.demo.context;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-09 18:58
 * @desc:
 */

import org.springframework.context.event.*;

public class ContextListener {

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        System.out.print("context refreshed event fired: ");
        System.out.println(event);
    }

    @EventListener
    public void handleContextStarted(ContextStartedEvent event) {
        System.out.print("context started event fired: ");
        System.out.println(event);
    }

    @EventListener
    public void handleContextStopped(ContextStoppedEvent event) {
        System.out.print("context stopped event fired: ");
        System.out.println(event);
    }

    @EventListener
    public void handleContextClosed(ContextClosedEvent event) {
        System.out.print("context  closed event fired: ");
        System.out.println(event);
    }
}
