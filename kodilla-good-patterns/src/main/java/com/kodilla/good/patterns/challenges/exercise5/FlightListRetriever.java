package com.kodilla.good.patterns.challenges.exercise5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightListRetriever {
    public List<Flight> retriever () {
        List<Flight> flightList = new ArrayList<>();

        flightList.add(new Flight("Warszawa", "Gdansk",LocalDateTime.of(2021, 2, 1, 12, 0)));
        flightList.add(new Flight("Warszawa", "Krakow",LocalDateTime.of(2021, 2, 2, 12, 0)));
        flightList.add(new Flight("Warszawa", "Wroclaw",LocalDateTime.of(2021, 2, 3, 12, 0)));


        flightList.add(new Flight("Wroclaw", "Gdansk",LocalDateTime.of(2021, 2, 4, 12, 0)));
        flightList.add(new Flight("Wroclaw", "Krakow",LocalDateTime.of(2021, 2, 5, 12, 0)));
        flightList.add(new Flight("Wroclaw", "Warszawa",LocalDateTime.of(2021, 2, 6, 12, 0)));

        flightList.add(new Flight("Krakow", "Gdansk",LocalDateTime.of(2021, 2, 7, 12, 0)));
        flightList.add(new Flight("Krakow", "Warszawa",LocalDateTime.of(2021, 2, 8, 12, 0)));
        flightList.add(new Flight("Krakow", "Wroclaw",LocalDateTime.of(2021, 2, 9, 12, 0)));

        flightList.add(new Flight("Gdansk", "Krakow",LocalDateTime.of(2021, 2, 10, 12, 0)));
        flightList.add(new Flight("Gdansk", "Warszawa",LocalDateTime.of(2021, 2, 11, 12, 0)));
        flightList.add(new Flight("Gdansk", "Wroclaw",LocalDateTime.of(2021, 2, 12, 12, 0)));

        return flightList;
    }
}
