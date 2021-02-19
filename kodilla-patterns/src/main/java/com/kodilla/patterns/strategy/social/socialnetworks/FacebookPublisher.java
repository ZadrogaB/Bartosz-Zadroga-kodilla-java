package com.kodilla.patterns.strategy.social.socialnetworks;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Facebook";
    }
}
