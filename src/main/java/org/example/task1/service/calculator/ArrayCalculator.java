package org.example.task1.service.calculator;


import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;

public interface ArrayCalculator {
    double calculateAverage(ArrayEntity arrayEntity) throws ArrayException;

    int calculateSum(ArrayEntity arrayEntity) throws ArrayException;

    int calculatePositiveElem(ArrayEntity arrayEntity) throws ArrayException;

    int calculateNegativeElem(ArrayEntity arrayEntity) throws ArrayException;

}
