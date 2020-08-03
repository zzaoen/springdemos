package async.lock;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Author: Bruce Zhao
 * Date: 2020/6/20 10:52
 * Desc:
 */
public class JobStatusMonitor {
  
  private final HashMap<String, JobStatus> jobStatusMap;
  
  public JobStatusMonitor() {
    this.jobStatusMap = new HashMap<>();
    jobStatusMap.put("job-1", new JobStatus());
    jobStatusMap.put("job-2", new JobStatus());
  }
  
  public static void main(String[] args) throws InterruptedException {
    JobStatusMonitor jobStatusMonitor = new JobStatusMonitor();
    String jobName = "job-1";
    new Thread(() -> jobStatusMonitor.perform(jobName)).start();
    
    TimeUnit.SECONDS.sleep(1);
  
    new Thread(() -> jobStatusMonitor.performTryLock(jobName)).start();
  
    // TimeUnit.SECONDS.sleep(1);
    // new Thread(() -> jobStatusMonitor.performTryLock(jobName)).start();
  
  }
  
  public void perform(String jobName) {
    ReentrantLock lock = jobStatusMap.get(jobName).lock;
    lock.lock();
    try {
      // Critical section here
      TimeUnit.SECONDS.sleep(5);
      System.out.println(Thread.currentThread().getName());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
  
  public void performTryLock(String jobName) {
    ReentrantLock lock = jobStatusMap.get(jobName).lock;
    boolean isLockAcquired = false;
    try {
      isLockAcquired = lock.tryLock(3, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  
    if(isLockAcquired) {
      try {
        System.out.println(Thread.currentThread().getName() + ": get lock");
      } finally {
        lock.unlock();
      }
    } else {
      System.out.println(Thread.currentThread().getName() + ": didn't get lock");
    }
    //...
  }
}
