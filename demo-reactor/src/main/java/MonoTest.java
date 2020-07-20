import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;

/*
 * Author: Bruce Zhao
 * Date: 2020/1/8 17:05
 * Desc:
 */
public class MonoTest {
  public static void main(String[] args) {

//    Flux.generate(
//        () -> 1,
//        (state, sink) -> {
//          sink.next("3 x " + state + " = " + 3*state);
//          if (state == 10) sink.complete();
//          return state + 1;
//        })
//        .subscribe(System.out::println);

//    Flux.generate(
//        AtomicLong::new,
//        (state, sink) -> {
//          long i = state.getAndIncrement();
//          sink.next("3 x " + i + " = " + 3*i);
//          if (i == 10) sink.complete();
//          return state;
//        },
//        (state) -> System.out.println("state: " + state)
//    ).subscribe(System.out::println);

  }
}
