package com.globalx.namesorter;

/**
 * The type Name.
 */
class Name {
  private String[] givenNames;
  private String lastName;

    /**
     * Instantiates a new Name.
     *
     * @param givenNames the given names
     * @param lastName   the last name
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


}
