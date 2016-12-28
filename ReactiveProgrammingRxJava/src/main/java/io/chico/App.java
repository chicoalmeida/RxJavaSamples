package io.chico;

import rx.Observable;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {


        Observable<Object> observable = Observable.create(subscriber -> {
            subscriber.onNext(1);
            subscriber.onNext(10);
            subscriber.onNext(100);
            subscriber.onError(new RuntimeException("ERROR"));
            subscriber.onCompleted();
        });

        observable.subscribe(System.out::println, error-> System.out.println(error.getMessage()));


    }
}

