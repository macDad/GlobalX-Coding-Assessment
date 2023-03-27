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
    if (args.length != 1) {
      System.err.println("Usage: java NameSorterApp <input-file>");
      System.exit(1);
    }
    String inputFileName = args[0];
    String outputFileName = "sorted-names-list.txt";

    NameReader reader = new FileBasedNameReader(inputFileName);
    NameSorter sorter = new SimpleNameSorter();
    NameWriter writer = new FileBasedNameWriter(outputFileName);

    try {
      NameSorterController controller = new NameSorterController(reader, sorter, writer);
      List<Name> sortedNames = controller.sortNames();
      System.out.println("Sorted names:");
      sortedNames.stream().map(Name::getFullName).forEach(System.out::println);
    } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
            System.exit(1);
        }
    }
}
