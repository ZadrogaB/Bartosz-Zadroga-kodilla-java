package com.kodilla.sudoku;

import com.kodilla.sudoku.objects.SudokuBoard;
import com.kodilla.sudoku.objects.UnresolvedSudokuException;

import java.util.Scanner;

public class SudokuGame {


    public void StartGame() throws UnresolvedSudokuException, CloneNotSupportedException {
        String start = null;
        boolean isSolved = false;
        Scanner scanner = new Scanner(System.in);
        ElementsGenerator elementsGenerator = new ElementsGenerator();
        SudokuController controller = new SudokuController();
        SudokuBoard board = elementsGenerator.boardGenerator();
        SudokuBoard boardDeepCopy = elementsGenerator.boardGenerator();

        board.drawBoard();
        /*do {
            System.out.println("W ktorym rzedzie chcesz dodac wartosc?");
            int row = scanner.nextInt() - 1;
            System.out.println("W ktorej kolumnie chcesz dodac wartosc?");
            int column = scanner.nextInt() - 1;
            System.out.println("Podaj wartosc do wprowadzenia (1-9)");
            int value = scanner.nextInt();
            board.getListOfRows().get(row).getElementsInRow().get(column).setValue(value);
            board.drawBoard();

            System.out.println("Aby zakonczyc dodawanie wartosci wpisz SUDOKU");
            scanner.nextLine();
            start = scanner.nextLine();
        } while (!start.equals("SUDOKU"));*/                // <-------- Wyłączone na czas testów SudokuController

        exampleSudoku(board);
        board.drawBoard();

        do {
            //Rows
            controller.removingValuesFromPossibleValuesRows(board);
            controller.lastPossibleNumberInElement(board);
            controller.lastPossibleInRow(board);
            controller.removingPossibleValuesFromValues(board);
            //Columns
            controller.removingValuesFromPossibleValuesColumns(board);
            controller.lastPossibleNumberInElement(board);
            board.drawBoard();
            controller.lastPossibleInColumn(board);
            controller.removingPossibleValuesFromValues(board);
            //Sections
            controller.removingValuesFromPossibleValuesSection(board);
            controller.lastPossibleNumberInElement(board);
            controller.lastPossibleInSection(board);
            controller.removingPossibleValuesFromValues(board);

            System.out.println();
            board.drawBoard();
            isSolved = controller.isSudokuSolved(board);
            /*if (board.equals(boardDeepCopy)){
                System.out.println("Nie mozna rozwiazac sudoku");
            } else {
                boardDeepCopy = board.boardDeepCopy();
            }*/                                                             //<------- Wyskakuje błąd klonowania

        } while (!isSolved);
    }

    public void exampleSudoku(SudokuBoard board) {
        board.getListOfRows().get(0).getElementsInRow().get(0).setValue(9);
        board.getListOfRows().get(0).getElementsInRow().get(1).setValue(3);
        board.getListOfRows().get(0).getElementsInRow().get(3).setValue(1);
        board.getListOfRows().get(0).getElementsInRow().get(4).setValue(2);
        board.getListOfRows().get(0).getElementsInRow().get(5).setValue(6);
        board.getListOfRows().get(0).getElementsInRow().get(7).setValue(8);
        board.getListOfRows().get(0).getElementsInRow().get(8).setValue(7);

        board.getListOfRows().get(1).getElementsInRow().get(0).setValue(2);
        board.getListOfRows().get(1).getElementsInRow().get(1).setValue(1);
        board.getListOfRows().get(1).getElementsInRow().get(3).setValue(3);
        board.getListOfRows().get(1).getElementsInRow().get(5).setValue(7);
        board.getListOfRows().get(1).getElementsInRow().get(7).setValue(4);
        board.getListOfRows().get(1).getElementsInRow().get(8).setValue(6);

        board.getListOfRows().get(2).getElementsInRow().get(3).setValue(4);
        board.getListOfRows().get(2).getElementsInRow().get(5).setValue(9);

        board.getListOfRows().get(3).getElementsInRow().get(0).setValue(7);
        board.getListOfRows().get(3).getElementsInRow().get(1).setValue(2);
        board.getListOfRows().get(3).getElementsInRow().get(2).setValue(6);
        board.getListOfRows().get(3).getElementsInRow().get(6).setValue(8);
        board.getListOfRows().get(3).getElementsInRow().get(7).setValue(3);
        board.getListOfRows().get(3).getElementsInRow().get(8).setValue(4);

        board.getListOfRows().get(4).getElementsInRow().get(0).setValue(5);
        board.getListOfRows().get(4).getElementsInRow().get(8).setValue(9);

        board.getListOfRows().get(5).getElementsInRow().get(0).setValue(3);
        board.getListOfRows().get(5).getElementsInRow().get(1).setValue(4);
        board.getListOfRows().get(5).getElementsInRow().get(2).setValue(9);
        board.getListOfRows().get(5).getElementsInRow().get(6).setValue(1);
        board.getListOfRows().get(5).getElementsInRow().get(7).setValue(6);
        board.getListOfRows().get(5).getElementsInRow().get(8).setValue(5);

        board.getListOfRows().get(6).getElementsInRow().get(3).setValue(7);
        board.getListOfRows().get(6).getElementsInRow().get(5).setValue(1);

        board.getListOfRows().get(7).getElementsInRow().get(0).setValue(1);
        board.getListOfRows().get(7).getElementsInRow().get(1).setValue(7);
        board.getListOfRows().get(7).getElementsInRow().get(3).setValue(5);
        board.getListOfRows().get(7).getElementsInRow().get(5).setValue(3);
        board.getListOfRows().get(7).getElementsInRow().get(7).setValue(9);
        board.getListOfRows().get(7).getElementsInRow().get(8).setValue(2);

        board.getListOfRows().get(8).getElementsInRow().get(0).setValue(4);
        board.getListOfRows().get(8).getElementsInRow().get(1).setValue(5);
        board.getListOfRows().get(8).getElementsInRow().get(3).setValue(8);
        board.getListOfRows().get(8).getElementsInRow().get(4).setValue(9);
        board.getListOfRows().get(8).getElementsInRow().get(5).setValue(2);
        board.getListOfRows().get(8).getElementsInRow().get(7).setValue(7);
        board.getListOfRows().get(8).getElementsInRow().get(8).setValue(1);
    }
}
