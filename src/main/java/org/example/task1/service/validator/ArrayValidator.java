package org.example.task1.service.validator;

import org.example.task1.exception.ArrayException;


public interface ArrayValidator {

    boolean isLineValid(String line) throws ArrayException;

    // Дополнительные методы (опционально)
    default boolean isValidId(String id) {
        return true; // Базовая реализация
    }

    default boolean isValidNumber(int number) {
        return true; // Базовая реализация
    }

    default boolean isValidArray(int[] array) {
        return true; // Базовая реализация
    }

}