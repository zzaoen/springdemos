package com.example.profiledemo.controller;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-03-15 09:00
 * @desc:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Profile("!dev")
public class HelloControllerProd {

    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String index() {

        String activeProfile = Arrays.asList(environment.getActiveProfiles()).toString();

        String profileName = environment.getProperty("profile.name");

        return "Greetings from !DEV, activeProfiles" + activeProfile + " , profileName = " + profileName;
    }
}
