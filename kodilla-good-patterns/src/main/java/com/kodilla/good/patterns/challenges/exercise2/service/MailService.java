package com.kodilla.good.patterns.challenges.exercise2.service;

import com.kodilla.good.patterns.challenges.exercise2.model.User;


public class MailService implements InformationService {
    public void inform(User user){
        System.out.println("Send confirmation of buy to " + user.getName() + " " + user.getSurname());
    }
}
