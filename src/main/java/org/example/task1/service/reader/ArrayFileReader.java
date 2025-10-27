package org.example.task1.service.reader;

import org.example.task1.exception.ArrayException;

public interface ArrayFileReader {
    public int[] readFile(String path) throws ArrayException;

}
