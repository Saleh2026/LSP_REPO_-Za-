package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class GradeCalculatorTest {
    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    @DisplayName("Test average calculation")
    void testAverage() {
        assertEquals(80.0, calculator.average(70, 80, 90));
    }

    @Test
    @DisplayName("Test letter grade mapping")
    void testLetterGrade() {
        assertEquals("B", calculator.letterGrade(85.5));
    }

    @Test
    @DisplayName("Test if passing score is correct")
    void testIsPassing() {
        assertTrue(calculator.isPassing(60.0));
    }

    @Test
    @DisplayName("Boundary Value: Exactly 90 for A")
    void testBoundaryA() {
        assertEquals("A", calculator.letterGrade(90.0));
    }

    @Test
    @DisplayName("Boundary Value: Just below passing")
    void testBoundaryFailing() {
        assertFalse(calculator.isPassing(59.9));
    }

    @Test
    @DisplayName("Exception: Score too high")
    void testScoreTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(101, 80, 80);
        });
    }

    @Test
    @DisplayName("Exception: Score too low")
    void testScoreTooLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-1, 80, 80);
        });
    }
}