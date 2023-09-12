package sorter;

import java.util.ArrayList;
import java.util.Collections;
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

        List<String> sortedStrings;
        List<String> stringsWithPrefix = new ArrayList<>();
        List<String> stringsWithoutPrefix = new ArrayList<>();

        for (String string : unsortedStrings) {
            if (string == null) {
                System.out.println("The null value of the element was ignored");
                continue;
            }

            if (string.startsWith(exceptionChar)) {
                stringsWithPrefix.add(string);
            } else {
                stringsWithoutPrefix.add(string);
            }
        }

        sortedStrings = stringsWithoutPrefix.stream()
                .sorted()
                .collect(Collectors.toList());

        stringsWithPrefix.sort(Collections.reverseOrder());
        sortedStrings.addAll(stringsWithPrefix);

        return sortedStrings;
    }
}
