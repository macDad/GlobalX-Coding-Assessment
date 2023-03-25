package com.globalx.namesorter;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class FileBasedNameReaderTest {
    private static final String FILENAME = "unsorted-names-list.txt";

    @Before
    public void setUp() throws IOException {
        Path path = Paths.get(FILENAME);
        List<String> lines = List.of("John Doe", "Jane Smith", "Adam John Doe");
        Files.write(path, lines);
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(FILENAME));
    }

    @Test
    public void testReadNames() throws IOException {
        FileBasedNameReader reader = new FileBasedNameReader(FILENAME);
        List<Name> names = reader.readNames();

        assertEquals(3, names.size());
        assertEquals(new Name(new String[]{"John"}, "Doe"), names.get(0));
        assertEquals(new Name(new String[]{"Jane"}, "Smith"), names.get(1));
        assertEquals(new Name(new String[]{"Adam", "John"}, "Doe"), names.get(2));
    }
}

