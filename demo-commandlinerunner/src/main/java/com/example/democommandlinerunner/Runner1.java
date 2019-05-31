package com.example.democommandlinerunner;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-03-22 13:33
 * @desc: CommandLineRunner，在Springboot容器启动之后执行，可以用来对
 * 应用程序进行初始化，线程池等。
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Runner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runer1 start");
    }
}
