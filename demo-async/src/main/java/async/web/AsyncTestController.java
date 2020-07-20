package async.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/*
 * Author: Bruce Zhao
 * Date: 2020/6/17 17:00
 * Desc:
 */
@Slf4j
@RestController
public class AsyncTestController {

  @PostMapping(value = "/instrument/test")
  public ResponseEntity<String> job() {
    // executor.submit(this::doTask);
    return ResponseEntity.ok("ok");
  }
  
  @PostMapping(value = "/instrument/test/2")
  public void test2(
  ) {
    log.info("start");
  }
  
  public void doTask() {
    log.info("Looking up ");
    // User results = restTemplate.getForObject(url, User.class);
    // Artificial delay of 1s for demonstration purposes
    try {
      TimeUnit.SECONDS.sleep(2);
      log.info("in thread");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  @PostMapping(value = "/instrument/test/3")
  public Runnable runnable() {
    return () -> {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      log.info("in thread callable");
    };
  }
  
  @PostMapping(value = "/instrument/test/4")
  public Callable<String> callable() {
    return () -> {
      Thread.sleep(2000);
      log.info("in thread callable");
      return "Callable result";
    };
  }
  
  @PostMapping(value = "/instrument/test/5")
  public Callable<String> def() {
    return () -> {
      Thread.sleep(2000);
      log.info("in thread callable");
      return "Callable result";
    };
  }
  
  
  @PostMapping(value = "/instrument/test/6")
  public WebAsyncTask<String> callableTimeout() {
    Callable<String> callable = () -> {
      Thread.sleep(2000);
      log.info("in thread 3");
      return "Callable result";
    };
    return new WebAsyncTask<String>(100000, callable);
  }
  
}
