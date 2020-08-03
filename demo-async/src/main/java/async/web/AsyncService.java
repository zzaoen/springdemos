package async.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/*
 * Author: Bruce Zhao
 * Date: 2020/6/19 13:43
 * Desc:
 */
@Slf4j
@Service
public class AsyncService {
  
  @Async
  public void doTask() {
    try {
      TimeUnit.SECONDS.sleep(3);
      log.info("in thread 2");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  // Never expect Async method return result. For example, return ResponseEntity.ok(doTaskReturn()), always return null.
  // Async method return null, then will be run in another new thread. like task-1.
  @Async
  public String doTaskReturn() {
    try {
      TimeUnit.SECONDS.sleep(10);
      log.info("async task done");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("task return");
    return "done";
  }
}
