package org.example.task1.service.finder;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;

public interface ArrayFinder {
    int findMin(ArrayEntity arrayEntity) throws ArrayException ;
    int findMax(ArrayEntity arrayEntity) throws ArrayException ;
    int findFirstIndexOf(ArrayEntity arrayEntity, int num) throws ArrayException ;
    int findLastIndexOf(ArrayEntity arrayEntity, int num) throws ArrayException ;


}
