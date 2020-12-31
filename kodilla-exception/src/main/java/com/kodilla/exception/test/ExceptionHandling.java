package com.kodilla.exception.test;

public class ExceptionHandling {

    public void RunSecondChallenge(){
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String result = secondChallenge.probablyIWillThrowException(0,2);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Something go wrong! \nException: " + e);
        } finally {
            System.out.println("End of SecondChallenge!");
        }
    }

}
