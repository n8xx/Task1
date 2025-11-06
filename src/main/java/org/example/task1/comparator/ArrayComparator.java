package org.example.task1.comparator;

import java.util.Comparator;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.warehouse.ArrayStats;
import org.example.task1.warehouse.ArrayStatsWarehouse;


public enum ArrayComparator implements Comparator<ArrayEntity> {
    ID {
        @Override
        public int compare(ArrayEntity arr1, ArrayEntity arr2) {
            return arr1.getId().compareTo(arr2.getId());
        }
    },

    ELEMENT_COUNT {
        @Override
        public int compare(ArrayEntity arr1, ArrayEntity arr2) {
            return Integer.compare(arr1.getLength(), arr2.getLength());
        }
    },

    SUM {
        @Override
        public int compare(ArrayEntity arr1, ArrayEntity arr2) {
            ArrayStatsWarehouse warehouse = ArrayStatsWarehouse.getInstance();

            try {
              ArrayStats  stats1 = warehouse.getStats(arr1);
              ArrayStats  stats2 = warehouse.getStats(arr2);

                if (stats1 == null && stats2 == null) return 0;
                if (stats1 == null) return -1;
                if (stats2 == null) return 1;
                return Integer.compare(stats1.getSum(), stats2.getSum());

            } catch (ArrayException e) {
                throw new RuntimeException(e);
            }
        }
    }
}