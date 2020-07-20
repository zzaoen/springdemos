package com.example.profiledemo.controller;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-03-15 09:00
 * @desc:
 */

import com.example.profiledemo.bean.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Profile("dev")
public class HelloControllerDev {
    @Autowired
    private Environment environment;
    @Autowired
    private MyProperties myProperties;
    @Value("${my.name}")
    private String myName;
    @RequestMapping("/")
    public String index() {
        System.out.println(myName);
        System.out.println(myProperties.getName());
        String profileName = environment.getProperty("my.name");
        return "Active profiles name: " + profileName;
    }
}
