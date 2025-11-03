package org.example.task1.service.observer;

import org.example.task1.entity.ArrayEntity;

public interface ArrayObserver {
    public void addObserver(org.example.task1.service.osbserver.impl.ArrayObserverIpml observer) ;
    public void removeObserver(org.example.task1.service.osbserver.impl.ArrayObserverIpml observer) ;
    public void notifyArrayChanged(ArrayEntity arrayEntity);
    public void notifyArrayAdded(ArrayEntity arrayEntity) ;
    public void notifyArrayRemoved(String arrayId);
}
