package com.globalx.namesorter;

import org.junit.jupiter.api.Test;

/**
 * The type Name sorter app test.
 */
class NameSorterAppTest {

    /**
     * Test main.
     */
    @Test
    void testMain() {
        NameSorterApp.main(new String[]{"unsorted-names-list.txt"});
    }
}

