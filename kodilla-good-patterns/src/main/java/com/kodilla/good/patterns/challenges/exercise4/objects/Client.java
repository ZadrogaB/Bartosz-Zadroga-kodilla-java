package com.kodilla.good.patterns.challenges.exercise4.objects;

public class Client {
    private String name;
    private String surname;
    private String mail;

    public Client(String name, String surname, String mail) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }
}