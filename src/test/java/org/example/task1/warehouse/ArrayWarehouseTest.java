package org.example.task1.warehouse;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.repository.ArrayRepository;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArrayWarehouseTest {

    @Test
    void testSingleton() {
        ArrayStatsWarehouse first = ArrayStatsWarehouse.getInstance();
        ArrayStatsWarehouse second = ArrayStatsWarehouse.getInstance();
        assertSame(first, second);
    }

    @Test
    void testPutAndGet() throws ArrayException {
        ArrayStatsWarehouse warehouse = ArrayStatsWarehouse.getInstance();
        ArrayRepository repository = ArrayRepository.getInstance();

        ArrayEntity arrayEntity = new ArrayEntity("arr1",4);
        ArrayStats stats = new ArrayStats("arr1", 10, 5.5, 22,0);


        warehouse.putStats(arrayEntity,stats);
        ArrayStats result = warehouse.getStats("arr1");
        assertEquals(stats, result);
    }

    @Test
    void testRemove() throws ArrayException {
        ArrayStatsWarehouse warehouse = ArrayStatsWarehouse.getInstance();
        ArrayRepository repository = ArrayRepository.getInstance();

        ArrayEntity arrayEntity = new ArrayEntity("arr2",4);
        ArrayStats stats = new ArrayStats("arr2", 8, 4.0, 20,0);


        warehouse.putStats(arrayEntity,stats );
        warehouse.removeStats("arr2");

        assertNull(warehouse.getStats("arr2"));
    }
}