package parameterizedtest.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class   SorterTest {

    @ParameterizedTest
    @MethodSource("ascendingTestData")
    void testAscendingSort(List<String> input, String expectedOutput) {
        Sorter sorter = new Sorter(input);
        sorter.sortAscending();
        List<String> output = sorter.getStringList();
        Assertions.assertEquals(expectedOutput, output.toString());
    }

    static Stream<Arguments> ascendingTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList("a", "b", "c", "d"), "[a, b, c, d]"),
                Arguments.of(Arrays.asList("d", "b", "a", "c"), "[a, b, c, d]"),
                Arguments.of(Arrays.asList("e", "r", "", " ", "\t", "@#$%"), "[, \t,  , @#$%, e, r]"),
                Arguments.of(new ArrayList<String>(), "[]"),
                Arguments.of(Collections.singletonList(""), "[]")
        );
    }

    @ParameterizedTest
    @MethodSource
    void testAscendingSortAgain(String testInput) {
        List<String> input = Collections.singletonList(testInput);
        Sorter sorter = new Sorter(input);
        sorter.sortAscending();
        List<String> output = sorter.getStringList();
        Assertions.assertTrue(output.containsAll(input));
    }

    static Stream<String> testAscendingSortAgain() {
        return Stream.of("a", "b", "c");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void testDescendingSort(Integer inputInteger) {
        List<String> input = Collections.singletonList(inputInteger.toString());
        Sorter sorter = new Sorter(input);
        sorter.sortAscending();
        List<String> output = sorter.getStringList();
        Assertions.assertTrue(output.containsAll(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a","b","c","d"})
    void testRandomSort(String inputString) {
        List<String> input = Collections.singletonList(inputString);
        Sorter sorter = new Sorter(input);
        sorter.sortRandom();
        List<String> output = sorter.getStringList();
        Assertions.assertTrue(output.containsAll(input));
    }

    static List<String> alternatingTestData = Arrays.asList("a", "b", "c", "d");

    @ParameterizedTest
    @FieldSource("alternatingTestData")
    void testAlternatingSort(String inputString) {
        List<String> input = Collections.singletonList(inputString);
        Sorter sorter = new Sorter(input);
        sorter.sortAlternating();
        List<String> output = sorter.getStringList();
        Assertions.assertTrue(output.containsAll(input));
    }

    static List<String> testAlternatingSortAgain = Arrays.asList("e", "f", "g", "h");

    @ParameterizedTest
    @FieldSource
    void testAlternatingSortAgain(String inputString) {
        List<String> input = Collections.singletonList(inputString);
        Sorter sorter;
        sorter = new Sorter(input);
        sorter.sortAlternating();
        List<String> output = sorter.getStringList();
        Assertions.assertTrue(output.containsAll(input));
    }
}
