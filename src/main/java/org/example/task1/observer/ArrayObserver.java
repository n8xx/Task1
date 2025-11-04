package org.example.task1.observer;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;

public interface ArrayObserver {
    void onArrayChanged(ArrayEntity arrayEntity);
}