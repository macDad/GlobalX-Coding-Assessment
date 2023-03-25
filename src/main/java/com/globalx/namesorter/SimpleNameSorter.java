package com.globalx.namesorter;

import java.util.Comparator;
import java.util.List;

/**
 * The type Simple name sorter.
 */
class SimpleNameSorter implements NameSorter {

    /**
     * @param names the names
     * @return
     */
    @Override
    public List<Name> sortNames(List<Name> names) {
        names.sort(Comparator.comparing(Name::getLastName).thenComparing((n1, n2) -> {
            for (int i = 0; i < Math.min(n1.getGivenNames().length, n2.getGivenNames().length); i++) {
                int cmp = n1.getGivenNames()[i].compareTo(n2.getGivenNames()[i]);
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        }));
        return names;
    }
}