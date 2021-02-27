package com.kodilla.sudoku.objects;


import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> listOfRows = new ArrayList<>();

    public List<SudokuRow> getListOfRows() {
        return listOfRows;
    }

    public void addRow (SudokuRow row) {
        this.listOfRows.add(row);
    }

    public void drawBoard () {
        for (int i = 1; i < 10; i++) {
            listOfRows.get(i-1).drawSudokuRows();
            if (i%3==0 && i != 9) {
                System.out.println(" -  -  -  -   -  -  -  -   -  -  -  -");
            }
        }
    }
}
