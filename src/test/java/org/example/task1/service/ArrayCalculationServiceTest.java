package org.example.task1.service;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.calculator.impl.ArrayCalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculationServiceTest {

    private ArrayCalculationService calculationService;
    private ArrayEntity arrayEntity;

    @BeforeEach
    void setUp() {
        calculationService = new ArrayCalculationService();
    }

    @Test
    @DisplayName("Calculate average with positive numbers")
    void testCalculateAverage_PositiveNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        double result = calculationService.calculateAverage(arrayEntity);
        assertEquals(3.0, result, 0.001);
    }

    @Test
    @DisplayName("Calculate average with negative numbers")
    void testCalculateAverage_NegativeNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-1, -2, -3, -4, -5});
        double result = calculationService.calculateAverage(arrayEntity);
        assertEquals(-3.0, result, 0.001);
    }

    @Test
    @DisplayName("Calculate average with mixed numbers")
    void testCalculateAverage_MixedNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-2, 0, 4, 8});
        double result = calculationService.calculateAverage(arrayEntity);
        assertEquals(2.5, result, 0.001);
    }

    @Test
    @DisplayName("Calculate average with single element")
    void testCalculateAverage_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{5});
        double result = calculationService.calculateAverage(arrayEntity);
        assertEquals(5.0, result, 0.001);
    }

    @Test
    @DisplayName("Calculate average throws exception for empty array")
    void testCalculateAverage_EmptyArray() {
        arrayEntity = new ArrayEntity("arr1",new int[]{});
        ArrayException exception = assertThrows(ArrayException.class,
            () -> calculationService.calculateAverage(arrayEntity));
        assertEquals("Array is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Calculate sum with positive numbers")
    void testCalculateSum_PositiveNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3, 4, 5});
        int result = calculationService.calculateSum(arrayEntity);
        assertEquals(15, result);
    }

    @Test
    @DisplayName("Calculate sum with negative numbers")
    void testCalculateSum_NegativeNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-1, -2, -3, -4, -5});
        int result = calculationService.calculateSum(arrayEntity);
        assertEquals(-15, result);
    }

    @Test
    @DisplayName("Calculate sum with mixed numbers")
    void testCalculateSum_MixedNumbers() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{-5, 10, -3, 8});
        int result = calculationService.calculateSum(arrayEntity);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Calculate sum with single element")
    void testCalculateSum_SingleElement() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{7});
        int result = calculationService.calculateSum(arrayEntity);
        assertEquals(7, result);
    }

    @Test
    @DisplayName("Calculate sum throws exception for empty array")
    void testCalculateSum_EmptyArray() {
        arrayEntity = new ArrayEntity("arr1",new int[]{});
        ArrayException exception = assertThrows(ArrayException.class,
            () -> calculationService.calculateSum(arrayEntity));
        assertEquals("Array is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Calculate positive elements - returns 0 (not implemented)")
    void testCalculatePositiveElem_NotImplemented() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, -2, 3, -4, 5});
        int result = calculationService.calculatePositiveElem(arrayEntity);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Calculate negative elements - returns 0 (not implemented)")
    void testCalculateNegativeElem_NotImplemented() throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",new int[]{1, -2, 3, -4, 5});
        int result = calculationService.calculateNegativeElem(arrayEntity);
        assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("provideArraysForAverage")
    @DisplayName("Parameterized test for calculateAverage")
    void testCalculateAverage_Parameterized(int[] input, double expected) throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",input);
        double result = calculationService.calculateAverage(arrayEntity);
        assertEquals(expected, result, 0.001);
    }

    @ParameterizedTest
    @MethodSource("provideArraysForSum")
    @DisplayName("Parameterized test for calculateSum")
    void testCalculateSum_Parameterized(int[] input, int expected) throws ArrayException {
        arrayEntity = new ArrayEntity("arr1",input);
        int result = calculationService.calculateSum(arrayEntity);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideArraysForAverage() {
        return Stream.of(
            Arguments.of(new int[]{2, 4, 6}, 4.0),
            Arguments.of(new int[]{0, 0, 0}, 0.0),
            Arguments.of(new int[]{10}, 10.0),
            Arguments.of(new int[]{-1, 1}, 0.0)
        );
    }

    private static Stream<Arguments> provideArraysForSum() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 1}, 3),
            Arguments.of(new int[]{0, 0, 0}, 0),
            Arguments.of(new int[]{100}, 100),
            Arguments.of(new int[]{-2, 2, -2}, -2)
        );
    }

    @Test
    @DisplayName("Test with null ArrayEntity")
    void testWithNullArrayEntity() {
        assertThrows(NullPointerException.class,
            () -> calculationService.calculateAverage(null));
    }
}