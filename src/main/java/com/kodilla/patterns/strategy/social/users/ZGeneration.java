package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.media.TwitterPublisher;

public class ZGeneration extends User {
    public ZGeneration(String username) {
        super(username);
        this.socialPublisher = new TwitterPublisher();
    }
}
