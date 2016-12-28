package io.chico;

import io.chico.rxjava.creating.Twitter4jSubject;
import rx.Observable;
import twitter4j.Status;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Twitter4jSubject twitter4jSubject = new Twitter4jSubject();

        Observable<Status> observe = twitter4jSubject.observe();

        observe.subscribe(s -> System.out.println(s.getText()));
    }
}

