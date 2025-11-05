package org.example.task1.service.sorter.impl;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.sorter.ArraySorter;

public class ArraySorterService implements ArraySorter {
    @Override
    public void quickSort(ArrayEntity arrayEntity, int begin,int end) throws ArrayException {
            if (begin < end) {
                int partitionIndex = partition(arrayEntity.getArray(), begin, end);
                quickSort(arrayEntity, begin, partitionIndex-1);
                quickSort(arrayEntity, partitionIndex+1, end);
            }
        }
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        return i+1;
    }

    @Override
    public void insertionSort(ArrayEntity arrayEntity) throws ArrayException {
        for (int i = 1; i < arrayEntity.getLength(); i++) {
            int key = arrayEntity.getArray()[i];
            int j = i - 1;
            while (j >= 0 && arrayEntity.getArray()[j] > key) {
                arrayEntity.getArray()[j + 1] = arrayEntity.getArray()[j];
                j = j - 1;
            }
            arrayEntity.getArray()[j + 1] = key;
        }
    }

    @Override
    public void selectionSort(ArrayEntity arrayEntity) throws ArrayException {
        for (int i = 0; i < arrayEntity.getLength() - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arrayEntity.getLength(); j++) {
                if (arrayEntity.getArray()[minElementIndex] > arrayEntity.getArray()[j]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = arrayEntity.getArray()[i];
                arrayEntity.getArray()[i] = arrayEntity.getArray()[minElementIndex];
                arrayEntity.getArray()[minElementIndex] = temp;
            }
        }
    }
}
