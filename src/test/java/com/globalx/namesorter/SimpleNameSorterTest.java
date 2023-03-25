package com.globalx.namesorter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SimpleNameSorterTest {
    SimpleNameSorter simpleNameSorter = new SimpleNameSorter();

    @Test
    void testSortNames() {
        List<Name> result = simpleNameSorter.sortNames(List.of(new Name(new String[]{"John"}, "Doe")));
        Assertions.assertEquals(List.of(new Name(new String[]{"John"}, "Doe")), result);
    }
}

