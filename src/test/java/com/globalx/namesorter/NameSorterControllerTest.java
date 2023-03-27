package com.globalx.namesorter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/** The type Name sorter controller test. */
public class NameSorterControllerTest {
  @Mock private NameReader mockReader;
  @Mock private NameSorter mockSorter;
  @Mock private NameWriter mockWriter;
  private NameSorterController controller;

  /** Sets up. */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    controller = new NameSorterController(mockReader, mockSorter, mockWriter);
  }

  /**
   * Test sort names.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testSortNames() throws IOException {
    List<Name> inputNames =
        Arrays.asList(
            new Name(new String[] {"John"}, "Doe"), new Name(new String[] {"Jane"}, "Doe"));
    List<Name> expectedOutput =
        Arrays.asList(
            new Name(new String[] {"Jane"}, "Doe"), new Name(new String[] {"John"}, "Doe"));
    when(mockReader.readNames()).thenReturn(inputNames);
    when(mockSorter.sortNames(inputNames)).thenReturn(expectedOutput);

    List<Name> actualOutput = controller.sortNames();

    assertEquals(expectedOutput, actualOutput);
    verify(mockWriter).writeNames(expectedOutput);
  }

  /**
   * Test sort names empty list.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testSortNames_emptyList() throws IOException {
    List<Name> inputNames = Collections.emptyList();
    when(mockReader.readNames()).thenReturn(inputNames);
    assertDoesNotThrow(() -> controller.sortNames());
  }

  /**
   * Test sort names null output file name.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testSortNames_nullOutputFileName() throws IOException {

    List<Name> inputNames =
        Arrays.asList(
            new Name(new String[] {"John"}, "Doe"), new Name(new String[] {"Jane"}, "Doe"));
    List<Name> expectedOutput =
        Arrays.asList(
            new Name(new String[] {"Jane"}, "Doe"), new Name(new String[] {"John"}, "Doe"));
    when(mockReader.readNames()).thenReturn(inputNames);
    when(mockSorter.sortNames(inputNames)).thenReturn(expectedOutput);
    assertDoesNotThrow(() -> controller.sortNames());
  }
}
