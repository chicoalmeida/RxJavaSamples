package io.chico.rxjava.creating;

import rx.Observable;
import rx.subscriptions.Subscriptions;
import twitter4j.*;

import static io.chico.rxjava.creating.Twitter4jExample.createTwitterStream;

/**
 * @author Francisco Almeida
 */
public class Twitter4jReactive {

    public static void main(String[] args) {

        observe().subscribe(status -> System.out.println(status.getText()));

    }

    private static Observable<Status> observe() {
        return Observable.create(subscriber -> {

            TwitterStream twitterStream = createTwitterStream();

            twitterStream.addListener(new StatusListener() {
                @Override
                public void onStatus(final Status status) {
                    /*
                      This will guarantee that when the subscriber unsubscribe we will clean-up the resources
                      to avoid resource leak
                      */
                    if (subscriber.isUnsubscribed())
                        twitterStream.shutdown();
                    else
                        subscriber.onNext(status);
                }

                @Override
                public void onDeletionNotice(final StatusDeletionNotice statusDeletionNotice) {

                }

                @Override
                public void onTrackLimitationNotice(final int i) {

                }

                @Override
                public void onScrubGeo(final long l, final long l1) {

                }

                @Override
                public void onStallWarning(final StallWarning stallWarning) {

                }

                @Override
                public void onException(final Exception e) {
                    if (subscriber.isUnsubscribed())
                        twitterStream.shutdown();
                    else
                        subscriber.onError(e);
                }
            });

            twitterStream.sample();

            subscriber.add(Subscriptions.create(twitterStream::shutdown));
        });
    }
}
