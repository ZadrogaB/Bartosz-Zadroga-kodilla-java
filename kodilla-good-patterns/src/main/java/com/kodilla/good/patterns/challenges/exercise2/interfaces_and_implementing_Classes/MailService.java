package com.kodilla.good.patterns.challenges.exercise2.interfaces_and_implementing_Classes;

import com.kodilla.good.patterns.challenges.exercise2.objects.User;


public class MailService implements InformationService {
    public void inform(User user){
        System.out.println("Send confirmation of buy to " + user.getName() + " " + user.getSurname());
    }
}
