package com.kodilla.testing.shape;

import com.kodilla.testing.forum.tdd.ForumUser;
import org.junit.jupiter.api.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for adding and removing to list")
    class TestWithoutReturning {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(new Square(5));
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeList().size());
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(5);
            Square square = new Square(5);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            //When
            shapeCollector.removeFigure(circle);
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeList().size());
        }
    }

    @Nested
    @DisplayName("Tests for returning")
    class TestWithReturning {
        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle(5,10);
            shapeCollector.addFigure(triangle);
            //When
            Shape result = shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals(triangle, result);
        }

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(5);
            Square square = new Square(5);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Circle, Square",result);
        }
    }

}
