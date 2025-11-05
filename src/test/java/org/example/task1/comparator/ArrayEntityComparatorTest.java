package org.example.task1.comparator;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayEntityComparatorTest {

    private List<ArrayEntity> arrays;

    @BeforeEach
    void setUp() throws ArrayException {
        arrays = new ArrayList<>();
        arrays.add(new ArrayEntity("arr1", new int[]{10, 20, 30}));
        arrays.add(new ArrayEntity("arr2", new int[]{1, 2, 3}));
        arrays.add(new ArrayEntity("arr3", new int[]{5, 5}));
    }

    @Test
    void testCompareById() {
        arrays.sort(ArrayComparator.ID);
        assertAll(
                () -> assertArrayEquals(new int[]{10, 20, 30}, arrays.get(0).getArray()),
                () -> assertArrayEquals(new int[]{1, 2, 3}, arrays.get(1).getArray()),
                () -> assertArrayEquals(new int[]{5, 5}, arrays.get(2).getArray())
        );
    }

    @Test
    void testCompareByLength() {
        arrays.sort(ArrayComparator.ELEMENT_COUNT);
        assertAll(
                () -> assertArrayEquals(new int[]{5, 5}, arrays.get(0).getArray()),
                () -> assertArrayEquals(new int[]{10, 20, 30}, arrays.get(1).getArray()),
                () -> assertArrayEquals(new int[]{1, 2, 3}, arrays.get(2).getArray())
        );
    }

    @Test
    void testCompareBySum() {
        arrays.sort(ArrayComparator.SUM);
        assertAll(
                () -> assertArrayEquals(new int[]{1, 2, 3}, arrays.get(0).getArray()),
                () -> assertArrayEquals(new int[]{5, 5}, arrays.get(1).getArray()),
                () -> assertArrayEquals(new int[]{10, 20, 30}, arrays.get(2).getArray())
        );
    }
}