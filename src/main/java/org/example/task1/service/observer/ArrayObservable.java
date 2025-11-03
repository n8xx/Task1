package org.example.task1.service.observer;

import org.example.task1.service.observer.impl.ArrayObserverIpml;

public interface ArrayObservable {
    void attach(ArrayObserverIpml observer);
    void detach(ArrayObserverIpml observer);
    void notifyObservers();
}