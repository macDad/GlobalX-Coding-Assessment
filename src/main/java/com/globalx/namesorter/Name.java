package com.globalx.namesorter;

import java.util.Arrays;
import java.util.Objects;

/** The type Name. */
class Name {
  private final String[] givenNames;
  private final String lastName;

  /**
   * Instantiates a new Name.
   *
   * @param givenNames the given names
   * @param lastName the last name
   */
  public Name(String[] givenNames, String lastName) {
    this.givenNames = givenNames;
    this.lastName = lastName;
  }

  /**
   * Get given names string [ ].
   *
   * @return the string [ ]
   */
  public String[] getGivenNames() {
    return givenNames;
  }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Gets full name.
   *
   * @return the full name
   */
  public String getFullName() {
    return String.join(" ", givenNames) + " " + lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Name name)) return false;
    return Arrays.equals(getGivenNames(), name.getGivenNames())
        && Objects.equals(getLastName(), name.getLastName());
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append("Name{")
        .append("givenNames=")
        .append(Arrays.toString(givenNames))
        .append(", lastName='")
        .append(lastName)
        .append('\'')
        .append('}')
        .toString();
  }
}
