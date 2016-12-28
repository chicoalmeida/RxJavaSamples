package io.chico.rxjava.creating;

import rx.Observable;
import rx.subjects.PublishSubject;
import twitter4j.*;

/**
 * @author Francisco Almeida
 */
public class Twitter4jSubject {

    private final PublishSubject<Status> subject = PublishSubject.create();

    public Observable<Status> observe() {
        return subject;
    }

    public Twitter4jSubject() {
        TwitterStream twitterStream = Twitter4jExample.createTwitterStream();
        twitterStream.addListener(new StatusListener() {
            @Override
            public void onStatus(final Status status) {
                subject.onNext(status);
            }

            @Override
            public void onException(final Exception ex) {
                subject.onError(ex);
            }

            @Override
            public void onDeletionNotice(final StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(final int numberOfLimitedStatuses) {

            }

            @Override
            public void onScrubGeo(final long userId, final long upToStatusId) {

            }

            @Override
            public void onStallWarning(final StallWarning warning) {

            }
        });
    }


}
