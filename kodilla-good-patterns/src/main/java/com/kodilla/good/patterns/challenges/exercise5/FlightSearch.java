package com.kodilla.good.patterns.challenges.exercise5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightSearch {

    public List<Flight> searchFlightFrom(List<Flight> flightList, String flightFrom) {
        List<Flight> result = flightList.stream()
                .filter(n->n.getFlightFrom().equals(flightFrom))
                .collect(Collectors.toList());

        return result;
    }

    public List<Flight> searchFlightTo(List<Flight> flightList, String flightTo) {
        List<Flight> result = flightList.stream()
                .filter(n->n.getFlightTo().equals(flightTo))
                .collect(Collectors.toList());

        return result;
    }

    public List<Flight> searchFlightVia(List<Flight> flightList, String flightFrom, String flightVia, String flightTo) {

        List<Flight> resultFrom = flightList.stream()
                .filter(n->n.getFlightFrom().equals(flightFrom))
                .filter(n->n.getFlightTo().equals(flightVia))
                .collect(Collectors.toList());

        List<Flight> resultTo = flightList.stream()
                .filter(n->n.getFlightFrom().equals(flightVia))
                .filter(n->n.getFlightTo().equals(flightTo))
                .collect(Collectors.toList());

        List<Flight> result = new ArrayList<>();

        for (Flight departures : resultFrom) {
            for(Flight arrivals : resultTo) {
                if (departures.getDeparture().isBefore(arrivals.getDeparture())){
                    Flight flight = new Flight(departures.getFlightFrom(),arrivals.getFlightTo(), departures.getDeparture());
                    flight.setFlightVia(departures.getFlightTo());
                    result.add(flight);
                }
            }
        }

        return result;
    }
}
