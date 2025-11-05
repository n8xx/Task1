package org.example.task1.repository.specification.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.entity.ArrayEntity;
import org.example.task1.repository.specification.ArraySpecification;

public class ContainsValueSpecification implements ArraySpecification {
    public final static Logger logger = LogManager.getLogger();
    private int value;
    public ContainsValueSpecification(int value) {
        this.value = value;
    }
    @Override
    public boolean specify(ArrayEntity arrayEntity) {

        boolean result = java.util.Arrays.stream(arrayEntity.getArray()).anyMatch(num -> num == value);
        logger.info("contains value: {} {} in {}", value,result,arrayEntity.getArray());
        return result;
    }

}