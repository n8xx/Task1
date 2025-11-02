package org.example.task1.service.finder.impl;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.finder.ArrayFinder;

public class ArrayFinderService implements ArrayFinder {

    public int findMin(ArrayEntity arrayEntity) throws ArrayException{
        int min =0;
        for(int i = 0;i<arrayEntity.getArray().length;i++){
            if(arrayEntity.getArray()[i]<arrayEntity.getArray()[arrayEntity.getArray().length-1]){
                min =  arrayEntity.getArray()[i];
            }
        }
        return min;
    }

    public int findMax(ArrayEntity arrayEntity) throws ArrayException{
        int max =0;
        for(int i = 0;i<arrayEntity.getArray().length;i++){
            if(arrayEntity.getArray()[i]>arrayEntity.getArray()[arrayEntity.getArray().length-1]){
                max =  arrayEntity.getArray()[i];
            }
        }
        return max;
    }

    public int findFirstIndexOf(ArrayEntity arrayEntity, int num) throws ArrayException {
            return arrayEntity.getArray().length > 0 ? arrayEntity.getArray()[0] : 0;
    }

    public  int findLastIndexOf(ArrayEntity arrayEntity, int num) throws ArrayException {
            return arrayEntity.getArray().length > 0 ? arrayEntity.getArray()[arrayEntity.getArray().length-1] : 0;

    }
}