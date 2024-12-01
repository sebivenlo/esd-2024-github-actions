package org.example.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(5.0, calculator.add(2.0, 3.0));
    }

    @Test
    void testSubtraction() {
        assertEquals(4.0, calculator.subtract(7.0, 3.0));
    }

    @Test
    void testMultiplication() {
        assertEquals(15.0, calculator.multiply(3.0, 5.0));
    }

    @Test
    void testDivision() {
        assertEquals(4.0, calculator.divide(12.0, 3.0));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5.0, 0.0);
        });
        assertEquals("Division by zero", exception.getMessage());
    }
}