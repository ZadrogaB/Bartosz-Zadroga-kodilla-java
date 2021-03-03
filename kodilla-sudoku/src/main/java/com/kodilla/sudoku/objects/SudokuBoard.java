package com.kodilla.sudoku.objects;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuBoard implements Cloneable{
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

    public SudokuBoard boardDeepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.listOfRows = new ArrayList<>();
        for (SudokuRow row : listOfRows) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement element : row.getElementsInRow()) {
                SudokuElement sudokuElement = new SudokuElement(element.getSection(), element.getRow(), element.getColumn());
                sudokuElement.setValue(element.getValue());

                sudokuElement.setPossibleValues(element.getPossibleValues());

                clonedRow.getElementsInRow().add(sudokuElement);
            }
            clonedBoard.getListOfRows().add(clonedRow);

        }
        return clonedBoard;
    }

    public void cleanBoard() {
        listOfRows.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuBoard board = (SudokuBoard) o;

        return listOfRows.equals(board.listOfRows);
    }

    @Override
    public int hashCode() {
        return listOfRows.hashCode();
    }
}
