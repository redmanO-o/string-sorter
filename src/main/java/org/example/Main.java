package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {
    private static final StringSorter sorter = new StringSorter();
    private static List<String> unsortedStrings = new ArrayList<>();
    private static String exceptionChar;

    public static void main(String[] args) {
        unsortedStrings = Arrays.asList("apple", "banana", "grape", "avocado", "cherry");
        exceptionChar = "a";

        List<String> sortedStrings = sorter.sortStrings(unsortedStrings, exceptionChar);

        sortedStrings.forEach(System.out::println);
    }
}