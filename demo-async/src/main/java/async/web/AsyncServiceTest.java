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
public class AsyncServiceTest {
  
  @Async
  public void doTask2() {
    try {
      TimeUnit.SECONDS.sleep(3);
      log.info("in thread 2");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
