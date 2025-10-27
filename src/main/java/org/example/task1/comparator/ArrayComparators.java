package org.example.task1.comparator;

import java.util.Comparator;
import org.example.task1.warehouse.Warehouse;
import org.example.task1.entity.ArrayEntity;
//import org.example.task1.service.calculator.impl;
import org.example.task1.service.finder.impl.ArrayFinderService;

public class ArrayComparators {
    
    public static Comparator<ArrayEntity> byId() {
        return Comparator.comparing(ArrayEntity::getId);
    }
    
   /* public static Comparator<ArrayEntity> byFirstElement() {
        return Comparator.comparing( new ArrayFinderService.);
    }*/
    
    public static Comparator<ArrayEntity> byLength() {
        return Comparator.comparing(ArrayEntity::getLength);
    }
    
    /* static Comparator<ArrayEntity> bySum(Warehouse warehouse) {
        return (e1, e2) -> {
            ArrayStats s1 = warehouse.getStats(e1.getId());
            ArrayStats s2 = warehouse.getStats(e2.getId());
            return Integer.compare(s1 != null ? s1.getSum() : 0, s2 != null ? s2.getSum() : 0);
        };
    }*/
}