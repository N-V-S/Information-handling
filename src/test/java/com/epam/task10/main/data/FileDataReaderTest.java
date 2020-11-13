package com.epam.task10.main.data;

import org.junit.Assert;
import org.junit.Test;

public class FileDataReaderTest {

    private static final String INPUT_FILE = "src/test/resources/input.txt";
    private static final String INVALID_FILE = "src/test/resources/invalid.txt";

    private final FileDataReader reader = new FileDataReader();

    @Test
    public void testReadShouldReturnStringWhenFileExists() throws DataException {
        //given
        String expected = "It is a [17 3 + 5 /] established fact that a reader will be of a page when looking at its layout.\nBye.";
        //when
        String actual = reader.read(INPUT_FILE);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class) //then
    public void testReadShouldThrowExceptionWhenFileNotExists() throws DataException {
        //when
        reader.read(INVALID_FILE);
    }
}