package org.example;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StringSorter {

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
