import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.SignalType;

/*
 * Author: Bruce Zhao
 * Date: 2020/1/8 15:00
 * Desc:
 */
public class SampleSubscriber<T> extends BaseSubscriber<T> {

  @Override
  public void hookOnSubscribe(Subscription subscription) {
    System.out.println("Subscribed");
    request(1);
  }

  @Override
  public void hookOnNext(T value) {
    System.out.println("value:" + value);
    request(1);
  }

  @Override
  protected void hookOnComplete() {
    System.out.println("hook done");
  }

  @Override
  protected void hookOnError(Throwable throwable) {
    System.out.println("hook error");
  }

  @Override
  protected void hookFinally(SignalType type) {
    System.out.println("hook finally");
  }
}
