package com.epam.task10.main.data;

public interface DataReader {
    String read(String fileName) throws DataException;
}