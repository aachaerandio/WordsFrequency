package com.aachaerandio.wordsfrequency;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void should_open_file_successfully() throws Exception {
        //Given
        String fileName = "test_one_line.txt";

        //When
        FileReader fileReader = FileReader.create(fileName);

        //Then
        assertNotNull(fileReader);
        assertTrue(true);

        fileReader.close();
    }

    @Test
    public void should_read_line_successfully() throws Exception {
        FileReader fileReader = FileReader.create("test_one_line.txt");
        assertNotNull(fileReader);
        String line = fileReader.readLine();
        assertEquals("hello world", line);
        fileReader.close();
    }

    @Test
    public void should_read_empty_file_successfully() throws Exception {
        FileReader fileReader = FileReader.create("test_empty.txt");
        assertNotNull(fileReader);
        String line = fileReader.readLine();
        assertNull(line);
        fileReader.close();
    }

    @Test
    public void should_be_null_when_file_does_not_exist() throws Exception {
        assertNull(FileReader.create("test_not_exist.txt"));
    }

    @Test
    public void should_return_lines_with_at_least_one_word() throws Exception {
        FileReader fileReader = FileReader.create("test_ignorable_content.txt");
        assertNotNull(fileReader);
        String line = fileReader.readLine();
        assertEquals("hello world!", line);
        fileReader.close();
    }

}