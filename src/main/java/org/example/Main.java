package org.example;

import java.util.List;

public class Main {
    private static final StringSorter sorter = new StringSorter();
    private static List<String> unsortedStrings;
    private static String exceptionChar;
    private static List<String> sortedStrings;

    public static void main(String[] args) {
        unsortedStrings = List.of("apple", "banana", "grape", "avocado", "cherry");
        exceptionChar = "a";

        sortedStrings = sorter.sortStrings(unsortedStrings, exceptionChar);

        sortedStrings.forEach(System.out::println);
    }
}
