package com.demo.Sync;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-08 14:46
 * @desc:
 */

import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent {
    private String message;

    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
