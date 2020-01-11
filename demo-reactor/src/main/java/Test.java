import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.publisher.Flux;

/*
 * Author: zzhao3@stuhhub.com
 * Date: 2020/1/7 10:00
 * Desc:
 */
public class Test {

  public static void main(String[] args) {
    Flux<Integer> range = Flux.range(5, 3);
    Disposable disposable = range.subscribe();
//    disposable.dispose(); // dispose() will cancel the subscription

    Disposable.Composite composite = Disposables.composite();
    composite.add(disposable);
    composite.dispose();


//    range.subscribe(System.out::println);
//    Flux<Integer> ints = Flux.range(1, 4)
//        .map(i -> {
//          if (i <= 2) return i;
//          throw new RuntimeException("Above 2");
//        });
//    ints.subscribe(System.out::println, error -> System.out.println("Error: " + error));
//
//    Flux<Integer> ints2 = Flux.range(1, 4);
//    ints2.subscribe(System.out::println,
//        error -> System.err.println("Error " + error),
//        () -> System.out.println("Done"));
//
//    Flux<Integer> ints3 = Flux.range(1, 4);
//    ints3.subscribe(System.out::println,
//        error -> System.err.println("Error " + error),
//        () -> System.out.println("Done"),
//        sub -> sub.request(1));

    SampleSubscriber<Integer> ss = new SampleSubscriber<>();
    Flux<Integer> ints = Flux.range(1, 4);
    ints.subscribe(System.out::println);

    ints.subscribe(i -> System.out.println(i),
        error -> System.out.println("Error: " + error),
        () -> System.out.println("Done"),
        s -> s.request(10));
    ints.subscribe(ss);

    Flux.range(1, 10)
        .doOnRequest(r -> System.out.println("request of " + r))
        .subscribe(
            new SampleSubscriber<Integer>() {
              @Override
              public void hookOnSubscribe(Subscription subscription) {
                request(1);
              }

              @Override
              public void hookOnNext(Integer value) {
                System.out.println("Cancelling after: " + value);
                if(value == 3)
                  cancel();
                request(1);
              }
            });
  }
}
