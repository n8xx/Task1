package org.example.task1.service.reader;

import org.example.task1.exception.ArrayException;

import java.util.List;

public interface ArrayFileReader {
    public  List<String> readFromFile(String path) throws ArrayException;

}
