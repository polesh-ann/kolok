package org.example;

import java.util.ArrayList;
import java.util.List;

class FibonacciGenerator {
    private final int n;

    public FibonacciGenerator(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be a natural number greater than 0.");
        }
        this.n = n;
    }

    public List<Integer> generate() {
        List<Integer> fibSequence = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fibSequence.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        return fibSequence;
    }

    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            FibonacciGenerator generator = new FibonacciGenerator(n);
            List<Integer> fibonacciNumbers = generator.generate();
            System.out.println("Первые " + n + " числа Фибоначчи: " + fibonacciNumbers);
        } catch (NumberFormatException e) {
            System.err.println("Введите корректное целое число.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Введите число n как аргумент командной строки.");
        }
    }
}
