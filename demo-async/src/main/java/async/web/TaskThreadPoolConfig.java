package async.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

/*
 * Author: Bruce Zhao
 * Date: 2020/8/3 14:49
 * Desc:
 */
// @Configuration
public class TaskThreadPoolConfig implements WebMvcConfigurer {
  
  @Bean("taskExecutor")
  public ThreadPoolTaskExecutor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(5);
    executor.setMaxPoolSize(10);
    // executor.setQueueCapacity(200);
    executor.setQueueCapacity(5);
    executor.setKeepAliveSeconds(10);
    executor.setThreadNamePrefix("async-");
    
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.initialize();
    return executor;
  }
  
  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    configurer.setDefaultTimeout(60 * 1000L);
    configurer.registerCallableInterceptors(new TimeoutCallableProcessingInterceptor());
    configurer.setTaskExecutor(taskExecutor());
  }
}
