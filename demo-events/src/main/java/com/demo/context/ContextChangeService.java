package com.demo.context;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-09 19:41
 * @desc:
 */

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ContextChangeService {

//    @Bean
//    ContextMultipleListener contextMultipleListener() {
//        return new ContextMultipleListener();
//    }

    public void changeContxt() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextChangeService.class);

        System.out.println("-- stopping context --");
        context.stop();

        System.out.println("-- starting context --");
        context.start();
        System.out.println("-- closing context --");
        context.close();
    }
}
