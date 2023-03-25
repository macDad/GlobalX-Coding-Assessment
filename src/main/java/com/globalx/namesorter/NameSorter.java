package com.globalx.namesorter;

import java.util.List;

/**
 * The interface Name sorter.
 */
interface NameSorter {
    /**
     * Sort names list.
     *
     * @param names the names
     * @return the list
     */
    List<Name> sortNames(List<Name> names);
}
