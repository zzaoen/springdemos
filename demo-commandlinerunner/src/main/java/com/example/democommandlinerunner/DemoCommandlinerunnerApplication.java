package com.example.democommandlinerunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCommandlinerunnerApplication {

    public static void main(String[] args) {
        System.out.println("Before service start");
        SpringApplication.run(DemoCommandlinerunnerApplication.class, args);
        System.out.println("After service start");
    }

}
