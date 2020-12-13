package com.kodilla.testing.weather.stub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double averageTemperature(){
        double allTemperatures = 0;
        int numberOfLoops =0;

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            allTemperatures+=temperature.getValue();
            System.out.println(allTemperatures + "wartość sumy temperatur");
            numberOfLoops++;
        }
        return allTemperatures/numberOfLoops;
    }

    public double medianTemperature(){
        double[] sortArray = new double[temperatures.getTemperatures().size()];
        double median;
        //wstawianie danych do tablicy
        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            for (int i=0; i<temperatures.getTemperatures().size(); i++){
                sortArray[i]=temperature.getValue();
            }
        }
        //sortowanie danych
        Arrays.sort(sortArray);
        System.out.println(sortArray);

        //wyznaczanie mediany
        int arrayLenght = sortArray.length;
        if(arrayLenght%2==1){
            median = sortArray[((arrayLenght-1)/2)+1];
        } else {
            median = (sortArray[(arrayLenght/2)] + sortArray[(arrayLenght/2)+1])/2;
        }
        return  median;
    }

}