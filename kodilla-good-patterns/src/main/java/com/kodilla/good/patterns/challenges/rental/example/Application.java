package com.kodilla.good.patterns.challenges.rental.example;

import com.kodilla.good.patterns.challenges.rental.example.carRent.CarRentalRepository;
import com.kodilla.good.patterns.challenges.rental.example.carRent.CarRentalService;

public class Application {

    public static void main(String[] args) {
        RentRequestRetriever rentRequestRetriever = new RentRequestRetriever();
        RentRequest rentRequest = rentRequestRetriever.retrieve();

        RentalProcessor rentalProcessor = new RentalProcessor(new MailService(), new CarRentalService(), new CarRentalRepository());
        rentalProcessor.process(rentRequest);
    }

}