package org.example.task1.warehouse;

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

    private ArrayStatsWarehouse() {
        ArrayValidationService validator = new ArrayValidationService();
        statsMap = new HashMap<>();
    }
    
    public static ArrayStatsWarehouse getInstance() {
        if (instance == null) {
            instance = new ArrayStatsWarehouse();
        }
        return instance;
    }
    
    public void updateStats(ArrayEntity arrayEntity) throws ArrayException {
        validator.
        ArrayStats stats = new ArrayStats(arrayEntity.getId(), 0, 0, 0, 0);

        if (arrayEntity.getLength() > 0) {
            ArrayFinderService arrayFinderService = new ArrayFinderService();
            ArrayCalculationService arrayCalculationService = new ArrayCalculationService();
            stats.setSum(arrayCalculationService.calculateSum(arrayEntity)) ;
            stats.setAvg(arrayCalculationService.calculateAverage(arrayEntity));
            stats.setMax(arrayFinderService.findMax(arrayEntity));
            stats.setMin(arrayFinderService.findMin(arrayEntity));

            statsMap.put(arrayEntity.getId(), stats);
        }
    }
    
    public ArrayStats getStats(ArrayEntity arrayEntity) throws ArrayException {
        return statsMap.get(arrayEntity.getId());
    }
    
    public void removeStats(ArrayEntity arrayEntity) throws ArrayException {
        statsMap.remove(arrayEntity.getId());
    }

}