package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        Book book1 = new Book("aaa", "aaa", 1000, "1111");
        Book book2 = new Book("bbb", "bbb", 2000, "2222");
        Book book3 = new Book("ccc", "ccc", 3000, "3333");
        Book book4 = new Book("ddd", "ddd", 4000, "4444");
        Book book5 = new Book("eee", "eee", 5000, "5555");
        MedianAdapter adapter = new MedianAdapter();
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        //When
        int result = adapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(3000, result);
    }
}
