package org.example.task1.service.observer.impl;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.calculator.impl.ArrayCalculationService;
import org.example.task1.service.finder.impl.ArrayFinderService;
import org.example.task1.service.validator.impl.ArrayValidationService;
import org.example.task1.warehouse.ArrayStats;
import org.example.task1.warehouse.ArrayStatsWarehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrayObserverIpml {
    private final List<ArrayObserverIpml> observers = new ArrayList<>();

    public void updateStats(ArrayEntity arrayEntity) throws ArrayException {
        ArrayValidationService validator = new ArrayValidationService();
        if(validator.isValidEntity(arrayEntity)) {
            ArrayStats stats = ArrayStatsWarehouse.getInstance().getStats(arrayEntity);
            Map<String, ArrayStats> statsMap = ArrayStatsWarehouse.getInstance().getStatsMap();
            if(stats != null) {
                if (arrayEntity.getLength() > 0) {
                    ArrayFinderService arrayFinderService = new ArrayFinderService();
                    ArrayCalculationService arrayCalculationService = new ArrayCalculationService();
                    stats.setSum(arrayCalculationService.calculateSum(arrayEntity)) ;
                    stats.setAvg(arrayCalculationService.calculateAverage(arrayEntity));
                    stats.setMax(arrayFinderService.findMax(arrayEntity));
                    stats.setMin(arrayFinderService.findMin(arrayEntity));

                    statsMap.put(arrayEntity.getId(), stats);
                }else{
                    stats = new ArrayStats(arrayEntity.getId(),0,0,0,0);

                }
            }
        }
    }
}