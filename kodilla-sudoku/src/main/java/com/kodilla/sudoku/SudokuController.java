package com.kodilla.sudoku;

import com.kodilla.sudoku.objects.SudokuBoard;
import com.kodilla.sudoku.objects.SudokuElement;
import com.kodilla.sudoku.objects.SudokuRow;
import com.kodilla.sudoku.objects.UnresolvedSudokuException;

import java.util.*;
import java.util.stream.Collectors;

public class SudokuController {

    // OPERATIONS FOR ROWS
    public void removingValuesFromPossibleValuesRows(SudokuBoard board) {
        /*jeśli ta cyfra jest wpisana w innym polu, usuwamy ją z tablicy możliwych cyfr*/
        List<Integer> valuesInRow = new ArrayList<>();
        for (int row = 0; row < board.getListOfRows().size(); row++) {   //iterowanie po kolejnych rzędach
            valuesInRow.clear();
            for (int column = 0; column < board.getListOfRows().get(row).getElementsInRow().size(); column++) {  //iterowanie po kolejnych kolumnach w rzędzie
                SudokuElement sudokuElement = board.getListOfRows().get(row).getElementsInRow().get(column);
                if (sudokuElement.getValue() != -1) {
                    valuesInRow.add(sudokuElement.getValue());
                }
            }
            board.getListOfRows().get(row).getElementsInRow().stream()
                    .map(n -> n.getPossibleValues())
                    .forEach(n -> n.removeAll(valuesInRow));
        }
    }

    public void lastPossibleInRow(SudokuBoard board) throws UnresolvedSudokuException {
        /*nie występuje ani jako wpisana, ani jako możliwa cyfra w innym polu, wpisujemy ją do aktualnego pola,
          jeśli ta cyfra jest wpisana w innym polu, ale jest też jedyną możliwością w aktualnym polu, algorytm zwraca błąd */
        Map<Integer, Integer> elements = new HashMap<>();

        for (SudokuRow row : board.getListOfRows()) {
            Set<Integer> allValuesInRow = row.getElementsInRow().stream()
                    .map(n -> n.getValue())
                    .collect(Collectors.toSet());
            allValuesInRow.remove(-1);

            elements = lastPossibleInRowCreateElements(elements);
            Map<Integer, Integer> finalElements = elements;

            row.getElementsInRow().stream()
                    .flatMap(n -> n.getPossibleValues().stream())
                    .forEach(n -> finalElements.put(n, finalElements.get(n) + 1));

            for (Integer key : finalElements.keySet()) {
                if (finalElements.get(key) == 1) {
                    row.getElementsInRow().stream()
                            .filter(n -> n.getPossibleValues().contains(key))
                            .forEach(n -> n.setValue(key));
                } else if (finalElements.get(key) == 0) {
                    if (!allValuesInRow.contains(key)) {
                        System.out.println("Błąd1");
                        throw new UnresolvedSudokuException();
                    }
                }
            }
            allValuesInRow.clear();
        }
    }


    // OPERATIONS FOR COLUMNS
    public void removingValuesFromPossibleValuesColumns(SudokuBoard board) {
        /*jeśli ta cyfra jest wpisana w innym polu, usuwamy ją z tablicy możliwych cyfr*/
        List<Integer> valuesInColumn = new ArrayList<>();
        for (int column = 0; column < 9; column++) {
            valuesInColumn.clear();
            for (int row = 0; row < 9; row++) {
                SudokuElement sudokuElement = board.getListOfRows().get(row).getElementsInRow().get(column);
                if (sudokuElement.getValue() != -1) {
                    valuesInColumn.add(sudokuElement.getValue());
                }
            }
            for (int row = 0; row < 9; row++) {
                board.getListOfRows().get(row).getElementsInRow().get(column)
                        .getPossibleValues()
                        .removeAll(valuesInColumn);
            }
        }
    }

    public void lastPossibleInColumn(SudokuBoard board) throws UnresolvedSudokuException {
        /*nie występuje ani jako wpisana, ani jako możliwa cyfra w innym polu, wpisujemy ją do aktualnego pola,
          jeśli ta cyfra jest wpisana w innym polu, ale jest też jedyną możliwością w aktualnym polu, algorytm zwraca błąd */
        Map<Integer, Integer> elements = new HashMap<>();
        List<SudokuElement> allElementsInColumn = new ArrayList<>();
        Set<Integer> allValuesInColumn = new HashSet<>();

        for (int column = 0; column < 9; column++) {
            allValuesInColumn.clear();
            allElementsInColumn.clear();

            for (int row = 0; row < 9; row++) {
                allElementsInColumn.add(board.getListOfRows().get(row).getElementsInRow().get(column));
                Integer value = board.getListOfRows().get(row).getElementsInRow().get(column).getValue();
                if (value != -1) {
                    allValuesInColumn.add(value);
                }
            }

            elements = lastPossibleInRowCreateElements(elements);
            Map<Integer, Integer> finalElements = elements;

            appearOneOrZeroTimesInPossibleNumbers(allElementsInColumn, allValuesInColumn, finalElements);
        }
    }


