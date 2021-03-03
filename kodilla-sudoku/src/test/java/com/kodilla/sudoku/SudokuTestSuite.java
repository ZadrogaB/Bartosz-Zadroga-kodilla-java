package com.kodilla.sudoku;

import com.kodilla.sudoku.objects.SudokuBoard;
import com.kodilla.sudoku.objects.UnresolvedSudokuException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuTestSuite {

    @Test
    void elementsGeneratorTestSuite() {
        //Given
        ElementsGenerator elementsGenerator = new ElementsGenerator();

        //When
        SudokuBoard board = elementsGenerator.boardGenerator();
        int resultRows = board.getListOfRows().size();

        long resultElements = board.getListOfRows().stream()
                .flatMap(n->n.getElementsInRow().stream())
                .count();
        //Then
        assertEquals(9, resultRows); //number of rows in board
        assertEquals(81, resultElements); //number of elements in board
    }

    @Test
    void boardDrawerTestSuite() {
        //Given
        ElementsGenerator elementsGenerator = new ElementsGenerator();

        //When && Then
        SudokuBoard board = elementsGenerator.boardGenerator();
        board.drawBoard();

    }

    @Test
    void possibleValuesSudokuElementsTestSuite() {
        //Given
        ElementsGenerator elementsGenerator = new ElementsGenerator();

        //When
        SudokuBoard board = elementsGenerator.boardGenerator();
//        List<Integer> possibleValues = board.getListOfRows().get(0).getElementsInRow().get(0).getPossibleValues();
//        System.out.println(possibleValues);

        //Then
//        assertEquals(9, possibleValues.size());
    }

    @Test
    void removingValuesFromPossibleValuesTestSuite() {
        //Given
        ElementsGenerator elementsGenerator = new ElementsGenerator();
        SudokuController sudokuController = new SudokuController();

        //When
        SudokuBoard board = elementsGenerator.boardGenerator();
        sudokuController.removingValuesFromPossibleValuesRows(board);
//        List<Integer> possibleValues = board.getListOfRows().get(0).getElementsInRow().get(0).getPossibleValues();
//        System.out.println(possibleValues);

        //Then
//        assertEquals(7, possibleValues.size()); //Działa gdy są wartości podane
    }

    @Test
    void lastPossibleInRowTestSuite() {
        //Given
        ElementsGenerator elementsGenerator = new ElementsGenerator();
        SudokuController sudokuController = new SudokuController();

        //When
        SudokuBoard board = elementsGenerator.boardGenerator();
//        try {
//            sudokuController.lastPossibleInRow(board);
//        } catch (UnresolvedSudokuException e) {
//            System.out.println("Nie da sie rozwiazac tego Sudoku!");
//        }
//        board.drawBoard();
    }
}
