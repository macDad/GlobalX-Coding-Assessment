package com.globalx.namesorter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/** The type Simple name sorter test. */
class SimpleNameSorterTest {
  private final NameSorter sorter = new SimpleNameSorter();

  /** Test sort names with multiple given names. */
  @Test
  void testSortNamesWithMultipleGivenNames() {
    Name name1 = new Name(new String[] {"Catherine"}, "Johnson");
    Name name2 = new Name(new String[] {"John"}, "Doe");
    Name name3 = new Name(new String[] {"Alice", "Johnson"}, "Lee");
    Name name4 = new Name(new String[] {"Bob", "Johnson"}, "Lee");
    List<Name> names = new ArrayList<>(Arrays.asList(name1, name2, name3, name4));

    List<Name> sortedNames = sorter.sortNames(names);

    assertEquals(Arrays.asList(name2, name1, name3, name4).toString(), sortedNames.toString());
  }

  /** Test sort names with same last name. */
  @Test
  void testSortNamesWithSameLastName() {
    Name name1 = new Name(new String[] {"Catherine"}, "Johnson");
    Name name2 = new Name(new String[] {"John"}, "Johnson");
    Name name3 = new Name(new String[] {"Alice"}, "Johnson");
    Name name4 = new Name(new String[] {"Bob"}, "Johnson");
    List<Name> names = new ArrayList<>(Arrays.asList(name1, name2, name3, name4));

    List<Name> sortedNames = sorter.sortNames(names);

    assertIterableEquals(Arrays.asList(name3, name4, name1, name2), sortedNames);
  }

  /** Test sort names with empty list. */
  @Test
  void testSortNamesWithEmptyList() {
    List<Name> names = new ArrayList<>();

    List<Name> sortedNames = sorter.sortNames(names);

    assertIterableEquals(names, sortedNames);
  }

  /** Test sort names with one name. */
  @Test
  void testSortNamesWithOneName() {
    SimpleNameSorter sorter = new SimpleNameSorter();
    List<Name> unsortedList = Arrays.asList(new Name(new String[] {"John"}, "Smith"));
    List<Name> actualList = sorter.sortNames(unsortedList);
    assertIterableEquals(unsortedList, actualList);
  }

  /** Test sort names with same names. */
  @Test
  void testSortNamesWithSameNames() {
    SimpleNameSorter sorter = new SimpleNameSorter();
    Name[] unsortedNames = {
      new Name(new String[] {"John"}, "Smith"),
      new Name(new String[] {"John"}, "Smith"),
      new Name(new String[] {"John"}, "Smith")
    };
    List<Name> unsortedList = Arrays.asList(unsortedNames);
    List<Name> actualList = sorter.sortNames(unsortedList);
    assertIterableEquals(unsortedList, actualList);
  }

  /** Test sort names with different lengths. */
  @Test
  void testSortNamesWithDifferentLengths() {
    SimpleNameSorter sorter = new SimpleNameSorter();
    Name[] unsortedNames = {
      new Name(new String[] {"John"}, "Smith"),
      new Name(new String[] {"Adam", "Smith"}, "Bob"),
      new Name(new String[] {"Bob"}, "Johnson"),
      new Name(new String[] {"Adam", "Johnson"}, "Charlie"),
      new Name(new String[] {"Alice", "Jones", "David"}, "Eric")
    };
    List<Name> unsortedList = Arrays.asList(unsortedNames);
    List<Name> expectedList = new ArrayList<>(unsortedList);
    expectedList.sort(Comparator.comparing(Name::getLastName));

    List<Name> actualList = sorter.sortNames(unsortedList);
    assertIterableEquals(expectedList, actualList);
  }
  /** Sort names should sort list by last name then given names. */
  @Test
  void sortNames_shouldSortListByLastNameThenGivenNames() {

    Name alice = new Name(new String[] {"Alice"}, "Smith");
    Name bob = new Name(new String[] {"Bob"}, "Johnson");
    Name carol = new Name(new String[] {"Carol"}, "Williams");
    Name david = new Name(new String[] {"David"}, "Johnson");
    Name erica = new Name(new String[] {"Erica"}, "Davis");
    Name frank = new Name(new String[] {"Frank"}, "Williams");
    List<Name> names = new ArrayList<>(Arrays.asList(bob, alice, erica, carol, david, frank));
    SimpleNameSorter sorter = new SimpleNameSorter();
    List<Name> sortedNames = sorter.sortNames(names);
    assertEquals(Arrays.asList(erica, bob, david, alice, carol, frank), sortedNames);
  }

