package com.example.profiledemo.controller;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-03-19 08:24
 * @desc:
 */

import com.example.profiledemo.service.ProfileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProfileController {

    @Resource
    ProfileService profileService;

    @RequestMapping("/profile")
    public String profileMessage(){
        return profileService.getMessage();
    }
}
