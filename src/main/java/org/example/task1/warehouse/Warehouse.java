package org.example.task1.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private final Map<String, ArrayStats> statsMap;
    
    private Warehouse() {
        statsMap = new HashMap<>();
    }
    
    public static synchronized Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }
    
    public void updateStats(ArrayEntity arrayEntity) {
        int[] array = arrayEntity.getArray();
        if (array.length == 0) {
            statsMap.put(arrayEntity.getId(), new ArrayStats(arrayEntity.getId(), 0, 0, 0, 0, 0));
            return;
        }
        
        int sum = 0;
        int max = array[0];
        int min = array[0];
        
        for (int value : array) {
            sum += value;
            if (value > max) max = value;
            if (value < min) min = value;
        }
        
        double average = (double) sum / array.length;
        ArrayStats stats = new ArrayStats(arrayEntity.getId(), average, sum, max, min, array.length);
        statsMap.put(arrayEntity.getId(), stats);
    }
    
    public ArrayStats getStats(String arrayId) {
        return statsMap.get(arrayId);
    }
    
    public void removeStats(String arrayId) {
        statsMap.remove(arrayId);
    }
    
    public void displayAllStats() {
        System.out.println("=== Warehouse Statistics ===");
        statsMap.values().forEach(System.out::println);
    }
}