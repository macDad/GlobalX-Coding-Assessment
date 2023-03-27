package com.globalx.namesorter;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The type File based name writer test.
 */
public class FileBasedNameWriterTest {

    private static final String FILENAME = "test-output.txt";

  /**
   * Sets up.
   *
   * @throws IOException the io exception
   */
  @Before
  public void setUp() throws IOException {
    Files.deleteIfExists(Paths.get(FILENAME));
  }

  /**
   * Tear down.
   *
   * @throws IOException the io exception
   */
  @After
  public void tearDown() throws IOException {
    Files.deleteIfExists(Paths.get(FILENAME));
  }

  /**
   * Test write names.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testWriteNames() throws IOException {
    FileBasedNameWriter writer = new FileBasedNameWriter(FILENAME);
    List<Name> names = new ArrayList<>();
    names.add(new Name(new String[] {"John"}, "Doe"));
    names.add(new Name(new String[] {"Jane"}, "Smith"));
    names.add(new Name(new String[] {"Adam, John"}, "Doe"));
    writer.writeNames(names);

    Path path = Paths.get(FILENAME);
    List<String> lines = Files.readAllLines(path);

        assertEquals(3, lines.size());
        assertEquals("Adam John Doe", lines.get(0));
        assertEquals("John Doe", lines.get(1));
        assertEquals("Jane Smith", lines.get(2));
    }

}
