package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;


    public Map<String, Double> initMap() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        return  temperaturesMap;
    }

    @BeforeEach
    public void beforeEveryTest() {
        Map<String, Double> temperaturesMap = initMap();
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }


    @Test
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperature(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double expected = 25.56;
        //When
        double result = weatherForecast.averageTemperature();

        //Then
        Assertions.assertEquals(expected, result, 0.01);
    }

    @Test
    void testCalculateMedianTemperature(){

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double expected = 25.5;

        //When
        double result = weatherForecast.medianTemperature();

        //Then
        Assertions.assertEquals(expected, result);

    }
}