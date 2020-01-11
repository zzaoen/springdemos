package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zzhao3@stubhub.com
 * Date: 2019-07-05 09:34
 * Desc:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;
    String shell = null;
    Thread thread = null;

    @GetMapping("/run")
    public void run(){
        thread = new Thread(runnable);
        thread.start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            shell = "find /Users test";
            testService.runShell(shell);

        }
    };

    @GetMapping("/stop")
    public void stop(){
        thread.interrupt();
    }
}
