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
        String stop = null;
        boolean isSolved = false;
        Scanner scanner = new Scanner(System.in);


        board.drawBoard();
//        do {
//        do {
//            System.out.println("W ktorym rzedzie chcesz dodac wartosc?");
//            int row = scanner.nextInt() - 1;
//            System.out.println("W ktorej kolumnie chcesz dodac wartosc?");
//            int column = scanner.nextInt() - 1;
//            System.out.println("Podaj wartosc do wprowadzenia (1-9)");
//            int value = scanner.nextInt();
//            board.getListOfRows().get(row).getElementsInRow().get(column).setValue(value);
//            board.drawBoard();
//
//            System.out.println("Aby zakonczyc dodawanie wartosci wpisz SUDOKU");
//            scanner.nextLine();
//            start = scanner.nextLine();
//        } while (!start.equals("SUDOKU"));                // <-------- Wyłączone na czas testów SudokuController

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
                controller.removingPossibleValuesFromValues(board);
                checkBacktrackNeed();
                //Columns
                controller.removingValuesFromPossibleValuesColumns(board);
                controller.lastPossibleNumberInElement(board);
                controller.lastPossibleInColumn(board, backtrackList);
                controller.removingPossibleValuesFromValues(board);
                checkBacktrackNeed();
                //Sections
                controller.removingValuesFromPossibleValuesSection(board);
                controller.lastPossibleNumberInElement(board);
                controller.lastPossibleInSection(board, backtrackList);
                controller.removingPossibleValuesFromValues(board);
                checkBacktrackNeed();

                System.out.println();
                System.out.println();
                board.drawBoard();

                if (controller.areAllElementsFilled(board) && !controller.isSudokuSolvedWell(board)) {
                    controller.needToDoBacktrack = true;
                    checkBacktrackNeed();
                }
                if (board.equals(boardDeepCopy)) {
                    guessingOperation();
                } else {
                    boardDeepCopy = board.boardDeepCopy();
                }
            } while (!controller.areAllElementsFilled(board) || !controller.isSudokuSolvedWell(board));

            board.cleanBoard();
            board = elementsGenerator.boardGenerator();

//            promptEnterKey();

