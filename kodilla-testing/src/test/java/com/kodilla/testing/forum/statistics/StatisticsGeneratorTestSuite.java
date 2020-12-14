package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatisticsGeneratorTestSuite {

    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    public void beforeEveryTest() {

    }


    @Test
    void testZeroPosts() {

        // Given
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(0);
        statisticsGenerator.calculateAdvStatistics(statisticsMock);
        statisticsGenerator.showStatistics();
        // When
        int numberOfPosts = statisticsGenerator.getNumberOfPosts();
        // Then
        assertEquals(0,numberOfPosts);

    }

    @Test
    void testThousandPosts() {
        // Given
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(1000);
        statisticsGenerator.calculateAdvStatistics(statisticsMock);
        statisticsGenerator.showStatistics();
        // When
        int numberOfPosts = statisticsGenerator.getNumberOfPosts();
        // Then
        assertEquals(1000,numberOfPosts);

    }

    @Test
    void testZeroComments() {
        // Given
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(statisticsMock);
        when(statisticsMock.commentsCount()).thenReturn(0);
        statisticsGenerator.calculateAdvStatistics(statisticsMock);
        statisticsGenerator.showStatistics();
        // When
        int numberOfComments = statisticsGenerator.getNumberOfComments();
        // Then
        assertEquals(0, numberOfComments);

    }

    @Test
    void testNumberOfCommentsLowerThanPosts() {
        // Given
        List<String> usersNamesTest = new ArrayList<>();
        usersNamesTest.add("John");
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(statisticsMock);
        when(statisticsMock.commentsCount()).thenReturn(82);
        when(statisticsMock.postsCount()).thenReturn(999);
        when(statisticsMock.usersNames()).thenReturn(usersNamesTest);
        statisticsGenerator.calculateAdvStatistics(statisticsMock);
        statisticsGenerator.showStatistics();
        double result = 82.0/999.0;
        // When
        double averageNumberOfCommentsOnPost = statisticsGenerator.getAverageNumberOfCommentsOnPost();
        // Then
        assertEquals(result, averageNumberOfCommentsOnPost, 0.01);
    }

    @Test
    void testNumberOfCommentsBiggerThanPosts() {
        List<String> usersNamesTest = new ArrayList<>();
        usersNamesTest.add("John");
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(statisticsMock);
        when(statisticsMock.commentsCount()).thenReturn(999);
        when(statisticsMock.postsCount()).thenReturn(81);
        when(statisticsMock.usersNames()).thenReturn(usersNamesTest);
        statisticsGenerator.calculateAdvStatistics(statisticsMock);
        statisticsGenerator.showStatistics();
        double result = 999.0/81.0;
        // When
        double averageNumberOfCommentsOnPost = statisticsGenerator.getAverageNumberOfCommentsOnPost();
        // Then
        assertEquals(result, averageNumberOfCommentsOnPost, 0.01);
    }

    @Test
    void testNumberOfUsersEqualsZero() {
        // Given
        List<String> usersNamesTest = new ArrayList<>();
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(statisticsMock);
        when(statisticsMock.commentsCount()).thenReturn(999);
        when(statisticsMock.postsCount()).thenReturn(81);
        when(statisticsMock.usersNames()).thenReturn(usersNamesTest);
        statisticsGenerator.calculateAdvStatistics(statisticsMock);
        statisticsGenerator.showStatistics();
        // When
        int numberOfUsers = statisticsGenerator.getNumberOfUsers();
        // Then
        assertEquals(0, numberOfUsers);
    }

    @Test
    void testNumberOfUsersEqualsThousand() {
        // Given
        List<String> usersNamesTest = usersListGenerator(1000);
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(statisticsMock);
        when(statisticsMock.commentsCount()).thenReturn(999);
        when(statisticsMock.postsCount()).thenReturn(81);
        when(statisticsMock.usersNames()).thenReturn(usersNamesTest);
        statisticsGenerator.calculateAdvStatistics(statisticsMock);
        statisticsGenerator.showStatistics();
        double testAverageNumberOfPostsOnUser = 81.0/1000.0;
        double testAverageNumberOfCommentsOnUser = 999.0/1000.0;
        // When
        int numberOfUsers = statisticsGenerator.getNumberOfUsers();
        double averageNumberOfPostsOnUser = statisticsGenerator.getAverageNumberOfPostsOnUser();
        double averageNumberOfCommentsOnUser = statisticsGenerator.getAverageNumberOfCommentsOnUser();
        // Then
        assertEquals(1000, numberOfUsers);
        assertEquals(testAverageNumberOfPostsOnUser, averageNumberOfPostsOnUser);
        assertEquals(testAverageNumberOfCommentsOnUser, averageNumberOfCommentsOnUser);
    }

    public List<String> usersListGenerator(int numberOfUsers){
        List<String> usersList = new ArrayList<>();

        for(int i=0;i<numberOfUsers;i++){
            usersList.add("UserNumber: " + String.valueOf(i));
        }
        return  usersList;
    }


}


/*Testy zrealizuj przy pomocy mocka interfejsu Statistics.
Przetestuj poprawność obliczeń wartości średnich dla różnych przypadków:

    gdy liczba postów = 0,
    gdy liczba postów = 1000,
    gdy liczba komentarzy = 0,
    gdy liczba komentarzy < liczba postów,
    gdy liczba komentarzy > liczba postów,
    gdy liczba użytkowników = 0,
    gdy liczba użytkowników = 100.

Uwaga! Każdy przypadek testowy powinien być osobnym testem jednostkowym.
Śmiało możesz skorzystać też z adnotacji @BeforeEach aby przygotować dane testowe.*/