package com.globalx.namesorter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/** The type File based name writer. */
class FileBasedNameWriter implements NameWriter {
  private final String outputFileName;

  /**
   * Instantiates a new File based name writer.
   *
   * @param outputFileName the output file name
   */
  public FileBasedNameWriter(String outputFileName) {
    this.outputFileName = outputFileName;
  }

  @Override
  public void writeNames(List<Name> names) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
      for (Name name : names) {
        writer.write(name.getFullName());
        writer.newLine();
      }
    }
  }
}
