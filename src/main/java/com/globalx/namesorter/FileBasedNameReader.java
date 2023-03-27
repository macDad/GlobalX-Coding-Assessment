package com.globalx.namesorter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type File based name reader.
 */
class FileBasedNameReader implements NameReader {
    private final String inputFileName;

    /**
     * Instantiates a new File based name reader.
     *
     * @param inputFileName the input file name
     */
    public FileBasedNameReader(String inputFileName) {
        this.inputFileName = inputFileName;
    }


    /**
     * @return
     * @throws IOException
     */
    @Override
    public List<Name> readNames() throws IOException {
        List<Name> names = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        String line = reader.readLine();
        while (line != null) {
            String[] nameParts = line.trim().split("\\s+");
            if (nameParts.length >= 2 && nameParts.length <= 4) {
                String[] givenNames = Arrays.copyOfRange(nameParts, 0, nameParts.length - 1);
                String lastName = nameParts[nameParts.length - 1];
                Name name = new Name(givenNames, lastName);
                names.add(name);
            }
            line = reader.readLine();
        }
        reader.close();
        return names;
    }
}