package com.kodilla.sudoku;

import com.kodilla.sudoku.objects.*;

import java.util.*;

public class SudokuGame {
    private List<Backtrack> backtrackList = new ArrayList<>();
    private ElementsGenerator elementsGenerator = new ElementsGenerator();
    private SudokuController controller = new SudokuController();
    private SudokuBoard board = elementsGenerator.boardGenerator();
    private SudokuBoard boardDeepCopy = new SudokuBoard();

    public void StartGame() throws UnresolvedSudokuException, CloneNotSupportedException {

        String start = null;
        boolean isSolved = false;
        Scanner scanner = new Scanner(System.in);


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

        exampleSudokuWithoutGuessingFour(board);
        board.drawBoard();
        System.out.println();
        controller.removingPossibleValuesFromValues(board);

        do {
//            removeDuplicatedPossibleNumbers();
            //Rows
            controller.removingValuesFromPossibleValuesRows(board);
            controller.lastPossibleNumberInElement(board);
            controller.lastPossibleInRow(board, backtrackList);
            checkBacktrackNeed();
            controller.removingPossibleValuesFromValues(board);

            //Columns
            controller.removingValuesFromPossibleValuesColumns(board);
            controller.lastPossibleNumberInElement(board);
            controller.lastPossibleInColumn(board, backtrackList);
            checkBacktrackNeed();
            controller.removingPossibleValuesFromValues(board);
            //Sections
            controller.removingValuesFromPossibleValuesSection(board);
            controller.lastPossibleNumberInElement(board);
            controller.lastPossibleInSection(board, backtrackList);
            checkBacktrackNeed();
            controller.removingPossibleValuesFromValues(board);

            System.out.println();
            System.out.println();
            board.drawBoard();

            isSolved = controller.isSudokuSolved(board);

            if (board.equals(boardDeepCopy)){
                System.out.println("Nie mozna rozwiazac sudoku bez zgadywania");
                guessingOperation();
            } else {
                boardDeepCopy = board.boardDeepCopy(false);
            }
        } while (!isSolved);
    }

    private void guessingOperation() throws CloneNotSupportedException {
        backtrackList.add(controller.guessingOperation(board));
        Backtrack lastBacktrack = backtrackList.get(backtrackList.size()-1);
        board.getListOfRows().get(lastBacktrack.getRow()).getElementsInRow().get(lastBacktrack.getColumn()).setValue(lastBacktrack.getValue());
    }

    private void checkBacktrackNeed() {
        if (controller.needToDoBacktrack) {
            controller.needToDoBacktrack = false;
            board = backtrackList.get(backtrackList.size()-1).getBoardDeepCopy();
            Backtrack lastBacktrack = backtrackList.get(backtrackList.size()-1);
            board.getListOfRows().get(lastBacktrack.getRow()).getElementsInRow().get(lastBacktrack.getColumn()).removePossibleValue();
            System.out.println("Wykonano backtrack");
        }
    }

    private void removeDuplicatedPossibleNumbers() {
        for (SudokuRow row : board.getListOfRows()) {
            for (SudokuElement element : row.getElementsInRow()){
                Set<Integer> possibleValuesUnduplicated = new LinkedHashSet<>();
                possibleValuesUnduplicated.addAll(element.getPossibleValues());
                List<Integer> withoutDuplicates = new ArrayList<>();
                withoutDuplicates.addAll(possibleValuesUnduplicated);
                element.getPossibleValues().clear();
                element.setPossibleValues(withoutDuplicates);
            }
        }
    }

