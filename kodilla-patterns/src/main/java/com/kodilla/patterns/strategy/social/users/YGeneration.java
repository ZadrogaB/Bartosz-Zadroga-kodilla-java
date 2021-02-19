package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.socialnetworks.TwitterPublisher;

public class YGeneration extends User{
    public YGeneration (String userName) {
        super(userName);
        this.socialPublisher = new TwitterPublisher();
    }
}
