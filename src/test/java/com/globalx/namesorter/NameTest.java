package com.globalx.namesorter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** The type Name test. */
public class NameTest {
  /** The Name. */
  Name name = new Name(new String[] {"John"}, "lastName");

  /** Test constructor. */
  @Test
  public void testConstructor() {
        Name name = new Name(new String[]{"John"}, "Doe");
        assertArrayEquals(new String[]{"John"}, name.getGivenNames());
        assertEquals("Doe", name.getLastName());
    }

  /** Test get given names. */
  @Test
  public void testGetGivenNames() {
    String[] result = name.getGivenNames();
    assertArrayEquals(new String[] {"John"}, result);
  }

  /** Test get full name. */
  @Test
  public void testGetFullName() {
    Name name = new Name(new String[] {"John"}, "Doe");
    assertEquals("John Doe", name.getFullName());

    name = new Name(new String[] {"John", "Adam"}, "Doe");
    assertEquals("John Adam Doe", name.getFullName());
  }
}

