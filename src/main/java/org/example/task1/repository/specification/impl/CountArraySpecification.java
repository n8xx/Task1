package org.example.task1.repository.specification.impl;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.repository.specification.ArraySpecification;

public class CountArraySpecification implements ArraySpecification {

    @Override
    public boolean isSatisfied(ArrayEntity arrayEntity) {
        return false;
    }

}
