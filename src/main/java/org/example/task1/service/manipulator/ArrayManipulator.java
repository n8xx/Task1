package org.example.task1.service.manipulator;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;

import java.util.function.IntPredicate;

public interface ArrayManipulator {

    void replaceByCondition(ArrayEntity arrayEntity, String condition, int referenceValue, int newValue) throws ArrayException;
}