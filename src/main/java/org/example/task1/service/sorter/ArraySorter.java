package org.example.task1.service.sorter;

import org.example.task1.exception.ArrayException;
import org.example.task1.entity.ArrayEntity;

public interface ArraySorter {

    void quickSort(ArrayEntity arrayEntity) throws ArrayException;

    void insertionSort(ArrayEntity arrayEntity)throws ArrayException;

    void selectionSort(ArrayEntity arrayEntity)throws ArrayException;

}
