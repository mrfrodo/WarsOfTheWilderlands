package com.frodo.wars.util;

import java.util.List;

/**
 * Problem:
 * Print the numbers from 1 to 100.
 * For multiples of 3, print "Fizz" instead of the number
 * For the multiples of 5, print "Buzz."
 * For numbers which are multiples of both 3 and 5, print "FizzBuzz."
 */
public class FizzBuzzProgram {
    public static void main(String[] args) {
        System.out.println("the fizzbuzz..");

        Integer[] ints = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50
        ).toArray(new Integer[0]);

        new FizzBuzzProgram().fizzbuzz(ints);
    }

    public void fizzbuzz(Integer[] n) {
        for (Integer i : n) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("  ==> fizzbuzz");
            }
            if (i % 3 == 0) {
                System.out.println("  ==> fizz");
            }
            if (i % 5 == 0) {
                System.out.println("  ==> buzz");
            }
            System.out.println("  ==> "+ i);
        }
    }

    public String getFizzBuzz(Integer i) {

        if (i % 3 == 0 && i % 5 == 0) {
           return "fizzbuzz";
        }
        if (i % 3 == 0) {
            return "fizz";
        }
        if (i % 5 == 0) {
            return "buzz";
        }
        return i.toString();
    }
}
