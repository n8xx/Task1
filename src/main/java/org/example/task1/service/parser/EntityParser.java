package org.example.task1.service.parser;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.parser.impl.ArrayParserService;
import org.example.task1.service.validator.impl.ArrayValidationService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface EntityParser {
    public List<ArrayEntity> parseFromFile(Path filePath) throws ArrayException;
    public ArrayEntity parseLine(String line, int lineNumber) throws ArrayException;
    public List<ArrayEntity> parseFromFileSkipInvalid(Path filePath) throws ArrayException;
    public void saveToFile(List<ArrayEntity> entities, Path filePath) throws ArrayException;
}