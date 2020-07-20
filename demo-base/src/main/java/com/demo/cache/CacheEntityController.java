package com.demo.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * Author: Bruce Zhao
 * Date: 2020/1/17 14:42
 * Desc:
 */
@RestController
public class CacheEntityController {
  @Autowired
  private CacheEntityService cacheEntityService;

  @GetMapping("/token/{id}")
  public String getToken(@PathVariable String id) {
    String token = cacheEntityService.getToken(id);
    return token;
  }

  @GetMapping("/token/cache/{id}")
  public String cacheToken(@PathVariable String id) {
    String token = cacheEntityService.getCacheToken(id);
    return token;
  }


  @GetMapping("/token/remove")
  public void getToken() {
    cacheEntityService.removeCache();
  }
}
