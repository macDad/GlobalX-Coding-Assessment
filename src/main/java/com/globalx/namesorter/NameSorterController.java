package com.globalx.namesorter;

import java.io.IOException;
import java.util.List;

/** The type Name sorter controller. */
public class NameSorterController {
  private final NameReader reader;
  private final NameSorter sorter;
  private final NameWriter writer;

  /**
   * Instantiates a new Name sorter controller.
   *
   * @param reader the reader
   * @param sorter the sorter
   * @param writer the writer
   */
  public NameSorterController(NameReader reader, NameSorter sorter, NameWriter writer) {
    this.reader = reader;
    this.sorter = sorter;
    this.writer = writer;
  }

  /**
   * Sort names list.
   *
   * @return the list
   * @throws IOException the io exception
   * @param outputFileName the output file name
   */
  public List<Name> sortNames() throws IOException {
    List<Name> names = reader.readNames();
    List<Name> sortedNames = sorter.sortNames(names);
    writer.writeNames(sortedNames);
    return sortedNames;
  }
}
