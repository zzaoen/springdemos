package com.example.profiledemo;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

@RestController
@SpringBootApplication
public class ProfileConfigDemo {

//    @Autowired
//    private WeekService weekService;

    @Autowired
    private Environment environment;

    public static void main(String[] args) throws IOException {
//        System.setProperty("spring.profiles.active", "prod");

//        String spring_profiles_active = System.getenv("SPRING_PROFILES_ACTIVE");
//        System.out.println(spring_profiles_active);

        SpringApplication.run(ProfileConfigDemo.class, args);
    }

    @RequestMapping("/test")
    String home() {
        System.out.println(environment.getProperty("my.name"));
        return Arrays.asList(environment.getActiveProfiles()).toString();

    }





}
