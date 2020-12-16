package com.kodilla.rps;

public class WinCheck {
    String[] rockPaperScisors = {"Rock", "Paper","Scisors"};

    public String winChecker(String playerObject, String generatorObject, String playerName){

        if(playerObject.equals("1")  && generatorObject.equals(rockPaperScisors[1]) ||
                playerObject.equals("2") && generatorObject.equals(rockPaperScisors[0]) ){
            if(generatorObject == "Paper"){
                return "Computer Win";
            } else {
                return playerName + " Win";
            }
        }

        if (playerObject.equals("1")  && generatorObject.equals(rockPaperScisors[2]) ||
                playerObject.equals("3") && generatorObject.equals(rockPaperScisors[0])  ){
            if(generatorObject == "Rock"){
                return "Computer Win";
            } else {
                return playerName + " Win";
            }
        }
        if (playerObject.equals("2")  && generatorObject.equals(rockPaperScisors[2]) ||
                playerObject.equals("3") && generatorObject.equals(rockPaperScisors[1]) ){
            if(generatorObject == "Scisors"){
                return "Computer Win";
            } else {
                return playerName + " Win";
            }
        } else {
            return "Draw";
        }
    }
}
