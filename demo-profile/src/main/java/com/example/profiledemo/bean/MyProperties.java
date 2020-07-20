package com.example.profiledemo.bean;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-03-21 17:48
 * @desc:
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my")
public class MyProperties {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
