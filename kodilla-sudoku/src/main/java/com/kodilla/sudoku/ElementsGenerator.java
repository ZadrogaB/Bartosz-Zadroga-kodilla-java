package com.kodilla.sudoku;

import com.kodilla.sudoku.objects.SudokuBoard;
import com.kodilla.sudoku.objects.SudokuElement;
import com.kodilla.sudoku.objects.SudokuRow;

public class ElementsGenerator {

    public SudokuBoard boardGenerator () {
        SudokuBoard board = new SudokuBoard();

        for (int i = 0; i < 9; i++) {
            SudokuRow sudokuRow = new SudokuRow();
            for (int k = 0; k < 9; k++) {
                SudokuElement sudokuElement = new SudokuElement();
                sudokuRow.addElement(sudokuElement);
            }
            board.addRow(sudokuRow);
        }

        return board;
    }
}
