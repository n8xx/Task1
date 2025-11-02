package org.example.task1.repository;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    void addArray(ArrayEntity array) throws ArrayException;
    void removeArray(int id) throws ArrayException;
    List<ArrayEntity> sortArray(Comparator<ArrayEntity> comparator);
    List<ArrayEntity> getAllArrays() throws ArrayException;
    ArrayEntity getArrayById(String id);
}