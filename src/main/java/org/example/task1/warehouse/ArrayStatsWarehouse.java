package org.example.task1.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.validator.impl.ArrayValidationService;
import org.example.task1.service.calculator.impl.ArrayCalculationService;
import org.example.task1.service.finder.impl.ArrayFinderService;


import java.util.HashMap;
import java.util.Map;

public class ArrayStatsWarehouse {
    private static ArrayStatsWarehouse instance;
    private Map<String, ArrayStats> statsMap;
    public static final Logger logger = LogManager.getLogger(ArrayValidationService.class);

    private ArrayStatsWarehouse() {
        statsMap = new HashMap<>();
    }
    
    public static ArrayStatsWarehouse getInstance() {
        if (instance == null) {
            instance = new ArrayStatsWarehouse();
        }
        return instance;
    }
    public Map<String, ArrayStats> getStatsMap() {
        return statsMap;
    }


    public ArrayStats getStats(ArrayEntity arrayEntity) throws ArrayException {
        return statsMap.get(arrayEntity.getId());
    }
    
    public void removeStats(ArrayEntity arrayEntity) throws ArrayException {
        statsMap.remove(arrayEntity.getId());
    }

}