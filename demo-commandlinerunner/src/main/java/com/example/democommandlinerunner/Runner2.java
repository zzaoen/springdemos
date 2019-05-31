package com.example.democommandlinerunner;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-03-22 13:33
 * @desc:
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Runner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runer2 start");
    }
}
