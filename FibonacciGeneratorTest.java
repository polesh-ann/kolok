package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class FibonacciGeneratorTest {

    @Test
    public void testValidInput() {
        FibonacciGenerator generator = new FibonacciGenerator(5);
        List<Integer> expected = List.of(0, 1, 1, 2, 3);
        assertEquals(expected, generator.generate());
    }

    @Test
    public void testOneInput() {
        FibonacciGenerator generator = new FibonacciGenerator(1);
        List<Integer> expected = List.of(0);
        assertEquals(expected, generator.generate());
    }

    @Test
    public void testTwoInput() {
        FibonacciGenerator generator = new FibonacciGenerator(2);
        List<Integer> expected = List.of(0, 1);
        assertEquals(expected, generator.generate());
    }

    @Test
    public void testInvalidInputNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FibonacciGenerator(-5);
        });
        assertEquals("Input must be a natural number greater than 0.", exception.getMessage());
    }

    @Test
    public void testInvalidInputZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FibonacciGenerator(0);
        });
        assertEquals("Input must be a natural number greater than 0.", exception.getMessage());
    }

    @Test
    public void testLargeInput() {
        FibonacciGenerator generator = new FibonacciGenerator(10);
        List<Integer> expected = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        assertEquals(expected, generator.generate());
    }
}
