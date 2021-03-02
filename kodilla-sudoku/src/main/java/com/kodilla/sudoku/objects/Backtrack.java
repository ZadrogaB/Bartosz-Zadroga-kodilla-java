package com.kodilla.sudoku.objects;

public class Backtrack {
    private SudokuBoard boardDeepCopy;
    private int value;
    private int row;
    private int column;

    public Backtrack(SudokuBoard boardDeepCopy, int value, int row, int column) {
        this.boardDeepCopy = boardDeepCopy;
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public SudokuBoard getBoardDeepCopy() {
        return boardDeepCopy;
    }

    public int getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
