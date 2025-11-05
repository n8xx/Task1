package org.example.task1.repository.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.entity.ArrayEntity;
import org.example.task1.repository.specification.ArraySpecification;

public class IdSpecification implements ArraySpecification {
    public final static Logger logger = LogManager.getLogger();
    String id;
    public IdSpecification(String id) {
        this.id = id;
    }
    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        logger.info(" checking id: {}",this.id);
        return arrayEntity.getId().equals(this.id);
    }
}