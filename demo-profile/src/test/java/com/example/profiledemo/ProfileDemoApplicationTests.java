package com.example.profiledemo;

import com.example.profiledemo.service.ProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class ProfileDemoApplicationTests {

    @Autowired
    private Environment environment;

    @Autowired
    ProfileService profileServicek;


    @Test
    public void contextLoads() {
        System.out.println(profileServicek.getMessage());
    }

}
