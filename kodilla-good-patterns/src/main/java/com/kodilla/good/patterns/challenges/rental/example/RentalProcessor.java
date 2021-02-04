package com.kodilla.good.patterns.challenges.rental.example;

import com.kodilla.good.patterns.challenges.rental.example.interfaces.InformationService;
import com.kodilla.good.patterns.challenges.rental.example.interfaces.RentalRepository;
import com.kodilla.good.patterns.challenges.rental.example.interfaces.RentalService;

public class RentalProcessor {

    private InformationService informationService;
    private RentalService rentalService;
    private RentalRepository rentalRepository;


    public RentalProcessor(final InformationService informationService,
                            final RentalService rentalService,
                            final RentalRepository rentalRepository) {
        this.informationService = informationService;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    public RentalDto process(final RentRequest rentRequest) {
        boolean isRented = rentalService.rent(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());
        if (isRented) {
            informationService.inform(rentRequest.getUser());
            rentalRepository.createRental(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());
            return new RentalDto(rentRequest.getUser(), true);
        } else {
            return new RentalDto(rentRequest.getUser(), false);
        }
    }

}