package org.example.task1.service.parser;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.parser.impl.ArrayParserService;

import java.nio.file.Path;
import java.util.List;

public interface ArrayEntityParser {
    public ArrayEntity parseEntityFromString(String line) throws ArrayException;
}