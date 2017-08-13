package com.aachaerandio.wordsfrequency;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void should_open_file_successfully() throws Exception {
        FileReader fileReader = new FileReader("test_one_line.txt");
        assertTrue(true);
        fileReader.close();
    }

    @Test
    public void should_read_line_successfully() throws Exception {
        FileReader fileReader = new FileReader("test_one_line.txt");
        String line = fileReader.readLine();
        assertEquals("hello world", line);
        fileReader.close();
    }

    @Test
    public void should_read_empty_file_successfully() throws Exception {
        FileReader fileReader = new FileReader("test_empty.txt");
        String line = fileReader.readLine();
        assertNull(line);
        fileReader.close();
    }

    @Test(expected = FileNotFoundException.class)
    public void should_throw_exception_when_file_does_not_exist() throws Exception {
        new FileReader("test_not_exist.txt");
    }

    @Test
    public void should_return_lines_with_at_least_one_word() throws Exception {
        FileReader fileReader = new FileReader("test_ignorable_content.txt");
        String line = fileReader.readLine();
        assertEquals("hello world", line);
        fileReader.close();
    }

}