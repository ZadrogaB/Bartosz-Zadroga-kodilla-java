package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> movieMap = movieStore.getMovies();

        String movieString = movieStore.getMovies().entrySet().stream()
                .map(n->n.getValue())
                .flatMap(n -> n.stream())
                .collect(Collectors.joining(" ! "));

        System.out.println(movieString);
    }
}