    // SUDOKU WITHOUT GUESSING
    public void exampleSudokuWithoutGuessingOne(SudokuBoard board) {
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

    public void exampleSudokuWithoutGuessingTwo(SudokuBoard board) {
        board.getListOfRows().get(0).getElementsInRow().get(0).setValue(4);
        board.getListOfRows().get(0).getElementsInRow().get(2).setValue(7);
        board.getListOfRows().get(0).getElementsInRow().get(3).setValue(3);
        board.getListOfRows().get(0).getElementsInRow().get(5).setValue(2);
        board.getListOfRows().get(0).getElementsInRow().get(6).setValue(9);
        board.getListOfRows().get(0).getElementsInRow().get(8).setValue(6);

        board.getListOfRows().get(1).getElementsInRow().get(1).setValue(1);
        board.getListOfRows().get(1).getElementsInRow().get(3).setValue(8);
        board.getListOfRows().get(1).getElementsInRow().get(5).setValue(7);
        board.getListOfRows().get(1).getElementsInRow().get(7).setValue(4);

        board.getListOfRows().get(2).getElementsInRow().get(0).setValue(5);
        board.getListOfRows().get(2).getElementsInRow().get(1).setValue(9);
        board.getListOfRows().get(2).getElementsInRow().get(2).setValue(3);
        board.getListOfRows().get(2).getElementsInRow().get(3).setValue(6);
        board.getListOfRows().get(2).getElementsInRow().get(5).setValue(1);
        board.getListOfRows().get(2).getElementsInRow().get(6).setValue(2);
        board.getListOfRows().get(2).getElementsInRow().get(7).setValue(8);
        board.getListOfRows().get(2).getElementsInRow().get(8).setValue(7);

        board.getListOfRows().get(3).getElementsInRow().get(0).setValue(2);
        board.getListOfRows().get(3).getElementsInRow().get(1).setValue(6);
        board.getListOfRows().get(3).getElementsInRow().get(2).setValue(1);
        board.getListOfRows().get(3).getElementsInRow().get(3).setValue(9);
        board.getListOfRows().get(3).getElementsInRow().get(5).setValue(8);
        board.getListOfRows().get(3).getElementsInRow().get(6).setValue(4);
        board.getListOfRows().get(3).getElementsInRow().get(7).setValue(7);
        board.getListOfRows().get(3).getElementsInRow().get(8).setValue(5);

        board.getListOfRows().get(4).getElementsInRow().get(1).setValue(4);
        board.getListOfRows().get(4).getElementsInRow().get(3).setValue(5);
        board.getListOfRows().get(4).getElementsInRow().get(5).setValue(6);
        board.getListOfRows().get(4).getElementsInRow().get(7).setValue(2);

        board.getListOfRows().get(5).getElementsInRow().get(0).setValue(3);
        board.getListOfRows().get(5).getElementsInRow().get(1).setValue(5);
        board.getListOfRows().get(5).getElementsInRow().get(2).setValue(9);
        board.getListOfRows().get(5).getElementsInRow().get(3).setValue(2);
        board.getListOfRows().get(5).getElementsInRow().get(5).setValue(4);
        board.getListOfRows().get(5).getElementsInRow().get(6).setValue(8);
        board.getListOfRows().get(5).getElementsInRow().get(7).setValue(6);
        board.getListOfRows().get(5).getElementsInRow().get(8).setValue(1);

        board.getListOfRows().get(6).getElementsInRow().get(0).setValue(1);
        board.getListOfRows().get(6).getElementsInRow().get(1).setValue(3);
        board.getListOfRows().get(6).getElementsInRow().get(2).setValue(4);
        board.getListOfRows().get(6).getElementsInRow().get(3).setValue(7);
        board.getListOfRows().get(6).getElementsInRow().get(5).setValue(5);
        board.getListOfRows().get(6).getElementsInRow().get(6).setValue(6);
        board.getListOfRows().get(6).getElementsInRow().get(7).setValue(9);
        board.getListOfRows().get(6).getElementsInRow().get(8).setValue(8);

        board.getListOfRows().get(7).getElementsInRow().get(1).setValue(7);
        board.getListOfRows().get(7).getElementsInRow().get(3).setValue(4);
        board.getListOfRows().get(7).getElementsInRow().get(5).setValue(3);
        board.getListOfRows().get(7).getElementsInRow().get(7).setValue(5);

        board.getListOfRows().get(8).getElementsInRow().get(0).setValue(8);
        board.getListOfRows().get(8).getElementsInRow().get(2).setValue(5);
        board.getListOfRows().get(8).getElementsInRow().get(3).setValue(1);
        board.getListOfRows().get(8).getElementsInRow().get(5).setValue(9);
        board.getListOfRows().get(8).getElementsInRow().get(6).setValue(7);
        board.getListOfRows().get(8).getElementsInRow().get(8).setValue(4);

    }

    // SUDOKU WITH GUESSING
    public void exampleSudokuWithoutGuessingThree(SudokuBoard board) {
        board.getListOfRows().get(0).getElementsInRow().get(0).setValue(9);
        board.getListOfRows().get(0).getElementsInRow().get(2).setValue(6);
        board.getListOfRows().get(0).getElementsInRow().get(4).setValue(7);
        board.getListOfRows().get(0).getElementsInRow().get(6).setValue(4);
        board.getListOfRows().get(0).getElementsInRow().get(8).setValue(3);

        board.getListOfRows().get(1).getElementsInRow().get(3).setValue(4);
        board.getListOfRows().get(1).getElementsInRow().get(6).setValue(2);

        board.getListOfRows().get(2).getElementsInRow().get(1).setValue(7);
        board.getListOfRows().get(2).getElementsInRow().get(4).setValue(2);
        board.getListOfRows().get(2).getElementsInRow().get(5).setValue(3);
        board.getListOfRows().get(2).getElementsInRow().get(7).setValue(1);

        board.getListOfRows().get(3).getElementsInRow().get(0).setValue(5);
        board.getListOfRows().get(3).getElementsInRow().get(6).setValue(1);

        board.getListOfRows().get(4).getElementsInRow().get(1).setValue(4);
        board.getListOfRows().get(4).getElementsInRow().get(3).setValue(2);
        board.getListOfRows().get(4).getElementsInRow().get(5).setValue(8);
        board.getListOfRows().get(4).getElementsInRow().get(7).setValue(6);

        board.getListOfRows().get(5).getElementsInRow().get(2).setValue(3);
        board.getListOfRows().get(5).getElementsInRow().get(8).setValue(5);

        board.getListOfRows().get(6).getElementsInRow().get(1).setValue(3);
        board.getListOfRows().get(6).getElementsInRow().get(3).setValue(7);
        board.getListOfRows().get(6).getElementsInRow().get(7).setValue(5);

        board.getListOfRows().get(7).getElementsInRow().get(2).setValue(7);
        board.getListOfRows().get(7).getElementsInRow().get(5).setValue(5);

        board.getListOfRows().get(8).getElementsInRow().get(0).setValue(4);
        board.getListOfRows().get(8).getElementsInRow().get(2).setValue(5);
        board.getListOfRows().get(8).getElementsInRow().get(4).setValue(1);
        board.getListOfRows().get(8).getElementsInRow().get(6).setValue(7);
        board.getListOfRows().get(8).getElementsInRow().get(8).setValue(8);

    }


    public void exampleSudokuWithoutGuessingFour(SudokuBoard board) {
        board.getListOfRows().get(0).getElementsInRow().get(0).setValue(9);
        board.getListOfRows().get(0).getElementsInRow().get(5).setValue(4);
        board.getListOfRows().get(0).getElementsInRow().get(6).setValue(2);
        board.getListOfRows().get(0).getElementsInRow().get(7).setValue(8);

        board.getListOfRows().get(1).getElementsInRow().get(3).setValue(6);

        board.getListOfRows().get(2).getElementsInRow().get(2).setValue(5);
        board.getListOfRows().get(2).getElementsInRow().get(4).setValue(7);
        board.getListOfRows().get(2).getElementsInRow().get(8).setValue(6);

        board.getListOfRows().get(3).getElementsInRow().get(2).setValue(4);
        board.getListOfRows().get(3).getElementsInRow().get(3).setValue(8);
        board.getListOfRows().get(3).getElementsInRow().get(4).setValue(1);

        board.getListOfRows().get(4).getElementsInRow().get(7).setValue(3);

        board.getListOfRows().get(5).getElementsInRow().get(2).setValue(1);
        board.getListOfRows().get(5).getElementsInRow().get(4).setValue(5);
        board.getListOfRows().get(5).getElementsInRow().get(5).setValue(7);

        board.getListOfRows().get(6).getElementsInRow().get(0).setValue(6);

        board.getListOfRows().get(7).getElementsInRow().get(1).setValue(2);
        board.getListOfRows().get(7).getElementsInRow().get(3).setValue(7);
        board.getListOfRows().get(7).getElementsInRow().get(4).setValue(8);
        board.getListOfRows().get(7).getElementsInRow().get(6).setValue(5);
        board.getListOfRows().get(7).getElementsInRow().get(7).setValue(6);

        board.getListOfRows().get(8).getElementsInRow().get(3).setValue(1);
        board.getListOfRows().get(8).getElementsInRow().get(4).setValue(2);
        board.getListOfRows().get(8).getElementsInRow().get(8).setValue(7);

    }

}