//        } while(true);
    }

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private void guessingOperation() throws CloneNotSupportedException {
        backtrackList.add(controller.guessingOperation(board));
        System.out.println("Zgadywanie liczby i wykonanie kopii");

        Backtrack lastBacktrack = backtrackList.get(backtrackList.size()-1);
//        board.getListOfRows().get(lastBacktrack.getRow()).getElementsInRow().get(lastBacktrack.getColumn()).setValue(lastBacktrack.getValue());
        board.getListOfRows().get(lastBacktrack.getRow()).getElementsInRow().get(lastBacktrack.getColumn()).removePossibleValue(lastBacktrack.getValue());
        board.drawBoard();
    }

    private void checkBacktrackNeed() {
        if (controller.needToDoBacktrack) {

            controller.needToDoBacktrack = false;
            board = backtrackList.get(backtrackList.size() - 1).getBoardDeepCopy();
            Backtrack lastBacktrack = backtrackList.get(backtrackList.size()-1);

            restartPossibleNumbers();
            controller.removingValuesFromPossibleValuesRows(board);
            controller.removingValuesFromPossibleValuesColumns(board);
            controller.removingValuesFromPossibleValuesSection(board);
            controller.removingPossibleValuesFromValues(board);
//            board.getListOfRows().get(lastBacktrack.getRow()).getElementsInRow().get(lastBacktrack.getColumn()).removePossibleValue(lastBacktrack.getValue());
            for (Backtrack b : backtrackList ) {
                board.getListOfRows().get(b.getRow()).getElementsInRow().get(b.getColumn()).removePossibleValue(b.getValue());
            }

            System.out.println("Wykonano backtrack");
            board.drawBoard();
        }
    }

    private void restartPossibleNumbers() {
        board.getListOfRows().stream()
                .flatMap(n -> n.getElementsInRow().stream())
                .filter(n -> n.getValue() == -1)
                .forEach(n -> n.getPossibleValues().clear());

        List<Integer> allPossibleNumbers = new ArrayList<>();
        for (int i=1; i<10; i++) {
            allPossibleNumbers.add(i);
        }
        board.getListOfRows().stream()
                .flatMap(n -> n.getElementsInRow().stream())
                .filter(n -> n.getValue() == -1)
                .forEach(n -> n.getPossibleValues().addAll(allPossibleNumbers));
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
        board.getListOfRows().get(0).getElementsInRow().get(1).setValue(2);
        board.getListOfRows().get(0).getElementsInRow().get(2).setValue(8);
        board.getListOfRows().get(0).getElementsInRow().get(3).setValue(3);
        board.getListOfRows().get(0).getElementsInRow().get(5).setValue(5);
        board.getListOfRows().get(0).getElementsInRow().get(6).setValue(9);
        board.getListOfRows().get(0).getElementsInRow().get(7).setValue(7);

        board.getListOfRows().get(1).getElementsInRow().get(1).setValue(7);
        board.getListOfRows().get(1).getElementsInRow().get(2).setValue(9);
        board.getListOfRows().get(1).getElementsInRow().get(4).setValue(6);
        board.getListOfRows().get(1).getElementsInRow().get(6).setValue(1);
        board.getListOfRows().get(1).getElementsInRow().get(7).setValue(5);

        board.getListOfRows().get(2).getElementsInRow().get(1).setValue(6);
        board.getListOfRows().get(2).getElementsInRow().get(2).setValue(1);
        board.getListOfRows().get(2).getElementsInRow().get(6).setValue(3);
        board.getListOfRows().get(2).getElementsInRow().get(7).setValue(4);

        board.getListOfRows().get(3).getElementsInRow().get(2).setValue(5);
        board.getListOfRows().get(3).getElementsInRow().get(6).setValue(4);

        board.getListOfRows().get(4).getElementsInRow().get(1).setValue(3);
        board.getListOfRows().get(4).getElementsInRow().get(2).setValue(7);
        board.getListOfRows().get(4).getElementsInRow().get(3).setValue(8);
        board.getListOfRows().get(4).getElementsInRow().get(5).setValue(4);
        board.getListOfRows().get(4).getElementsInRow().get(6).setValue(6);
        board.getListOfRows().get(4).getElementsInRow().get(7).setValue(9);

        board.getListOfRows().get(5).getElementsInRow().get(2).setValue(6);
        board.getListOfRows().get(5).getElementsInRow().get(6).setValue(2);

        board.getListOfRows().get(6).getElementsInRow().get(3).setValue(7);
        board.getListOfRows().get(6).getElementsInRow().get(4).setValue(9);
        board.getListOfRows().get(6).getElementsInRow().get(5).setValue(6);

        board.getListOfRows().get(8).getElementsInRow().get(3).setValue(1);
        board.getListOfRows().get(8).getElementsInRow().get(5).setValue(2);


    }

    public void exampleSudokuWithoutGuessingFive(SudokuBoard board) {
        board.getListOfRows().get(0).getElementsInRow().get(1).setValue(2);
        board.getListOfRows().get(0).getElementsInRow().get(3).setValue(5);
        board.getListOfRows().get(0).getElementsInRow().get(5).setValue(1);
        board.getListOfRows().get(0).getElementsInRow().get(7).setValue(9);

        board.getListOfRows().get(1).getElementsInRow().get(0).setValue(8);
        board.getListOfRows().get(1).getElementsInRow().get(3).setValue(2);
        board.getListOfRows().get(1).getElementsInRow().get(5).setValue(3);
        board.getListOfRows().get(1).getElementsInRow().get(8).setValue(6);

        board.getListOfRows().get(2).getElementsInRow().get(1).setValue(3);
        board.getListOfRows().get(2).getElementsInRow().get(4).setValue(6);
        board.getListOfRows().get(2).getElementsInRow().get(7).setValue(7);

        board.getListOfRows().get(3).getElementsInRow().get(2).setValue(1);
        board.getListOfRows().get(3).getElementsInRow().get(6).setValue(6);

        board.getListOfRows().get(4).getElementsInRow().get(0).setValue(5);
        board.getListOfRows().get(4).getElementsInRow().get(1).setValue(4);
        board.getListOfRows().get(4).getElementsInRow().get(7).setValue(1);
        board.getListOfRows().get(4).getElementsInRow().get(8).setValue(9);

        board.getListOfRows().get(5).getElementsInRow().get(2).setValue(2);
        board.getListOfRows().get(5).getElementsInRow().get(6).setValue(7);

        board.getListOfRows().get(6).getElementsInRow().get(1).setValue(9);
        board.getListOfRows().get(6).getElementsInRow().get(4).setValue(3);
        board.getListOfRows().get(6).getElementsInRow().get(7).setValue(8);

        board.getListOfRows().get(7).getElementsInRow().get(0).setValue(2);
        board.getListOfRows().get(7).getElementsInRow().get(3).setValue(8);
        board.getListOfRows().get(7).getElementsInRow().get(5).setValue(4);
        board.getListOfRows().get(7).getElementsInRow().get(8).setValue(7);

        board.getListOfRows().get(8).getElementsInRow().get(1).setValue(1);
        board.getListOfRows().get(8).getElementsInRow().get(3).setValue(9);
        board.getListOfRows().get(8).getElementsInRow().get(5).setValue(7);
        board.getListOfRows().get(8).getElementsInRow().get(7).setValue(6);
    }



}
