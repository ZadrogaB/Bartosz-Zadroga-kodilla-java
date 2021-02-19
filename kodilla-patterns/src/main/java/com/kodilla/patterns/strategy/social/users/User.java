package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.socialnetworks.SocialPublisher;

public class User {
    private String userName;
    protected SocialPublisher socialPublisher;

    public User(String userName) {
        this.userName = userName;
        }

    public String getUserName() {
        return userName;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String sharePost(){
        return socialPublisher.share();
    }
}
