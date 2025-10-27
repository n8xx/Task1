package org.example.task1.service.osbserver.impl;

import org.example.task1.entity.ArrayEntity;
import java.util.ArrayList;
import java.util.List;

public class ArrayObserver {
    private final List<ArrayObserver> observers = new ArrayList<>();
    
    public void addObserver(ArrayObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(ArrayObserver observer) {
        observers.remove(observer);
    }
    
    public void notifyArrayChanged(ArrayEntity arrayEntity) {
        observers.forEach(observer -> observer.onArrayChanged(arrayEntity));
    }
    
    public void notifyArrayAdded(ArrayEntity arrayEntity) {
        observers.forEach(observer -> observer.onArrayAdded(arrayEntity));
    }
    
    public void notifyArrayRemoved(String arrayId) {
        observers.forEach(observer -> observer.onArrayRemoved(arrayId));
    }
}