package com.kodilla.good.patterns.challenges.exercise2.orders;


import com.kodilla.good.patterns.challenges.exercise2.objects.User;

public class OrderDto {
    public User user;
    public boolean isOrdered;

    public OrderDto(final User user, final boolean isRented) {
        this.user = user;
        this.isOrdered = isRented;
    }

    public User getUser() { return user; }

    public boolean isOrdered() { return isOrdered; }
}
