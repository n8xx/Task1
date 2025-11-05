package org.example.task1.repository.specification;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;

public interface ArraySpecification {
    boolean specify(ArrayEntity arrayEntity) throws ArrayException;
}