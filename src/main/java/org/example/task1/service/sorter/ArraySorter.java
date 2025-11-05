package org.example.task1.service.sorter;

import org.example.task1.exception.ArrayException;
import org.example.task1.entity.ArrayEntity;

public interface ArraySorter {

    void quickSort(ArrayEntity arrayEntity, int begin,int end) throws ArrayException;

    void insertionSort(ArrayEntity arrayEntity)throws ArrayException;

    void selectionSort(ArrayEntity arrayEntity)throws ArrayException;

}
