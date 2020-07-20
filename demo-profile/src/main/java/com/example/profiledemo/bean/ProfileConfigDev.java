package com.example.profiledemo.bean;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-03-15 08:26
 * @desc:
 */

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class ProfileConfigDev {

    public static void whoAmI() {
        System.out.println("It's Dev Profile");
    }
}
