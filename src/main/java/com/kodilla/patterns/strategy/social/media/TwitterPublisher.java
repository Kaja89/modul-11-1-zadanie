package com.kodilla.patterns.strategy.social.media;

public class TwitterPublisher implements SocialPublisher {
    public String share() {
        return "Twitter";
    }
}
