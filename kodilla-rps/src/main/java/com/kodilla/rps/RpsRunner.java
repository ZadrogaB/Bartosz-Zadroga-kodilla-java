package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        String PlayerObject;
        String GeneratorObject;
        String playerName;
        String winner;
        int playerWin = 0;
        int computerWin = 0;
        int numberOfRoundsToWin;
        RockPaperScisorsGenerator rockPaperScisorsGenerator = new RockPaperScisorsGenerator();
        WinCheck winCheck = new WinCheck();
        WriteRules writeRules = new WriteRules();
        Scanner scan = new Scanner(System.in);
        String[] rockPaperScisors = {"Rock", "Paper","Scisors"};

        System.out.println("Set player name: ");
        playerName = scan.nextLine();
        System.out.println("Set number of rounds to win: ");
        numberOfRoundsToWin = scan.nextInt();
        scan.nextLine();


        writeRules.writeRules();

        while (playerWin<numberOfRoundsToWin && computerWin<numberOfRoundsToWin){
            System.out.println("Choose: 1, 2 or 3.");
            PlayerObject = scan.nextLine();
            GeneratorObject = rockPaperScisorsGenerator.getRandomObject();

            //PLAYER CHOOSE WRONG LETTER/NUMBER
            if ( !PlayerObject.equals("1") && !PlayerObject.equals("2") && !PlayerObject.equals("3") && !PlayerObject.equals("n") && !PlayerObject.equals("x")) {
                do {
                    System.out.println("WRONG! Choose: 1, 2 or 3.");
                    PlayerObject = scan.nextLine();
                } while (!PlayerObject.equals("1") && !PlayerObject.equals("2") && !PlayerObject.equals("3") && !PlayerObject.equals("n") && !PlayerObject.equals("x"));
            }

            //CORRECT GAME
            if ( PlayerObject.equals("1") || PlayerObject.equals("2") || PlayerObject.equals("3")) {
                winner = winCheck.winChecker(PlayerObject, GeneratorObject,playerName);

            if (winner.equals("Computer Win")){
                computerWin++;

            } else if (winner.equals(playerName + " Win")){
                playerWin++;

            }


            System.out.println(playerName + " choose: " + rockPaperScisors[Integer.valueOf(PlayerObject)-1] + ". Computer choose: " + GeneratorObject + "\n" + winner +
                    "\nComputer: " + computerWin +" "+ playerName +": " + playerWin);

                if (computerWin==numberOfRoundsToWin){
                    System.out.println("\nComputer win the game!");
                    System.out.println("Do you want to play new game(n) or exit(x)?");
                    PlayerObject = scan.nextLine();

                }

                if (playerWin==numberOfRoundsToWin){
                    System.out.println("\n" + playerName + " win the game!");
                    System.out.println("Do you want to play new game(n) or exit(x)?");
                    PlayerObject = scan.nextLine();
                }
            }


            //NEW GAME
            if (PlayerObject.equals("n")) {
                System.out.println("Are you sure you want start a new game(n)");
                playerName = scan.nextLine();
                if (playerName.equals("n")) {
                    computerWin = 0;
                    playerWin = 0;
                    System.out.println("Set player name: ");
                    playerName = scan.nextLine();
                    System.out.println("Set number of rounds to win: ");
                    numberOfRoundsToWin = scan.nextInt();
                    scan.nextLine();
                }
            }


            //EXIT GAME
            if (PlayerObject.equals("x")) {
                System.out.println("Are you sure you want to exit(x)");
                playerName = scan.nextLine();
                if (playerName.equals("x")) {
                    break;
                }
            }

        }


    }
}
