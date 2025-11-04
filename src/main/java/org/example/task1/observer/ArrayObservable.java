package org.example.task1.observer;

import org.example.task1.exception.ArrayException;
import org.example.task1.observer.impl.ArrayStatsObserver;

import java.util.List;

public interface ArrayObservable {
    void attach(ArrayStatsObserver observer);
    void detach(ArrayStatsObserver observer);
    void notifyObservers(ArrayStatsObserver observer);
}