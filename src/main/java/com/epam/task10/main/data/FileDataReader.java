package com.epam.task10.main.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader implements DataReader {

    private static final String SYMBOL_NEW_LINE = "\n";

    @Override
    public String read(String fileName) throws DataException {
        Path filePath = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(filePath);
            return String.join(SYMBOL_NEW_LINE, lines);
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }
}