package org.example.task1.service.parser.impl;


import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.validator.impl.ArrayValidationService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayParserService {
    private final ArrayValidationService validationService;

    public ArrayParserService(ArrayValidationService validationService) {
        this.validationService = validationService;
    }

    /**
     * Парсит все строки из файла в список ArrayEntity с валидацией
     */
    public List<ArrayEntity> parseFromFile(Path filePath) throws ArrayException, IOException {
        if (!Files.exists(filePath)) {
            throw new ArrayException("File not found: " + filePath);
        }

        List<String> lines = Files.readAllLines(filePath);
        List<ArrayEntity> entities = new ArrayList<>();

        for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
            String line = lines.get(lineNumber).trim();

            // Пропускаем пустые строки и комментарии
            if (line.isEmpty() || line.startsWith("#") || line.startsWith("//")) {
                continue;
            }

            try {
                ArrayEntity entity = parseLine(line, lineNumber + 1);
                if (entity != null) {
                    entities.add(entity);
                }
            } catch (ArrayException e) {
                System.err.println("Error parsing line " + (lineNumber + 1) + ": " + e.getMessage());
                // Можно добавить логику для обработки ошибок (пропустить, использовать значения по умолчанию и т.д.)
            }
        }

        return entities;
    }

    /**
     * Парсит одну строку в ArrayEntity с валидацией
     */
    public ArrayEntity parseLine(String line, int lineNumber) throws ArrayException {
        if (line == null || line.trim().isEmpty()) {
            throw new ArrayException("Empty line"+lineNumber);
        }

        String[] parts = line.split(";", 2);
        if (parts.length != 2) {
            throw new ArrayException("Invalid format. Expected: 'id:numbers'"+ lineNumber);
        }

        String id = parts[0].trim();
        String numbersPart = parts[1].trim();

        // Валидация ID
        if (!validationService.isValidId(id)) {
            throw new ArrayException("Invalid ID: " + id+ " line: " +lineNumber);
        }

        int[] array;
        if (numbersPart.isEmpty()) {
            array = new int[0];
        } else {
            String[] numberStrings = numbersPart.split(",");
            array = new int[numberStrings.length];

            for (int i = 0; i < numberStrings.length; i++) {
                try {
                    int number = Integer.parseInt(numberStrings[i].trim());

                    // Валидация числа
                    if (!validationService.isValidNumber(number)) {
                        throw new ArrayException("Invalid number: " + number + " line: " + lineNumber);
                    }

                    array[i] = number;
                } catch (NumberFormatException e) {
                    throw new ArrayException("Invalid number format: " + numberStrings[i]+ " line: " + lineNumber +  e);
                }
            }
        }

        // Валидация всего массива
        if (!validationService.isValidArray(array)) {
            throw new ArrayException("Array validation failed" + " line: " + lineNumber);
        }

        return new ArrayEntity(id, array);
    }

    /**
     * Парсит файл и возвращает только валидные entities, игнорируя невалидные строки
     */

    public List<ArrayEntity> parseFromFileSkipInvalid(Path filePath) throws ArrayException, IOException {
        if (!Files.exists(filePath)) {
            throw new ArrayException("File not found: " + filePath);
        }

        List<String> lines = Files.readAllLines(filePath);
        List<ArrayEntity> entities = new ArrayList<>();

        for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
            String line = lines.get(lineNumber).trim();

            if (line.isEmpty() || line.startsWith("#") || line.startsWith("//")) {
                continue;
            }

            try {
                ArrayEntity entity = parseLine(line, lineNumber + 1);
                entities.add(entity);
            } catch (ArrayException e) {
                // Просто логируем и продолжаем
                System.err.println("Skipping invalid line " + (lineNumber + 1) + ": " + e.getMessage());
            }
        }

        return entities;
    }
}