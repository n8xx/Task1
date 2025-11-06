package org.example.task1.io.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.exception.ArrayException;
import org.example.task1.io.reader.ArrayFileReader;
import org.example.task1.validator.impl.ArrayValidationService;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class ArrayReaderService implements ArrayFileReader {
    public static final Logger logger = LogManager.getLogger(ArrayReaderService.class);


    public List<String> readFromFile(String filepath) throws ArrayException {
        ArrayValidationService validator = new ArrayValidationService();
        if (validator.isValidFilePath(filepath)) {
            List<String> list = new ArrayList<>();
            File file = new File(filepath);
            try (FileReader reader = new FileReader(file)) {
                reader.read();
            }catch(Exception e) {
                logger.warn("Error while reading file " + filepath, e);
            }

            logger.info("The file has read successfully and you have a new string array list");
            return list;
        }
        return null;
    }
}