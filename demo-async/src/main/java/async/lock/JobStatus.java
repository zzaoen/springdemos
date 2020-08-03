package async.lock;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Author: Bruce Zhao
 * Date: 2020/6/20 10:53
 * Desc:
 */
public class JobStatus {
  ReentrantLock lock;
  Date startTime;
  
  public JobStatus() {
    this.lock = new ReentrantLock();
    this.startTime = Date.from(Instant.now());
  }
  
  public JobStatus(ReentrantLock lock, Date startTime) {
    this.lock = lock;
    this.startTime = startTime;
  }
}
