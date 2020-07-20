package com.demo.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Author: Bruce Zhao
 * Date: 2020/7/20 12:50
 * Desc:
 */
@Configuration
@ComponentScan
@EnableCaching
@Slf4j
public class CacheMain {

  @Bean
  public CacheManager cacheManager() {
    // ConcurrentMapCacheManager cacheManager =
    //     new ConcurrentMapCacheManager("token"); // vararg constructor
    // return cacheManager;
  
    ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("token", "test");
    return cacheManager;
  }

  public static void main(String[] args) {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(CacheMain.class);
  
    CacheEntityService cacheEntityService = applicationContext.getBean(CacheEntityService.class);
  
    String token;
    token = cacheEntityService.getCacheToken("1");
    log.info(token);
    
    // token = cacheEntityService.getToken("2");
    // log.info(token);
    
    // token = cacheEntityService.getRefreshToken("1");
    // log.info(token);
    token = cacheEntityService.getCacheTokenWithName("1", "zz");
    log.info(token);

    token = cacheEntityService.getToken("2");
    log.info(token);
  }
}
