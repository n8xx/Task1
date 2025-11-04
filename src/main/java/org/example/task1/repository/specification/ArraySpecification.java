package org.example.task1.repository.specification;

import org.example.task1.entity.ArrayEntity;

public interface ArraySpecification {
    boolean isSatisfied(ArrayEntity arrayEntity);
}