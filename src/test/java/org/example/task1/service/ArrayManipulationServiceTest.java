package org.example.task1.service;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.manipulator.impl.ArrayManipulationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayManipulationServiceTest {

    private ArrayManipulationService manipulatorService;
    private ArrayEntity arrayEntity;

    @BeforeEach
    void setUp() {
        manipulatorService = new ArrayManipulationService();
    }

    @Test
    @DisplayName("Replace elements less than reference value")
    void testReplaceByCondition_LessThan() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 5, 3, 8, 2});
        manipulatorService.replaceByCondition(arrayEntity, "<", 4, 0);
        
        assertArrayEquals(new int[]{0, 5, 0, 8, 0}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace elements greater than reference value")
    void testReplaceByCondition_GreaterThan() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 5, 3, 8, 2});
        manipulatorService.replaceByCondition(arrayEntity, ">", 4, 10);
        
        assertArrayEquals(new int[]{1, 10, 3, 10, 2}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace elements equal to reference value")
    void testReplaceByCondition_EqualTo() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 5, 3, 5, 2});
        manipulatorService.replaceByCondition(arrayEntity, "=", 5, 99);
        
        assertArrayEquals(new int[]{1, 99, 3, 99, 2}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace elements greater than or equal to reference value")
    void testReplaceByCondition_GreaterThanOrEqual() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 5, 3, 8, 2});
        manipulatorService.replaceByCondition(arrayEntity, ">=", 5, 0);
        
        assertArrayEquals(new int[]{1, 0, 3, 0, 2}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace elements less than or equal to reference value")
    void testReplaceByCondition_LessThanOrEqual() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 5, 3, 8, 2});
        manipulatorService.replaceByCondition(arrayEntity, "<=", 3, -1);
        
        assertArrayEquals(new int[]{-1, 5, -1, 8, -1}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace elements not equal to reference value")
    void testReplaceByCondition_NotEqual() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 5, 3, 5, 2});
        manipulatorService.replaceByCondition(arrayEntity, "!=", 5, 0);
        
        assertArrayEquals(new int[]{0, 5, 0, 5, 0}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace with negative numbers")
    void testReplaceByCondition_NegativeNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-5, -2, 0, 3, 7});
        manipulatorService.replaceByCondition(arrayEntity, "<", 0, -10);
        
        assertArrayEquals(new int[]{-10, -10, 0, 3, 7}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace with zero reference value")
    void testReplaceByCondition_ZeroReference() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-3, -1, 0, 1, 3});
        manipulatorService.replaceByCondition(arrayEntity, ">", 0, 100);
        
        assertArrayEquals(new int[]{-3, -1, 0, 100, 100}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace with same new value")
    void testReplaceByCondition_SameNewValue() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        manipulatorService.replaceByCondition(arrayEntity, "=", 3, 3);
        
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace when no elements match condition")
    void testReplaceByCondition_NoMatches() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        manipulatorService.replaceByCondition(arrayEntity, ">", 10, 99);
        
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace when all elements match condition")
    void testReplaceByCondition_AllMatch() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        manipulatorService.replaceByCondition(arrayEntity, ">=", 1, 0);
        
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace with single element array")
    void testReplaceByCondition_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5});
        manipulatorService.replaceByCondition(arrayEntity, "=", 5, 10);
        
        assertArrayEquals(new int[]{10}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace with empty array")
    void testReplaceByCondition_EmptyArray() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{});
        manipulatorService.replaceByCondition(arrayEntity, ">", 5, 10);
        
        assertArrayEquals(new int[]{}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace with duplicate values")
    void testReplaceByCondition_DuplicateValues() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{2, 2, 2, 2, 2});
        manipulatorService.replaceByCondition(arrayEntity, "=", 2, 7);
        
        assertArrayEquals(new int[]{7, 7, 7, 7, 7}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Throw exception for unknown condition")
    void testReplaceByCondition_UnknownCondition() {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3});
        
        ArrayException exception = assertThrows(ArrayException.class,
            () -> manipulatorService.replaceByCondition(arrayEntity, "??", 2, 5));
        
        assertEquals("Unknown condition: ??", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception for invalid condition symbol")
    void testReplaceByCondition_InvalidCondition() {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3});
        
        ArrayException exception = assertThrows(ArrayException.class,
            () -> manipulatorService.replaceByCondition(arrayEntity, "$", 2, 5));
        
        assertEquals("Unknown condition: $", exception.getMessage());
    }

    @Test
    @DisplayName("Test with null ArrayEntity")
    void testReplaceByCondition_NullArrayEntity() {
        assertThrows(NullPointerException.class,
            () -> manipulatorService.replaceByCondition(null, "<", 5, 10));
    }

    @Test
    @DisplayName("Multiple sequential replacements")
    void testReplaceByCondition_MultipleReplacements() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        
        // First replacement
        manipulatorService.replaceByCondition(arrayEntity, "<", 3, 0);
        assertArrayEquals(new int[]{0, 0, 3, 4, 5}, arrayEntity.getArray());
        
        // Second replacement on modified array
        manipulatorService.replaceByCondition(arrayEntity, ">", 2, 9);
        assertArrayEquals(new int[]{0, 0, 9, 9, 9}, arrayEntity.getArray());
        
        // Third replacement
        manipulatorService.replaceByCondition(arrayEntity, "=", 0, -1);
        assertArrayEquals(new int[]{-1, -1, 9, 9, 9}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace with large numbers")
    void testReplaceByCondition_LargeNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1000, 2000, 3000, 4000});
        manipulatorService.replaceByCondition(arrayEntity, ">", 2500, 9999);
        
        assertArrayEquals(new int[]{1000, 2000, 9999, 9999}, arrayEntity.getArray());
    }

    @Test
    @DisplayName("Replace with negative new value")
    void testReplaceByCondition_NegativeNewValue() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        manipulatorService.replaceByCondition(arrayEntity, ">=", 4, -100);
        
        assertArrayEquals(new int[]{1, 2, 3, -100, -100}, arrayEntity.getArray());
    }
}