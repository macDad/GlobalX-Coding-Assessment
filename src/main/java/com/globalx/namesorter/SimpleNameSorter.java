package com.globalx.namesorter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/** The type Simple name sorter. */
class SimpleNameSorter implements NameSorter {

  @Override
  public List<Name> sortNames(List<Name> names) {
    names.sort(Comparator.comparing(Name::getLastName).thenComparing(this::compareGivenNames));
    return names;
  }

  private int compareGivenNames(Name n1, Name n2) {
    String[] n1GivenNames = n1.getGivenNames();
    String[] n2GivenNames = n2.getGivenNames();
    int minLength = Math.min(n1GivenNames.length, n2GivenNames.length);
    return IntStream.range(0, minLength)
        .map(i -> n1GivenNames[i].compareTo(n2GivenNames[i]))
        .filter(cmp -> cmp != 0)
        .findFirst()
        .orElse(0);
  }
}
