package org.example.task1.repository.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.repository.specification.ArraySpecification;
import org.example.task1.warehouse.ArrayStatsWarehouse;

public class SumLessThanSpecification implements ArraySpecification {
    public final static Logger logger = LogManager.getLogger();
    int sum;
    ArrayStatsWarehouse warehouse= ArrayStatsWarehouse.getInstance();
    public SumLessThanSpecification(int sum) {
        this.sum = sum;
    }
    @Override
    public boolean specify(ArrayEntity arrayEntity) throws ArrayException {
        int[] array = arrayEntity.getArray();
        int sum = warehouse.getStats(arrayEntity).getSum();
        logger.info("sum of current array = {}",sum);
        return sum < this.sum;
    }
}