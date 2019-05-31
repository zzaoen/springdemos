package com.stubhub.Async;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-13 14:27
 * @desc:
 */

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class UserRegisterEvent extends ApplicationEvent {

    private String message;

    public UserRegisterEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
