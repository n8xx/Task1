package org.example.task1;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.calculator.impl.ArrayCalculationService;

public class TestClass {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ArrayEntity arrayEntity = new ArrayEntity("test",arr);
        ArrayCalculationService arrayCalculationService = new ArrayCalculationService();
        try {
            arrayCalculationService.calculateAverage(arrayEntity);
        } catch (ArrayException e) {
            throw new RuntimeException(e);
        }

    }
}
