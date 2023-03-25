package com.globalx.namesorter;

import static org.junit.Assert.*;
import org.junit.Test;


class NameTest {
    Name name = new Name(new String[]{"John"}, "lastName");

    @Test
    public void testConstructor() {
        Name name = new Name(new String[]{"John"}, "Doe");
        assertArrayEquals(new String[]{"John"}, name.getGivenNames());
        assertEquals("Doe", name.getLastName());
    }

    @Test
    void testGetGivenNames() {
        String[] result = name.getGivenNames();
        assertArrayEquals(new String[]{"John"}, result);
    }

    @Test
    void testGetFullName() {
        Name name = new Name(new String[]{"John"}, "Doe");
        assertEquals("John Doe", name.getFullName());

        name = new Name(new String[]{"John", "Adam"}, "Doe");
        assertEquals("John Adam Doe", name.getFullName());
    }

}

