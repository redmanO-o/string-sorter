package org.example;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */
public class StringSorter {
    /**
     * The StringSorter class defines the contract for sorting strings based on
     * alphabetical order while skipping words that start with a specific prefix.
     *
     * Example:
     *  Input: ["apple", "banana", "grape", "avocado", "cherry"], Exception prefix: "a"
     *  Output: ["banana", "cherry", "grape", "avocado", "apple"]
     *
     *  Here, "banana", "cherry", and "grape" are sorted in alphabetical order
     *  whereas "avocado" and "apple" (that start with 'a') are sorted in reverse alphabetical order
     *  at the end of the list.
     */
    public List<String> sortStrings(List<String> unsortedStrings, String exceptionChar) {
        if (unsortedStrings.isEmpty()) {
            System.out.println("Input is empty");
            return unsortedStrings;
        }

        if (exceptionChar == null) {
            throw new IllegalArgumentException("Prefix couldn't be null");
        }

        List<String> sortedStrings = new ArrayList<>();
        Deque<String> prefixIncludeStrings = new LinkedList<>();
        List<String> prefixExcludeStrings = new ArrayList<>();

        for (String string : unsortedStrings) {
            if (string == null) {
                System.out.println("The null value of the element was ignored");
                continue;
            }

            if (string.startsWith(exceptionChar)) {
                prefixIncludeStrings.push(string);
            } else {
                prefixExcludeStrings.add(string);
            }
        }

        if (!prefixExcludeStrings.isEmpty()) {
            sortedStrings = prefixExcludeStrings.stream()
                    .sorted()
                    .collect(Collectors.toList());
        }

        if (!prefixIncludeStrings.isEmpty()) {
            sortedStrings.addAll(prefixIncludeStrings);
        }

        return sortedStrings;
    }
}
