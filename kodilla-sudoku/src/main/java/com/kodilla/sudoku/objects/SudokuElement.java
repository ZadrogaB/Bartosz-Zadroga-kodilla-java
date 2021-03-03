package com.kodilla.sudoku.objects;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;

    private int value;
    private List<Integer> possibleValues = new ArrayList<>();
    private int section;
    private int row;
    private int column;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getSection() {
        return section;
    }

    public SudokuElement(int section, int row, int column) {
        this.value = EMPTY;
        for (int i=1; i<10; i++) {
            this.possibleValues.add(i);
        }
        this.section = section;
        this.row = row;
        this.column = column;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public void addPossibleValue(int value) {
        this.possibleValues.add(value);
    }

    public void removePossibleValue(int value) {
        for (int i=0; i<possibleValues.size(); i++) {
            if (possibleValues.get(i).equals(value)) {
                possibleValues.remove(i);
            }
        }
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
            return  " " + value + "  ";
        } else {
            return "    ";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuElement that = (SudokuElement) o;

        if (value != that.value) return false;
        if (section != that.section) return false;
        return possibleValues != null ? possibleValues.equals(that.possibleValues) : that.possibleValues == null;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (possibleValues != null ? possibleValues.hashCode() : 0);
        result = 31 * result + section;
        return result;
    }
}
