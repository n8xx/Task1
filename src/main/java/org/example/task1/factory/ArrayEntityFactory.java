package org.example.task1.factory;

import org.example.task1.entity.ArrayEntity;
import java.util.Random;

public class ArrayEntityFactory {
    
    public static ArrayEntity createWithId(String id) {
        return new ArrayEntity(id, new int[0]);
    }
    
    public static ArrayEntity createWithData(String id, int[] data) {
        return new ArrayEntity(id, data);
    }
    
    public static ArrayEntity createRandom(String id, int size, int minValue, int maxValue) {
        Random random = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return new ArrayEntity(id, data);
    }
    
    public static ArrayEntity createSequential(String id, int start, int end) {
        int size = Math.abs(end - start) + 1;
        int[] data = new int[size];
        int value = start;
        for (int i = 0; i < size; i++) {
            data[i] = value;
            value += (start < end) ? 1 : -1;
        }
        return new ArrayEntity(id, data);
    }
}