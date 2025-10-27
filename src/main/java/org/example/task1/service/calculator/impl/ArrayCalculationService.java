package org.example.task1.service.calculator.impl;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.calculator.ArrayCalculator;

import java.util.Arrays;
import java.util.logging.Logger;


public class ArrayCalculationService implements ArrayCalculator {
    private static final Logger logger = Logger.getLogger(ArrayEntity.class.getName());

    public double calculateAverage(ArrayEntity arrayEntity) throws ArrayException{
        double avg = 0;
        if(arrayEntity.getArray().length>0){
            logger.info("Method average start");
            for(int i = 0;i<arrayEntity.getArray().length;i++){
                avg +=arrayEntity.getArray()[i];
            }}else{
            throw new ArrayException("Array is empty");
        }
        logger.info("Method average end, avg:"+avg);
        return avg/arrayEntity.getArray().length;
    }

   public int calculateSum(ArrayEntity arrayEntity) throws ArrayException{
        int sum = 0;
        if(arrayEntity.getArray().length>0){
            for(int num:arrayEntity.getArray()){
                sum+=num;
            }
        }else{
            throw new ArrayException("Array is empty");
        }
        logger.info("Sum of elements: "+sum);
    return sum;
    }

    public int calculatePositiveElem(ArrayEntity arrayEntity) throws ArrayException{
        return 0;
    }

    public int calculateNegativeElem(ArrayEntity arrayEntity) throws ArrayException{

        return 0;
    }
}