  /** Sort names should handle empty list. */
  @Test
  void sortNames_shouldHandleEmptyList() {

    List<Name> names = new ArrayList<>();
    SimpleNameSorter sorter = new SimpleNameSorter();
    List<Name> sortedNames = sorter.sortNames(names);
    assertEquals(new ArrayList<Name>(), sortedNames);
  }

  /** Sort names should handle list with one element. */
  @Test
  void sortNames_shouldHandleListWithOneElement() {
    Name alice = new Name(new String[] {"Alice"}, "Smith");
    List<Name> names = new ArrayList<>(Arrays.asList(alice));
    SimpleNameSorter sorter = new SimpleNameSorter();
    List<Name> sortedNames = sorter.sortNames(names);
    assertEquals(Arrays.asList(alice), sortedNames);
  }

  /** Sort names should handle list with two equal elements. */
  @Test
  void sortNames_shouldHandleListWithTwoEqualElements() {
    Name alice = new Name(new String[] {"Alice"}, "Smith");
    Name bob = new Name(new String[] {"Bob"}, "Smith");
    List<Name> names = new ArrayList<>(Arrays.asList(alice, bob));
    SimpleNameSorter sorter = new SimpleNameSorter();
    List<Name> sortedNames = sorter.sortNames(names);
    assertEquals(Arrays.asList(alice, bob), sortedNames);
  }

  /** Sort names should handle list with two different elements. */
  @Test
  void sortNames_shouldHandleListWithTwoDifferentElements() {
    Name alice = new Name(new String[] {"Alice"}, "Smith");
    Name bob = new Name(new String[] {"Bob"}, "Johnson");
    List<Name> names = new ArrayList<>(Arrays.asList(alice, bob));
    SimpleNameSorter sorter = new SimpleNameSorter();
    List<Name> sortedNames = sorter.sortNames(names);
    assertEquals(Arrays.asList(bob, alice), sortedNames);
  }

  /** Sort names should handle list with three elements. */
  @Test
  void sortNames_shouldHandleListWithThreeElements() {
    Name alice = new Name(new String[] {"Alice"}, "Smith");
    Name bob = new Name(new String[] {"Bob"}, "Johnson");
    Name carol = new Name(new String[] {"Carol"}, "Williams");
    List<Name> names = new ArrayList<>(Arrays.asList(bob, alice, carol));
    SimpleNameSorter sorter = new SimpleNameSorter();
    List<Name> sortedNames = sorter.sortNames(names);
    assertEquals(Arrays.asList(bob, alice, carol), sortedNames);
  }
  /** Test sort names duplicate names. */
  @Test
  public void testSortNames_duplicateNames() {
    List<Name> names =
        Arrays.asList(
            new Name(new String[] {"John"}, "Doe"),
            new Name(new String[] {"Jane"}, "Doe"),
            new Name(new String[] {"John"}, "Doe"),
            new Name(new String[] {"Alice"}, "Smith"));
    List<Name> expected =
        Arrays.asList(
            new Name(new String[] {"Jane"}, "Doe"),
            new Name(new String[] {"John"}, "Doe"),
            new Name(new String[] {"John"}, "Doe"),
            new Name(new String[] {"Alice"}, "Smith"));
    List<Name> sortedNames = sorter.sortNames(names);
    assertEquals(names.size(), sortedNames.size());
    assertEquals(expected.toString(), sortedNames.toString());
  }
  /** Test sort names different number of given names. */
  @Test
  public void testSortNames_differentNumberOfGivenNames() {
    List<Name> names =
        Arrays.asList(
            new Name(new String[] {"Alice", "Smith", "Wonders"}, "Super"),
            new Name(new String[] {"Jane", "Doe"}, "Mary"),
            new Name(new String[] {"John"}, "Doe"));
    List<Name> expected =
        Arrays.asList(
            new Name(new String[] {"John"}, "Doe"),
            new Name(new String[] {"Jane", "Doe"}, "Mary"),
            new Name(new String[] {"Alice", "Smith", "Wonders"}, "Super"));
    List<Name> sortedNames = sorter.sortNames(names);
    assertEquals(names.size(), sortedNames.size());
    assertThat("optional message printed on fails", expected, is(sortedNames));
  }
  /** Test sort names empty list. */
  @Test
  public void testSortNames_emptyList() {
    List<Name> names = Collections.emptyList();
    List<Name> sortedNames = sorter.sortNames(names);
    assertTrue(sortedNames.isEmpty());
  }
}
