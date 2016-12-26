package io.chico;

import twitter4j.*;
import twitter4j.auth.AccessToken;

/**
 * @author Francisco Almeida
 */
public class Twitter4jExample {
    public static void main(String args[]) {
        Twitter twitter = new TwitterFactory().getInstance();
        // Twitter Consumer key & Consumer Secret
        twitter.setOAuthConsumer("w7LqZuxtMro4HRc5AYTqahtZ3", "hVQ5vDLqq22EDvAL5ZsF1S06L9h5cxk9tbJJ3sppgXX5h4kfZL");
        // Twitter Access token & Access token Secret
        twitter.setOAuthAccessToken(new AccessToken("69070821-HUmnr06KfEnx3ovpQfwuV8xtRnIEdJXWV7noMaS9L",
                "lyecv93ZQCVXYSDvRdSX9TOmKvnSB0AYGQ9VqCUXLiDUS"));
        // Getting Twitter Timeline using Twitter4j API
        ResponseList<Status> userTimeline = null;
        try {
            userTimeline = twitter.getHomeTimeline(new Paging(1, 1));
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        userTimeline.forEach(System.out::println);
        // Post a Tweet using Twitter4j API
        Status status = null;
        try {
            status = twitter.updateStatus("Hello");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }
}
