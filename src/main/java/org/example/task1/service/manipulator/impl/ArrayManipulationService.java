package org.example.task1.service.manipulator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.manipulator.ArrayManipulator;
import org.example.task1.validator.impl.ArrayValidationService;


public class ArrayManipulationService implements ArrayManipulator {
    public final static Logger logger = LogManager.getLogger();
    private ArrayValidationService validator = new ArrayValidationService();
    @Override
    public void replaceByCondition(ArrayEntity arrayEntity, String condition, int referenceValue, int newValue) throws ArrayException {
        logger.info("Method for changing elements in array by condition is called");

        if(!validator.isValidArray(arrayEntity.getArray())){
            logger.warn("Array is not valid");
            throw new ArrayException("Array is not valid");
        }

        int[] tempArray = arrayEntity.getArray();

        switch (condition) {
            case "<":
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] < referenceValue) {
                        tempArray[i] = newValue;
                    }
                }
                break;
            case ">":
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] > referenceValue) {
                        tempArray[i] = newValue;
                    }
                }
                break;
            case "=":
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] == referenceValue) {
                        tempArray[i] = newValue;
                    }
                }
                break;
            case ">=":
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] >= referenceValue) {
                        tempArray[i] = newValue;
                    }
                }
                break;
            case "<=":
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] <= referenceValue) {
                        tempArray[i] = newValue;
                    }
                }
                break;
            case "!=":
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] != referenceValue) {
                        tempArray[i] = newValue;
                    }
                }
                break;
            default:
                logger.warn("Incorrect condition: " + condition);
                throw new ArrayException("Unknown condition: " + condition);
        }

        arrayEntity.setArray(tempArray);
    }
}