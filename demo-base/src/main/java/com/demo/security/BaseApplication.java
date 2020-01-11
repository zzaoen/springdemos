package com.demo.security;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Data
public class BaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(BaseApplication.class, args);
  }
}
