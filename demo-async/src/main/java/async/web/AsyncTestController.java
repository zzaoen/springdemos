package async.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.*;

/*
 * Author: Bruce Zhao
 * Date: 2020/6/17 17:00
 * Desc:
 */
@Slf4j
@RestController
public class AsyncTestController {
  ExecutorService service = Executors.newSingleThreadExecutor();
  
  @Autowired AsyncService asyncService;
  
  @PostMapping(value = "/async/test")
  public ResponseEntity<String> test() throws InterruptedException {
    log.info("in test");
    TimeUnit.SECONDS.sleep(10);
    return ResponseEntity.ok("done");
  }
  
  @PostMapping(value = "/async/test/1")
  public ResponseEntity<String> test1() throws InterruptedException, ExecutionException {
    log.info("in test 1");
    Future<Integer> submit = service.submit(this::doTaskReturn);
    // log.info("task done: " + submit.get());
    return ResponseEntity.ok("ok");
  }

  @PostMapping(value = "/async/test/2")
  public ResponseEntity<String> test2() {
    log.info("in test 2");
    new Thread(() -> {
      try {
        TimeUnit.SECONDS.sleep(10);
        log.info("thread done");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
    log.info("task done");
    return ResponseEntity.ok("done");
  }

  public void doTask() {
    // User results = restTemplate.getForObject(url, User.class);
    // Artificial delay of 1s for demonstration purposes
    try {
      TimeUnit.SECONDS.sleep(10);
      log.info("in do task, time consuming task done");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  public int doTaskReturn() {
    // User results = restTemplate.getForObject(url, User.class);
    // Artificial delay of 1s for demonstration purposes
    try {
      TimeUnit.SECONDS.sleep(10);
      log.info("in do task, time consuming task done");
      return 1;
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return 1;
  }

  @PostMapping(value = "/async/test/3")
  public Callable<String> callable3() {
    log.info("start");
    Callable<String> callable = () -> {
      log.info("in callable");
      TimeUnit.SECONDS.sleep(10);
      return "done";
    };
    log.info("end");
    return callable;
  }

  @PostMapping(value = "/async/test/4")
  public ResponseEntity<String> callable4() {
    // return () -> {
    //   Thread.sleep(2000);
    //   log.info("in thread callable");
    //   return "Callable result";
    // };
    log.info("in test 4");
    String s = asyncService.doTaskReturn();
    return ResponseEntity.ok(s);
  }
  
  @PostMapping(value = "/async/test/5")
  public WebAsyncTask<String> callableTimeout() {
    Callable<String> callable =
        () -> {
          Thread.sleep(2000);
          log.info("in thread 6");
          return "Callable result";
        };
    return new WebAsyncTask<String>(1000, callable);
  }
}
