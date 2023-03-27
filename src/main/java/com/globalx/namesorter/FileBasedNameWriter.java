package com.globalx.namesorter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The type File based name writer.
 */
class FileBasedNameWriter implements NameWriter {

    /**
     * @param names          the names
     * @param outputFileName the output file name
     * @throws IOException
     */
    @Override
    public void writeNames(List<Name> names, String outputFileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Name name : names) {
                writer.write(name.getFullName());
                writer.newLine();
            }
        }
    }
}