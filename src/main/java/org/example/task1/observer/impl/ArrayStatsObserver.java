package org.example.task1.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.observer.ArrayObserver;
import org.example.task1.service.calculator.impl.ArrayCalculationService;
import org.example.task1.service.finder.impl.ArrayFinderService;
import org.example.task1.validator.impl.ArrayValidationService;
import org.example.task1.warehouse.ArrayStats;
import org.example.task1.warehouse.ArrayStatsWarehouse;

import java.util.Map;

public class ArrayStatsObserver implements ArrayObserver {
    private final ArrayStatsWarehouse warehouse = ArrayStatsWarehouse.getInstance();
    public final static Logger logger = LogManager.getLogger();

    @Override
    public void onArrayChanged(ArrayEntity arrayEntity)  {
        ArrayValidationService validator = new ArrayValidationService();

        if (!validator.isValidEntity(arrayEntity)) {
            logger.warn("Invalid array entity");
            return;
        }

        Map<String, ArrayStats> statsMap = warehouse.getStatsMap();
        try{
        ArrayStats stats = statsMap.get(arrayEntity.getId());
        if (arrayEntity.getLength() == 0) {
            handleEmptyArray(statsMap, arrayEntity.getId());
            logger.warn("Array is empty");
            return;
        }
        updateArrayStats(arrayEntity, stats, statsMap);
        }catch(ArrayException e){
            logger.warn(e.getMessage());
        }
    }

    private void handleEmptyArray(Map<String, ArrayStats> statsMap, String arrayId) {
        ArrayStats emptyStats = new ArrayStats(arrayId, 0, 0, 0, 0);
        statsMap.put(arrayId, emptyStats);
    }

    private void updateArrayStats(ArrayEntity arrayEntity, ArrayStats stats, Map<String, ArrayStats> statsMap) throws ArrayException {
        ArrayFinderService arrayFinderService = new ArrayFinderService();
        ArrayCalculationService arrayCalculationService = new ArrayCalculationService();

        int sum = arrayCalculationService.calculateSum(arrayEntity);
        double avg = arrayCalculationService.calculateAverage(arrayEntity);
        int max = arrayFinderService.findMax(arrayEntity);
        int min = arrayFinderService.findMin(arrayEntity);

        if (stats != null) {
            stats.setSum(sum);
            stats.setAvg(avg);
            stats.setMax(max);
            stats.setMin(min);
        } else {
            stats = new ArrayStats(arrayEntity.getId(), sum, avg, max, min);
            statsMap.put(arrayEntity.getId(), stats);
        }
    }
}