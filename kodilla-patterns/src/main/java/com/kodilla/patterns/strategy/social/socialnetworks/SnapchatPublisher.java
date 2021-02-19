package com.kodilla.patterns.strategy.social.socialnetworks;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return  "Snapchat";
    }
}
