package org.example.task1.io.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.exception.ArrayException;
import org.example.task1.io.reader.ArrayFileReader;
import org.example.task1.validator.impl.ArrayValidationService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrayReaderService implements ArrayFileReader {
    public static final Logger logger = LogManager.getLogger(ArrayReaderService.class);

    public List<String> readFromFile(String filepath) throws ArrayException {
        ArrayValidationService validator = new ArrayValidationService();
        List<String> list = new ArrayList<>();

        if (validator.isValidFilePath(filepath)) {
            File file = new File(filepath);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
                logger.info("The file has been read successfully. Lines read: " + list.size());
            } catch (IOException e) {
                logger.warn("Error while reading file " + filepath);
                throw new ArrayException("File not found");
            }
        } else {
            throw new ArrayException("Invalid file path");
        }
        return list;
    }
}