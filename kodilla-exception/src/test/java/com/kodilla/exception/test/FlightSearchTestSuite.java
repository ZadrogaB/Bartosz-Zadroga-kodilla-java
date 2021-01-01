package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlightSearchTestSuite {

    @Test
    void flightExistBothAirportsAvailable(){
        //given
        FlightSearch flightSearch = new FlightSearch();
        //then&when
        assertDoesNotThrow(()->flightSearch.findFilght(new Flight("EPWA", "LKPR")));

    }

    @Test
    void flightExistDepartureAirportAvailable(){
        //given
        FlightSearch flightSearch = new FlightSearch();
        //then&when
        assertDoesNotThrow(()->flightSearch.findFilght(new Flight("EPWA", "EPMO")));
    }

    @Test
    void flightExistArrivalAirportAvailable(){
        //given
        FlightSearch flightSearch = new FlightSearch();
        //then&when
        assertDoesNotThrow(()->flightSearch.findFilght(new Flight("LOWW", "LIRF")));

    }

    @Test
    void flightExistBothAirportsUnavailable(){
        //given
        FlightSearch flightSearch = new FlightSearch();
        //then&when
        assertDoesNotThrow(()->flightSearch.findFilght(new Flight("LOWW", "EPMO")));

    }

    @Test
    void flightDoesntExist(){
        //given
        FlightSearch flightSearch = new FlightSearch();
        //then&when
        assertThrows(RouteNotFoundException.class, ()->flightSearch.findFilght(new Flight("EDDB", "LFPG")));
    }

}
