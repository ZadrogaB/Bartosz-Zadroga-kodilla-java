package com.kodilla.rps;

import java.util.Random;
public class RockPaperScisorsGenerator {
    Random random = new Random();
    String[] RockPaperScisors = {"Rock", "Paper","Scisors"};

    public String getRandomObject(){
        int randomA = random.nextInt(3);
        return RockPaperScisors[randomA];
    }
}
