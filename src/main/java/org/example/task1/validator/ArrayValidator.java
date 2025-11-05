package org.example.task1.validator;

import org.example.task1.exception.ArrayException;


public interface ArrayValidator {

    boolean isLineValid(String line) throws ArrayException;

    default boolean isValidId(String id) {return true;}

    default boolean isValidNumber(int number) {return true;}

    default boolean isValidArray(int[] array) {return true;}

    default boolean isValidFilePath(){return true;}

}