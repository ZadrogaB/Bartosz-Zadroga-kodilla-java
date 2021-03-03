package com.kodilla.sudoku;

import com.kodilla.sudoku.objects.SudokuBoard;
import com.kodilla.sudoku.objects.SudokuElement;
import com.kodilla.sudoku.objects.SudokuRow;

public class ElementsGenerator {

    public SudokuBoard boardGenerator() {
        SudokuBoard board = new SudokuBoard();

        for (int i = 0; i < 9; i++) {
            SudokuRow sudokuRow = new SudokuRow();
            for (int k = 0; k < 9; k++) {
                int section = sectionCheck(i,k);
                SudokuElement sudokuElement = new SudokuElement(section, k, i);
                sudokuRow.addElement(sudokuElement);
            }
            board.addRow(sudokuRow);
        }

        return board;
    }

    private int sectionCheck(int i, int k) {
        int result;
        if(k<3 && i<3){
            result = 1;
        } else if (k>=3 && k<6 && i<3) {
            result = 2;
        } else if (k>=6 && k<9 && i<3) {
            result = 3;
        } else if (k<3 && i>=3 && i<6) {
            result = 4;
        } else if (k>=3 && k<6 && i>=3 && i<6) {
            result = 5;
        } else if (k>=6 && k<9 && i>=3 && i<6) {
            result = 6;
        } else if (k<3 && i>=6 && i<9) {
            result = 7;
        } else if (k>=3 && k<6 && i>=6 && i<9) {
            result = 8;
        } else if (k>=6 && k<9 && i>=6 && i<9) {
            result = 9;
        } else {
            result = 0;
        }
        return result;
    }
}
