package com.kodilla.good.patterns.challenges.rental.example.interfaces;

import com.kodilla.good.patterns.challenges.rental.example.User;

import java.time.LocalDateTime;

public interface RentalRepository {
    void createRental(User user, LocalDateTime from, LocalDateTime to);
}
