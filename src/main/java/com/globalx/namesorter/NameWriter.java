package com.globalx.namesorter;

import java.io.IOException;
import java.util.List;

/**
 * The interface Name writer.
 */
interface NameWriter {
    /**
     * Write names.
     *
     * @param names          the names
     * @param outputFileName the output file name
     * @throws IOException the io exception
     */
    void writeNames(List<Name> names, String outputFileName) throws IOException;
}