package com.kodilla.sudoku.objects;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> elementsInRow = new ArrayList<>();

    public void addElement (SudokuElement element) {
        this.elementsInRow.add(element);
    }

    public List<SudokuElement> getElementsInRow() {
        return elementsInRow;
    }

    public void drawSudokuRows() {

        for (int i = 1; i < 10; i++) {
            if (i % 3 != 0 && i != 10) {
                System.out.print(elementsInRow.get(i - 1));
            } else  if (i == 9) {
                System.out.println(elementsInRow.get(i - 1));
            } else {
                System.out.print(elementsInRow.get(i - 1) + "|");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuRow row = (SudokuRow) o;

        return elementsInRow != null ? elementsInRow.equals(row.elementsInRow) : row.elementsInRow == null;
    }

    @Override
    public int hashCode() {
        return elementsInRow != null ? elementsInRow.hashCode() : 0;
    }
}
