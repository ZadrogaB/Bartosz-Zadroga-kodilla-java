package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.socialnetworks.SnapchatPublisher;

public class ZGeneration extends User{
    public ZGeneration(String userName) {
        super(userName);
        this.socialPublisher = new SnapchatPublisher();
    }
}
