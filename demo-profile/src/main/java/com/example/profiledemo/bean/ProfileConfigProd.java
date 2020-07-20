package com.example.profiledemo.bean;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-03-15 08:26
 * @desc:
 */

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class ProfileConfigProd {
    public static void whoAmI() {
        System.out.println("It's Dev Profile");
    }
}
