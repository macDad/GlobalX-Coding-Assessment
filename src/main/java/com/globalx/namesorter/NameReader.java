package com.globalx.namesorter;

import java.io.IOException;
import java.util.List;

/**
 * The interface Name reader.
 */
interface NameReader {
    /**
     * Read names list.
     *
     * @return the list
     * @throws IOException the io exception
     */
    List<Name> readNames() throws IOException;
}