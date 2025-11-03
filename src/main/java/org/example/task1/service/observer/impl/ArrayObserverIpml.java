package org.example.task1.service.osbserver.impl;

import org.example.task1.entity.ArrayEntity;
import java.util.ArrayList;
import java.util.List;

public class ArrayObserverIpml {
    private final List<ArrayObserverIpml> observers = new ArrayList<>();

    public void addObserver(ArrayObserverIpml observer) {
        observers.add(observer);
    }

    public void removeObserver(ArrayObserverIpml observer) {
        observers.remove(observer);
    }

    public void notifyArrayChanged(ArrayEntity arrayEntity) {
        observers.forEach(observer -> observer.onArrayChanged(arrayEntity));
    }

    private void onArrayChanged(ArrayEntity arrayEntity) {

    }

    public void notifyArrayAdded(ArrayEntity arrayEntity) {
        observers.forEach(observer -> observer.onArrayAdded(arrayEntity));
    }

    private void onArrayAdded(ArrayEntity arrayEntity) {

    }

    public void notifyArrayRemoved(String arrayId) {
        observers.forEach(observer -> observer.onArrayRemoved(arrayId));
    }
}