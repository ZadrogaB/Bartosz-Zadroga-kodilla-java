package com.kodilla.patterns.strategy.social.socialnetworks;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Twitter";
    }
}
