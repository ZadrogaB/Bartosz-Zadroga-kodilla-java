package com.kodilla.sudoku.objects;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;

    private int value;
    private List<Integer> possibleValues = new ArrayList<>();
    private int section;

    public int getSection() {
        return section;
    }

    public SudokuElement(int section) {
        this.value = EMPTY;
        for (int i=1; i<10; i++) {
            this.possibleValues.add(i);
        }
        this.section = section;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public String toString() {
        if (value != EMPTY) {
            return "  " + value + "  ";
        } else {
            return "    ";
        }
    }
}
