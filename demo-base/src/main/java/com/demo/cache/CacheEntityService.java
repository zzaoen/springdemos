package com.demo.cache;

import ch.qos.logback.core.util.TimeUtil;
import io.micrometer.core.async.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/*
 * Author: Bruce Zhao
 * Date: 2020/1/17 14:40
 * Desc:
 */
@Service
@CacheConfig(cacheNames = "token")
public class CacheEntityService {

  @Autowired CacheManager cacheManager;

  

  @Cacheable
  public String getCacheToken(String id) {
    try {
      System.out.println("Going to sleep for 2 Secs.. to simulate backend call.");
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "currentToken" + id;
  }
  
  @CacheEvict(beforeInvocation = true)
  @Cacheable
  public String getRefreshToken(String id) {
    try {
      System.out.println("Going to sleep for 2 Secs.. to simulate backend call.");
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "currentToken-" + id;
  }
  
  @Cacheable
  public String getCacheTokenWithName(String id, String name) {
    try {
      System.out.println("Going to sleep for 2 Secs.. to simulate backend call.");
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "currentToken" + id + name;
  }
  
  public String getToken(String id) {
    return (String) cacheManager.getCache("token").get("1").get();
  }
  
  public String getTokenWithName(String id) {
    return (String) cacheManager.getCache("token").get(new SimpleKey("1", "zz")).get();
  }
  
  @CacheEvict(value = "token", allEntries = true)
  public void removeCache(){ }
  
  public void manualRemoveCache() {
    evictAllCacheValues("token");
  }
  private void evictAllCacheValues(String cacheName) {
    cacheManager.getCache(cacheName).clear();
  }
}
