package com.globalx.namesorter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Simple name sorter test.
 */
class SimpleNameSorterTest {
    /**
     * The Simple name sorter.
     */
    SimpleNameSorter simpleNameSorter = new SimpleNameSorter();

    /**
     * Test sort names.
     */
    @Test
    void testSortNames() {
        // Arrange
        SimpleNameSorter sorter = new SimpleNameSorter();
        Name[] unsortedNames = {
                new Name(new String[]{"John"}, "Smith"),
                new Name(new String[]{"Adam"}, "Smith"),
                new Name(new String[]{"Bob"}, "Johnson"),
                new Name(new String[]{"Adam"}, "Johnson"),
                new Name(new String[]{"Alice"}, "Jones")
        };
        List<Name> unsortedList = Arrays.asList(unsortedNames);
        List<Name> expectedList = new ArrayList<>(unsortedList);
        expectedList.sort(Comparator.comparing(Name::getLastName).thenComparing(Name::getGivenNames));

        // Act
        List<Name> actualList = sorter.sortNames(unsortedList);

        // Assert
        assertIterableEquals(expectedList, actualList);
    }

    /**
     * Test sort names with empty list.
     */
    @Test
    void testSortNamesWithEmptyList() {
        // Arrange
        SimpleNameSorter sorter = new SimpleNameSorter();
        List<Name> unsortedList = new ArrayList<>();

        // Act
        List<Name> actualList = sorter.sortNames(unsortedList);

        // Assert
        assertTrue(actualList.isEmpty());
    }

    /**
     * Test sort names with one name.
     */
    @Test
    void testSortNamesWithOneName() {
        // Arrange
        SimpleNameSorter sorter = new SimpleNameSorter();
        List<Name> unsortedList = List.of(new Name(new String[]{"John"}, "Smith"));

        // Act
        List<Name> actualList = sorter.sortNames(unsortedList);

        // Assert
        assertIterableEquals(unsortedList, actualList);
    }

    /**
     * Test sort names with same names.
     */
    @Test
    void testSortNamesWithSameNames() {
        // Arrange
        SimpleNameSorter sorter = new SimpleNameSorter();
        Name[] unsortedNames = {
                new Name(new String[]{"John"}, "Smith"),
                new Name(new String[]{"John"}, "Smith"),
                new Name(new String[]{"John"}, "Smith")
        };
        List<Name> unsortedList = Arrays.asList(unsortedNames);

        // Act
        List<Name> actualList = sorter.sortNames(unsortedList);

        // Assert
        assertIterableEquals(unsortedList, actualList);
    }

    /**
     * Test sort names with different lengths.
     */
    @Test
    void testSortNamesWithDifferentLengths() {
        // Arrange
        SimpleNameSorter sorter = new SimpleNameSorter();
        Name[] unsortedNames = {
                new Name(new String[]{"John"}, "Smith"),
                new Name(new String[]{"Adam", "Smith"}, "Bob"),
                new Name(new String[]{"Bob"}, "Johnson"),
                new Name(new String[]{"Adam", "Johnson"}, "Charlie"),
                new Name(new String[]{"Alice", "Jones", "David"}, "Eric")
        };
        List<Name> unsortedList = Arrays.asList(unsortedNames);
        List<Name> expectedList = new ArrayList<>(unsortedList);
        expectedList.sort(Comparator.comparing(Name::getLastName).thenComparing(Name::getGivenNames));

        // Act
        List<Name> actualList = sorter.sortNames(unsortedList);

        // Assert
        assertIterableEquals(expectedList, actualList);
    }
}

