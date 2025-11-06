package org.example.task1.parser;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;


public interface ArrayEntityParser {
    public ArrayEntity parseEntityFromString(String line) throws ArrayException;
}