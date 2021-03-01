package com.kodilla.sudoku.objects;

import com.kodilla.sudoku.SudokuGame;

public class SudokuMain {
    public static void main(String[] args){
        SudokuGame game = new SudokuGame();
        try {
            game.StartGame();
        } catch (Exception e) {
            System.out.println("Wystapil blad: " + e);
        }
    }
}
