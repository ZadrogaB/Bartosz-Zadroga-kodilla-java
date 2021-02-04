package com.kodilla.good.patterns.challenges.rental.example.interfaces;

import com.kodilla.good.patterns.challenges.rental.example.User;

import java.time.LocalDateTime;

public interface RentalService {
    boolean rent(final User user, final LocalDateTime carRentFrom, final LocalDateTime carRentTo);
}
