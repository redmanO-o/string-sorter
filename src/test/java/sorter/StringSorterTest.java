package sorter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class StringSorterTest {
    private final StringSorter sorter = new StringSorter();
    private static final String RIGHT_PREFIX = "a";

    @Test
    void testSortStringsEmptyInput() {
        List<String> input = List.of();
        List<String> result = sorter.sortStrings(input, RIGHT_PREFIX);

        assertTrue(result.isEmpty());
    }

    @Test
    void testSortStringsNullPrefix() {
        List<String> input = List.of("apple", "banana", "cherry");
        String exceptionChar = null;

        assertThrows(IllegalArgumentException.class, () -> sorter.sortStrings(input, exceptionChar));
    }

    @Test
    void testSortStringsNormalInput() {
        List<String> input = List.of("apple", "banana", "grape", "avocado", "cherry");
        List<String> expected = List.of("banana", "cherry", "grape", "avocado", "apple");

        List<String> result = sorter.sortStrings(input, RIGHT_PREFIX);

        assertEquals(expected, result);
    }

    @Test
    void testSortStringsWithNullValues() {
        List<String> input = Arrays.asList("apple", null, "banana", "grape", "avocado", "cherry", null);
        List<String> expected = List.of("banana", "cherry", "grape", "avocado", "apple");

        List<String> result = sorter.sortStrings(input, RIGHT_PREFIX);

        assertEquals(expected, result);
    }
}
