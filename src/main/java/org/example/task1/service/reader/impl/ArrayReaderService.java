package org.example.task1.service.reader.impl;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.service.parser.impl.ArrayParserService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrayReaderService {
    
    public static List<ArrayEntity> readFromFile(String filename) throws IOException {
        List<ArrayEntity> arrays = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.isBlank()) continue;
                try {
                    String[] parts = line.split(":", 2);
                    if (parts.length == 2) {
                        String id = parts[0].trim();
                        String data = parts[1].trim();
                        ArrayEntity entity = ArrayParserService.parseLine(ArrayEntity);
                        arrays.add(entity);
                    }
                } catch (Exception e) {
                    System.err.println("Error parsing line " + lineNumber + ": " + line);
                }
            }
        }
        return arrays;
    }
}