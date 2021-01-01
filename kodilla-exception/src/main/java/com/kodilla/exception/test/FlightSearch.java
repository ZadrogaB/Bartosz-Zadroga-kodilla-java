package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightSearch {

    public static void main(String[] args){
        FlightSearch flightSearch = new FlightSearch();
        Flight flightToSearch = new Flight("EPMO", "EPWA");

        try {
            flightSearch.findFilght(flightToSearch);
        } catch (RouteNotFoundException e) {
            System.out.println("Nie ma takiego lotniska na liście! Błąd: " + e);
        }
    }


    public void findFilght (Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> availableAirports = airportsGenerator();
        List <Flight> flightList = flightListGenerator();

        if (flightList.contains(flight)) {

            if (availableAirports.containsKey(flight.getArrivalAirport())
                    && availableAirports.containsKey(flight.getDepartureAirport())) {

                System.out.println("Lot znaleziono!!!");

                if (availableAirports.get(flight.getDepartureAirport()).booleanValue() == true
                        && availableAirports.get(flight.getArrivalAirport()).booleanValue() == true) {

                    System.out.println("Lotnisko startu i docelowe otwarte. Lot jest możliwy.");

                } else if (availableAirports.get(flight.getDepartureAirport()).booleanValue() == false
                        && availableAirports.get(flight.getArrivalAirport()).booleanValue() == true) {
                    System.out.println("Lotnisko startu zamknięte. Lot nie jest możliwy.");

                } else if (availableAirports.get(flight.getDepartureAirport()).booleanValue() == true
                        && availableAirports.get(flight.getArrivalAirport()).booleanValue() == false) {
                    System.out.println("Lotnisko docelowe zamknięte. Lot nie jest możliwy.");
                } else {
                    System.out.println("Lotnisko startu i docelowe zamknięte. Lot nie jest możliwy.");
                }


            } else {
                throw new RouteNotFoundException();
            }
        } else {
            System.out.println("Taki lot nie istnieje");
        }
    }


    public Map<String, Boolean> airportsGenerator(){
        Map<String, Boolean> availableAirports = new HashMap<>();

        availableAirports.put("EPWA", true);
        availableAirports.put("EPMO", false);
        availableAirports.put("LKPR", true);
        availableAirports.put("EDDB", true);
        availableAirports.put("EDDF", true);
        availableAirports.put("LEMD", true);
        availableAirports.put("LPPT", true);
        availableAirports.put("LEBL", true);
        availableAirports.put("LIRF", true);
        availableAirports.put("LOWW", false);
        //availableAirports.put("LFPG", true);

        return availableAirports;
    }

    public List<Flight> flightListGenerator (){
        List <Flight> flightList = new ArrayList<>();

        //flights can take place
        flightList.add(new Flight("EPWA", "LKPR"));
        flightList.add(new Flight("EDDB", "LPPT"));
        flightList.add(new Flight("EDDF", "LIRF"));
        flightList.add(new Flight("LIRF", "LKPR"));
        flightList.add(new Flight("LPPT", "EPWA"));
        flightList.add(new Flight("LEMD", "LEBL"));
        flightList.add(new Flight("LEBL", "LEMD"));

        //flights can't take place (airports unavailable)
        flightList.add(new Flight("EPWA", "EPMO")); //departure available
        flightList.add(new Flight("LOWW", "LIRF")); //arrival available
        flightList.add(new Flight("LOWW", "EPMO")); //both airports unavailable

        //flights can't take place (airport doesn't figure on availableAirports list)
        flightList.add(new Flight("EDDB", "LFPG"));

        return flightList;
    }
}
