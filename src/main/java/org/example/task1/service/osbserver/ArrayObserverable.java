package org.example.task1.service.osbserver;

import org.example.task1.entity.ArrayEntity;

public interface ArrayObserverable {
    void onArrayChanged(ArrayEntity arrayEntity);
    void onArrayAdded(ArrayEntity arrayEntity);
    void onArrayRemoved(String arrayId);
}