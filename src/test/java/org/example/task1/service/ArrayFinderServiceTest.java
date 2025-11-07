package org.example.task1.service;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.finder.impl.ArrayFinderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFinderServiceTest {

    private ArrayFinderService finderService;
    private ArrayEntity arrayEntity;

    @BeforeEach
    void setUp() {
        finderService = new ArrayFinderService();
    }

    @Test
    @DisplayName("Find min with positive numbers")
    void testFindMin_PositiveNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 2, 8, 1, 9});
        int result = finderService.findMin(arrayEntity);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Find min with negative numbers")
    void testFindMin_NegativeNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-1, -5, -3, -2});
        int result = finderService.findMin(arrayEntity);
        assertEquals(-5, result);
    }

    @Test
    @DisplayName("Find min with mixed numbers")
    void testFindMin_MixedNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-2, 0, 4, -5, 8});
        int result = finderService.findMin(arrayEntity);
        assertEquals(-5, result);
    }

    @Test
    @DisplayName("Find min with single element")
    void testFindMin_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{7});
        int result = finderService.findMin(arrayEntity);
        assertEquals(7, result);
    }

    @Test
    @DisplayName("Find min with duplicate min values")
    void testFindMin_DuplicateValues() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{3, 1, 1, 4, 1});
        int result = finderService.findMin(arrayEntity);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Find min with all same values")
    void testFindMin_AllSameValues() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 5, 5, 5});
        int result = finderService.findMin(arrayEntity);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Find max with positive numbers")
    void testFindMax_PositiveNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 2, 8, 1, 9});
        int result = finderService.findMax(arrayEntity);
        assertEquals(9, result);
    }

    @Test
    @DisplayName("Find max with negative numbers")
    void testFindMax_NegativeNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-1, -5, -3, -2});
        int result = finderService.findMax(arrayEntity);
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Find max with mixed numbers")
    void testFindMax_MixedNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-2, 0, 4, -5, 8});
        int result = finderService.findMax(arrayEntity);
        assertEquals(8, result);
    }

    @Test
    @DisplayName("Find max with single element")
    void testFindMax_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{7});
        int result = finderService.findMax(arrayEntity);
        assertEquals(7, result);
    }

    @Test
    @DisplayName("Find max with duplicate max values")
    void testFindMax_DuplicateValues() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{3, 9, 1, 9, 4});
        int result = finderService.findMax(arrayEntity);
        assertEquals(9, result);
    }

    @Test
    @DisplayName("Find max with all same values")
    void testFindMax_AllSameValues() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5, 5, 5, 5});
        int result = finderService.findMax(arrayEntity);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Find first index of - returns first element")
    void testFindFirstIndexOf_ReturnsFirstElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 2, 4});
        int result = finderService.findFirstIndexOf(arrayEntity, 2);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Find first index of with different search value")
    void testFindFirstIndexOf_DifferentSearchValue() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{10, 20, 30});
        int result = finderService.findFirstIndexOf(arrayEntity, 5);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Find first index of with single element")
    void testFindFirstIndexOf_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{42});
        int result = finderService.findFirstIndexOf(arrayEntity, 99);
        assertEquals(42, result);
    }

    @Test
    @DisplayName("Find last index of - returns last element")
    void testFindLastIndexOf_ReturnsLastElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 2, 4});
        int result = finderService.findLastIndexOf(arrayEntity, 2);
        assertEquals(4, result);
    }

    @Test
    @DisplayName("Find last index of with different search value")
    void testFindLastIndexOf_DifferentSearchValue() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{10, 20, 30});
        int result = finderService.findLastIndexOf(arrayEntity, 99);
        assertEquals(30, result);
    }

    @Test
    @DisplayName("Find last index of with single element")
    void testFindLastIndexOf_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{42});
        int result = finderService.findLastIndexOf(arrayEntity, 5);
        assertEquals(42, result);
    }

    @Test
    @DisplayName("Find methods with empty array")
    void testFindMethods_EmptyArray() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{});
        
        assertEquals(0, finderService.findMin(arrayEntity));
        assertEquals(0, finderService.findMax(arrayEntity));
        assertEquals(0, finderService.findFirstIndexOf(arrayEntity, 5));
        assertEquals(0, finderService.findLastIndexOf(arrayEntity, 5));
    }

    @Test
    @DisplayName("Find methods with single element array")
    void testFindMethods_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{42});
        
        assertEquals(42, finderService.findMin(arrayEntity));
        assertEquals(42, finderService.findMax(arrayEntity));
        assertEquals(42, finderService.findFirstIndexOf(arrayEntity, 5));
        assertEquals(42, finderService.findLastIndexOf(arrayEntity, 5));
    }

    @Test
    @DisplayName("Find methods with two elements")
    void testFindMethods_TwoElements() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{3, 7});
        
        assertEquals(3, finderService.findMin(arrayEntity));
        assertEquals(7, finderService.findMax(arrayEntity));
        assertEquals(3, finderService.findFirstIndexOf(arrayEntity, 5));
        assertEquals(7, finderService.findLastIndexOf(arrayEntity, 5));
    }

    @Test
    @DisplayName("Find min with zeros")
    void testFindMin_WithZeros() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{0, 5, -2, 0});
        int result = finderService.findMin(arrayEntity);
        assertEquals(-2, result);
    }

    @Test
    @DisplayName("Find max with zeros")
    void testFindMax_WithZeros() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{0, 5, -2, 0});
        int result = finderService.findMax(arrayEntity);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Test with null ArrayEntity")
    void testWithNullArrayEntity() {
        assertThrows(NullPointerException.class, 
            () -> finderService.findMin(null));
    }
}