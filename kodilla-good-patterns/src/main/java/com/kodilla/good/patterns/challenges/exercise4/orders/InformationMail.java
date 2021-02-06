package com.kodilla.good.patterns.challenges.exercise4.orders;

import com.kodilla.good.patterns.challenges.exercise4.objects.Client;

public class InformationMail implements InformationService {
    public void inform(final Client client){
        System.out.println("Wysłano potwierdzenie zamówienia dla " + client.getName() + " " + client.getSurname() +
                " na adres: " + client.getMail());
    }

}
