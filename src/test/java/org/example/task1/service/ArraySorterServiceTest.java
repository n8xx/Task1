package org.example.task1.service;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.sorter.impl.ArraySorterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySorterServiceTest {

    private ArraySorterService sorterService;
    private ArrayEntity arrayEntity;

    @BeforeEach
    void setUp() {
        sorterService = new ArraySorterService();
    }

    // QuickSort Tests
    @Test
    @DisplayName("QuickSort with unsorted array")
    void testQuickSort_UnsortedArray() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1", new int[]{5, 2, 8, 1, 9});
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with already sorted array")
    void testQuickSort_AlreadySorted() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with reverse sorted array")
    void testQuickSort_ReverseSorted() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 4, 3, 2, 1});
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with duplicate values")
    void testQuickSort_DuplicateValues() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{3, 1, 3, 2, 1});
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with negative numbers")
    void testQuickSort_NegativeNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-3, -1, -5, 0, 2});
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(new int[]{-5, -3, -1, 0, 2}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with single element")
    void testQuickSort_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5});
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(new int[]{5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with two elements")
    void testQuickSort_TwoElements() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{2, 1});
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(new int[]{1, 2}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with empty array")
    void testQuickSort_EmptyArray() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{});
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(new int[]{}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with all same elements")
    void testQuickSort_AllSameElements() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{7, 7, 7, 7});
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(new int[]{7, 7, 7, 7}, arrayEntity.getArray());
    }

    // InsertionSort Tests
    @Test
    @DisplayName("InsertionSort with unsorted array")
    void testInsertionSort_UnsortedArray() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 2, 8, 1, 9});
        sorterService.insertionSort(arrayEntity);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("InsertionSort with already sorted array")
    void testInsertionSort_AlreadySorted() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        sorterService.insertionSort(arrayEntity);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("InsertionSort with reverse sorted array")
    void testInsertionSort_ReverseSorted() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 4, 3, 2, 1});
        sorterService.insertionSort(arrayEntity);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("InsertionSort with duplicate values")
    void testInsertionSort_DuplicateValues() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{3, 1, 3, 2, 1});
        sorterService.insertionSort(arrayEntity);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("InsertionSort with negative numbers")
    void testInsertionSort_NegativeNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-3, -1, -5, 0, 2});
        sorterService.insertionSort(arrayEntity);
        assertArrayEquals(new int[]{-5, -3, -1, 0, 2}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("InsertionSort with single element")
    void testInsertionSort_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5});
        sorterService.insertionSort(arrayEntity);
        assertArrayEquals(new int[]{5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("InsertionSort with empty array")
    void testInsertionSort_EmptyArray() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{});
        sorterService.insertionSort(arrayEntity);
        assertArrayEquals(new int[]{}, arrayEntity.getArray());
    }

    // SelectionSort Tests
    @Test
    @DisplayName("SelectionSort with unsorted array")
    void testSelectionSort_UnsortedArray() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 2, 8, 1, 9});
        sorterService.selectionSort(arrayEntity);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("SelectionSort with already sorted array")
    void testSelectionSort_AlreadySorted() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        sorterService.selectionSort(arrayEntity);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("SelectionSort with reverse sorted array")
    void testSelectionSort_ReverseSorted() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 4, 3, 2, 1});
        sorterService.selectionSort(arrayEntity);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("SelectionSort with duplicate values")
    void testSelectionSort_DuplicateValues() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{3, 1, 3, 2, 1});
        sorterService.selectionSort(arrayEntity);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("SelectionSort with negative numbers")
    void testSelectionSort_NegativeNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-3, -1, -5, 0, 2});
        sorterService.selectionSort(arrayEntity);
        assertArrayEquals(new int[]{-5, -3, -1, 0, 2}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("SelectionSort with single element")
    void testSelectionSort_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5});
        sorterService.selectionSort(arrayEntity);
        assertArrayEquals(new int[]{5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("SelectionSort with empty array")
    void testSelectionSort_EmptyArray() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{});
        sorterService.selectionSort(arrayEntity);
        assertArrayEquals(new int[]{}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("SelectionSort with two elements")
    void testSelectionSort_TwoElements() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{2, 1});
        sorterService.selectionSort(arrayEntity);
        assertArrayEquals(new int[]{1, 2}, arrayEntity.getArray());
    }

    // Comparative Tests - All algorithms should produce same result
    @Test
    @DisplayName("All sorting algorithms produce same result")
    void testAllSortingAlgorithms_SameResult() throws ArrayException {
        int[] originalArray = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        int[] expectedSorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Test QuickSort
        arrayEntity = new ArrayEntity("arr1",originalArray.clone());
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertArrayEquals(expectedSorted, arrayEntity.getArray());

        // Test InsertionSort
        arrayEntity = new ArrayEntity("arr1",originalArray.clone());
        sorterService.insertionSort(arrayEntity);
        assertArrayEquals(expectedSorted, arrayEntity.getArray());

        // Test SelectionSort
        arrayEntity = new ArrayEntity("arr1",originalArray.clone());
        sorterService.selectionSort(arrayEntity);
        assertArrayEquals(expectedSorted, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with partial array sorting")
    void testQuickSort_PartialArray() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 2, 8, 1, 9, 3, 7});
        // Sort only from index 1 to 5
        sorterService.quickSort(arrayEntity, 1, 5);
        // Elements at indices 1-5 should be sorted, others remain unchanged
        assertArrayEquals(new int[]{5, 1, 2, 3, 8, 9, 7}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("QuickSort with same begin and end index")
    void testQuickSort_SameBeginEnd() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 2, 8, 1, 9});
        sorterService.quickSort(arrayEntity, 2, 2);
        // Array should remain unchanged when sorting single element
        assertArrayEquals(new int[]{5, 2, 8, 1, 9}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Test with null ArrayEntity")
    void testWithNullArrayEntity() {
        assertThrows(NullPointerException.class,
            () -> sorterService.insertionSort(null));
        
        assertThrows(NullPointerException.class,
            () -> sorterService.selectionSort(null));
        
        assertThrows(NullPointerException.class,
            () -> sorterService.quickSort(null, 0, 0));
    }

    @Test
    @DisplayName("Sorting preserves array length")
    void testSortingPreservesLength() throws ArrayException {
        int[] original = {5, 2, 8, 1, 9};
        arrayEntity = new ArrayEntity("arr1",original.clone());
        
        sorterService.quickSort(arrayEntity, 0, arrayEntity.getLength() - 1);
        assertEquals(original.length, arrayEntity.getLength());
        
        arrayEntity = new ArrayEntity("arr1",original.clone());
        sorterService.insertionSort(arrayEntity);
        assertEquals(original.length, arrayEntity.getLength());
        
        arrayEntity = new ArrayEntity("arr1",original.clone());
        sorterService.selectionSort(arrayEntity);
        assertEquals(original.length, arrayEntity.getLength());
    }
}