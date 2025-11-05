package org.example.task1.observer;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.observer.impl.ArrayStatsObserver;
import org.example.task1.warehouse.ArrayStats;
import org.example.task1.warehouse.ArrayStatsWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayObserverImplTest {

    private ArrayStatsObserver observer;
    private ArrayStatsWarehouse warehouse;

    @BeforeEach
    void setUp() {
        observer = new ArrayStatsObserver();
        warehouse = ArrayStatsWarehouse.getInstance();
    }

    @Test
    void testUpdate_AddsStatsToWarehouse() throws ArrayException {
        ArrayEntity arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3});
        String id = arrayEntity.getId();

        observer.onArrayChanged(arrayEntity);

        ArrayStats stats = warehouse.getStats(arrayEntity);
        assertAll(
                () -> assertNotNull(stats),
                () -> assertEquals(1, stats.getMin()),
                () -> assertEquals(3, stats.getMax()),
                () -> assertEquals(2.0, stats.getAvg()),
                () -> assertEquals(6, stats.getSum())
        );
    }

    @Test
    void testUpdate_WithExceptionHandledGracefully() {
        ArrayEntity brokenArray;
        brokenArray = new ArrayEntity(null,null);
        assertThrows(NullPointerException.class, () -> observer.onArrayChanged(null));
    }
}