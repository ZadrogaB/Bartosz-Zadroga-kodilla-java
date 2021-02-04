package com.kodilla.good.patterns.challenges.exercise5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightListRetriever flightListRetriever = new FlightListRetriever();
        FlightSearch flightSearch = new FlightSearch();

        List<Flight> searchFlightFrom = flightSearch.searchFlightFrom(flightListRetriever.retriever(), "Warszawa");
        List<Flight> searchFlightTo = flightSearch.searchFlightTo(flightListRetriever.retriever(), "Warszawa");
        System.out.println("Flights from Warszawa: \n" + searchFlightFrom + "\nFlights to Warszawa: \n" + searchFlightTo);

        List<Flight> searchFlightVia = flightSearch.searchFlightVia(flightListRetriever.retriever(), "Warszawa", "Wroclaw", "Krakow");
        System.out.println("Flights Via Wroclaw" + searchFlightVia);
    }
}
