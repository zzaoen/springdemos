package com.demo.context;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-09 19:50
 * @desc:
 */

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.AsyncConfigurer;

//@Component
public class ContextMultipleListener implements AsyncConfigurer {

//    @Async("threadPoolTaskExecutor")
//    @Async
    @EventListener({ContextStoppedEvent.class, ContextStartedEvent.class})
    public void handleContextEvent() {
        System.out.println("event listener");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("listener sleep over\n");
        }
    }

//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setMaxPoolSize(100);
//        executor.initialize();
//        return executor;
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return null;
//    }

//    @Bean(name = "threadPoolTaskExecutor")
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setMaxPoolSize(100);
//        executor.initialize();
//        return executor;
//    }


    /*@EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        System.out.print("context refreshed event fired: ");
        System.out.println(event);
    }

    @EventListener
    public void handleContextStarted(ContextStartedEvent event) {
        System.out.print("context started event fired: ");
        System.out.println(event);
    }*/
}
