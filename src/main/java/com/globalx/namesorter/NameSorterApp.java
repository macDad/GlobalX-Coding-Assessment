package com.globalx.namesorter;

import java.io.IOException;
import java.util.List;

/**
 * The type Name sorter app.
 */
public class NameSorterApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String inputFileName = "";
        if (args.length != 1) {
            System.err.println("Usage: java NameSorterApp <input-file>");
            // inputFileName = "unsorted-names-list.txt";

            System.exit(1);
        }

        inputFileName = args[0];
        String outputFileName = "sorted-names-list.txt";

        NameReader reader = new FileBasedNameReader(inputFileName);
        NameSorter sorter = new SimpleNameSorter();
        NameWriter writer = new FileBasedNameWriter();

        try {
            List<Name> names = reader.readNames();
            names = sorter.sortNames(names);
            writer.writeNames(names, outputFileName);

            System.out.println("Sorted names:");
            for (Name name : names) {
                System.out.println(name.getFullName());
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
            System.exit(1);
        }
    }
}