    // OPERATIONS FOR SECTIONS
    public void removingValuesFromPossibleValuesSection(SudokuBoard board) {
        /*jeśli ta cyfra jest wpisana w innym polu, usuwamy ją z tablicy możliwych cyfr*/
        Set<Integer> valuesInSection = new HashSet<>();

        for (int section = 0; section < 9; section++) {
            valuesInSection.clear();

            int finalSection = section;
            valuesInSection = board.getListOfRows().stream()
                    .flatMap(n -> n.getElementsInRow().stream())
                    .filter(n -> n.getSection() == finalSection)
                    .map(n -> n.getValue())
                    .collect(Collectors.toSet());
            valuesInSection.remove(-1);

            Set<Integer> finalValuesInSection = valuesInSection;
            board.getListOfRows().stream()
                    .flatMap(n -> n.getElementsInRow().stream())
                    .filter(n -> n.getSection() == finalSection)
                    .map(n -> n.getPossibleValues())
                    .forEach(n -> n.removeAll(finalValuesInSection));
        }
    }

    public void lastPossibleInSection(SudokuBoard board) throws UnresolvedSudokuException {
        /*nie występuje ani jako wpisana, ani jako możliwa cyfra w innym polu, wpisujemy ją do aktualnego pola,
          jeśli ta cyfra jest wpisana w innym polu, ale jest też jedyną możliwością w aktualnym polu, algorytm zwraca błąd */
        Map<Integer, Integer> elements = new HashMap<>();
        List<SudokuElement> allElementsInSection = new ArrayList<>();
        Set<Integer> allValuesInSection = new HashSet<>();

        for (int section = 0; section < 9; section++) {
            allElementsInSection.clear();
            allValuesInSection.clear();

            int finalSection = section;
            allElementsInSection = board.getListOfRows().stream()
                    .flatMap(n -> n.getElementsInRow().stream())
                    .filter(n -> n.getSection() == finalSection)
                    .collect(Collectors.toList());

            allValuesInSection = allElementsInSection.stream()
                    .map(n -> n.getValue())
                    .collect(Collectors.toSet());
            allValuesInSection.remove(-1);

            elements = lastPossibleInRowCreateElements(elements);
            Map<Integer, Integer> finalElements = elements;

            appearOneOrZeroTimesInPossibleNumbers(allElementsInSection, allValuesInSection, finalElements);
        }
    }


    // UNIVERSAL OPERATIONS
    public void lastPossibleNumberInElement(SudokuBoard board) {
        /*jeśli została tylko jedna możliwa cyfra, wpisujemy ją do aktualnego pola*/
        List<SudokuElement> elements = board.getListOfRows().stream()
                .flatMap(n -> n.getElementsInRow().stream())
                .filter(n -> n.getPossibleValues().size() == 1)
                .collect(Collectors.toList());

        elements.stream()
                .forEach(n -> n.setValue(n.getPossibleValues().get(0)));
    }

    public boolean isSudokuSolved(SudokuBoard board) {
        boolean isSolved = false;
        List<SudokuElement> numberOfFilledElements = board.getListOfRows().stream()
                .flatMap(n -> n.getElementsInRow().stream())
                .filter(n -> n.getValue() != -1)
                .collect(Collectors.toList());
        if(numberOfFilledElements.size()==81) {
            isSolved=true;
        }
        return isSolved;
    }


    // INNER OPERATIONS
    private Map<Integer, Integer> lastPossibleInRowCreateElements(Map<Integer, Integer> elements) {
        /*tworzenie elementów dla lastPossibleInRow*/
        elements.clear();
        for (int i = 1; i < 10; i++) {
            elements.put(i, 0);
        }
        return elements;
    }

    private void appearOneOrZeroTimesInPossibleNumbers(List<SudokuElement> allElementsInSection,
                                                       Set<Integer> allValuesInSection,
                                                       Map<Integer, Integer> finalElements) throws UnresolvedSudokuException {
        allElementsInSection.stream()
                .flatMap(n -> n.getPossibleValues().stream())
                .forEach(n -> finalElements.put(n, finalElements.get(n) + 1));

        for (Integer key : finalElements.keySet()) {
            if (finalElements.get(key) == 1) {
                allElementsInSection.stream()
                        .filter(n -> n.getPossibleValues().contains(key))
                        .forEach(n -> n.setValue(key));
            } else if (finalElements.get(key) == 0) {
                if (!allValuesInSection.contains(key)) {
                    throw new UnresolvedSudokuException();
                }
            }
        }
    }


}