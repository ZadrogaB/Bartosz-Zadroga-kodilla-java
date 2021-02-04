package com.kodilla.good.patterns.challenges.exercise5;

import java.time.LocalDateTime;

public class Flight {
    private String flightFrom;
    private String flightTo;
    private String flightVia;
    private LocalDateTime departure;

    public void setFlightVia(String flightVia) {
        this.flightVia = flightVia;
    }

    public Flight(String flightFrom, String flightTo, LocalDateTime departure) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.departure = departure;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!flightFrom.equals(flight.flightFrom)) return false;
        if (!flightTo.equals(flight.flightTo)) return false;
        return departure.equals(flight.departure);
    }

    @Override
    public int hashCode() {
        int result = flightFrom.hashCode();
        result = 31 * result + flightTo.hashCode();
        result = 31 * result + departure.hashCode();
        return result;
    }

    @Override
    public String toString() {
        if (flightVia==null) {
            return "Flight: " +
                    "From = \'" + flightFrom + '\'' +
                    ", To = \'" + flightTo + '\'' +
                    ", departure = " + departure + "\n";
        } else {
            return "Flight: " +
                    "From = \'" + flightFrom + '\'' +
                    ", Via = \'" + flightVia + '\'' +
                    ", To = \'" + flightTo + '\'' +
                    ", departure = " + departure + "\n";
        }
    }
}
