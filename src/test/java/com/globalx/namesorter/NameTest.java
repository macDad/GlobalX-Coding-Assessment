package com.globalx.namesorter;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


/**
 * The type Name test.
 */
class NameTest {
    /**
     * The Name.
     */
    Name name = new Name(new String[]{"John"}, "lastName");

    /**
     * Test constructor.
     */
    @Test
    public void testConstructor() {
        Name name = new Name(new String[]{"John"}, "Doe");
        assertArrayEquals(new String[]{"John"}, name.getGivenNames());
        assertEquals("Doe", name.getLastName());
    }

    /**
     * Test get given names.
     */
    @Test
    void testGetGivenNames() {
        String[] result = name.getGivenNames();
        assertArrayEquals(new String[]{"John"}, result);
    }

    /**
     * Test get full name.
     */
    @Test
    void testGetFullName() {
        Name name = new Name(new String[]{"John"}, "Doe");
        assertEquals("John Doe", name.getFullName());

        name = new Name(new String[]{"John", "Adam"}, "Doe");
        assertEquals("John Adam Doe", name.getFullName());
    }

}

