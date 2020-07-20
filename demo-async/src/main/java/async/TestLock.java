package async;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Author: Bruce Zhao
 * Date: 2020/6/20 10:41
 * Desc:
 */
public class TestLock {
  static ReentrantLock lock = new ReentrantLock();
  static int counter = 0;

  public static void main(String[] args) throws InterruptedException {
    TestLock testLock = new TestLock();
    new Thread(testLock::perform).start();
    TimeUnit.SECONDS.sleep(1);
    System.out.println(lock.tryLock());
  }
  
  public void perform() {
    lock.lock();
    try {
      // Critical section here
      TimeUnit.SECONDS.sleep(2);
      System.out.println(Thread.currentThread().getName());
      counter++;
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
