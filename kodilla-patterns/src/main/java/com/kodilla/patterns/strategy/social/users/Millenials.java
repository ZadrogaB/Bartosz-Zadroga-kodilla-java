package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.socialnetworks.FacebookPublisher;

public class Millenials extends User{
    public Millenials(String userName) {
        super(userName);
        this.socialPublisher = new FacebookPublisher();
    }
}
