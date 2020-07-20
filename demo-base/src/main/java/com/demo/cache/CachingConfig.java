package com.demo.cache;

/*
 * Author: Bruce Zhao
 * Date: 2020/1/17 14:32
 * Desc:
 */

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
//  @Bean
//  public CacheManager cacheManager() {
//    return new ConcurrentMapCacheManager("token");
//  }
}
