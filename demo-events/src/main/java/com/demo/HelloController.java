package com.demo;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-08 14:58
 * @desc:
 */

import com.demo.Async.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HelloController {

    /*@Autowired
    private CustomSpringEventPublisher customSpringEventPublisher;

    @Autowired
    private GenericSpringEventPublisher genericSpringEventPublisher;

    @Autowired
    private ContextChangeService contextChange;*/

    @Autowired
    private UserService userService;

    /*@RequestMapping("/hello")
    public void hello() {
        customSpringEventPublisher.doStuffAndPublishAnEvent("hello");
    }

    @RequestMapping("/world")
    public void world() {
        genericSpringEventPublisher.doStuffAndPublishAnEvent("hello");
        contextChange.changeContxt();
    }*/


    @RequestMapping("/re")
    public String register() {
        userService.register(new Date().toString());
        return "home";
    }

}
