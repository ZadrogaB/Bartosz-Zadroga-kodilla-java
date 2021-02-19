package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    void testGetBooks(){
        //Given
        Library library = new Library("Library");
        IntStream.iterate(1,n -> n+1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Book number " + n, "Author " + n, LocalDate.of(2002, 3, 1 + n))));

        Library shallowCloneLibrary = null;
        try {
            shallowCloneLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException exception) {
            System.out.println(exception);
        }

        Library deepCloneLibrary = null;
        try {
            deepCloneLibrary = library.deepCopy();
        } catch (CloneNotSupportedException exception) {
            System.out.println(exception);
        }

        Book addBook = new Book("1","1", LocalDate.of(2000,2,2));
        shallowCloneLibrary.getBooks().add(addBook);

        System.out.println("Library: ");
        library.getBooks().stream()
                .forEach(n -> System.out.println("  " + n));
        System.out.println("Shallow Clone library: ");
        shallowCloneLibrary.getBooks().stream()
                .forEach(n -> System.out.println("  " + n));
        System.out.println("Deep Clone Library: ");
        deepCloneLibrary.getBooks().stream()
                .forEach(n -> System.out.println("  " + n));

        assertEquals(library.getBooks().size(), shallowCloneLibrary.getBooks().size());
        assertNotEquals(library.getBooks().size(), deepCloneLibrary.getBooks().size());
    }
}
