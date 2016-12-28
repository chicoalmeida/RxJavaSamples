package io.chico.rxjava.creating;

import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.util.function.Consumer;

/**
 * @author Francisco Almeida
 */
public class Twitter4jExample {
    public static void main(String args[]) {
        consume(
                s -> {
                    if(s.getLang().equals("pt"))
                        System.out.println("Status:  " + s.getText());
                },
                error -> System.out.println("Error:: " + error.getMessage()));
    }

    public static TwitterStream createTwitterStream() {
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        // Twitter Consumer key & Consumer Secret
        twitterStream.setOAuthConsumer("aC4dIAMpdYf9m5ISaLHcdQdF5", "rRoddEfaKYtE69Ux65vWN9wAfZw45OjvPgSNeHCcMBUI6Lf5G9");
        // Twitter Access token & Access token Secret
        twitterStream.setOAuthAccessToken(new AccessToken("69070821-HUmnr06KfEnx3ovpQfwuV8xtRnIEdJXWV7noMaS9L",
                "lyecv93ZQCVXYSDvRdSX9TOmKvnSB0AYGQ9VqCUXLiDUS"));
        return twitterStream;
    }

    private static void consume(Consumer<Status> onStatus, Consumer<Exception> onException) {
        TwitterStream twitterStream = createTwitterStream();

        twitterStream.addListener(new StatusListener() {
            @Override
            public void onStatus(final Status status) {
                onStatus.accept(status);
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
                onException.accept(e);
            }
        });

        twitterStream.sample();
    }
}
