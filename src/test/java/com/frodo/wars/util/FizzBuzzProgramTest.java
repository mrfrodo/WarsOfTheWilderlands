package com.frodo.wars.util;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzProgramTest {

    @Test
    public void testFizzBuzz() {
        // Setup: Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Input array for the test (can be simplified for this test)
        Integer[] testInput = new Integer[]{1, 2, 3, 4, 5, 6, 15};

        // Run the fizzbuzz method with test input
        new FizzBuzzProgram().fizzbuzz(testInput);

        // Split output into lines to check each one
        String[] outputLines = outputStream.toString().split(System.lineSeparator());

        // Assertions to verify correct FizzBuzz behavior
        assertEquals("  ==> 1", outputLines[0]);
        assertEquals("  ==> 2", outputLines[1]);
        assertEquals("  ==> fizz", outputLines[2]);
        assertEquals("  ==> 3", outputLines[3]);
        assertEquals("  ==> 4", outputLines[4]);
        assertEquals("  ==> buzz", outputLines[5]);
        assertEquals("  ==> 5", outputLines[6]);
    }

    @Test
    public void testGetFizzBuzz() {
        FizzBuzzProgram fizzBuzzProgram = new FizzBuzzProgram();

        // Check the result for several numbers
        assertEquals("1", fizzBuzzProgram.getFizzBuzz(1));
        assertEquals("2", fizzBuzzProgram.getFizzBuzz(2));
        assertEquals("fizz", fizzBuzzProgram.getFizzBuzz(3));
        assertEquals("buzz", fizzBuzzProgram.getFizzBuzz(5));
        assertEquals("fizzbuzz", fizzBuzzProgram.getFizzBuzz(15));
        assertEquals("4", fizzBuzzProgram.getFizzBuzz(4));
        assertEquals("4123123", fizzBuzzProgram.getFizzBuzz(4123123));
        assertEquals("fizzbuzz", fizzBuzzProgram.getFizzBuzz(10005));
    }
}
