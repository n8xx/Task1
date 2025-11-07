package org.example.task1.validator;

import org.example.task1.validator.impl.ArrayValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineValidatorImplTest {

    private ArrayValidationService validator;

    @BeforeEach
    void setUp() {
        validator = new ArrayValidationService();
    }

    @Test
    void testValidLine() {
        String validLine1 = "arr: 1, 2, 3, 4";
        String validLine2 = "arr: -5;10;-15";

        assertAll(
                () -> assertTrue(validator.isLineValid(validLine1)),
                () -> assertTrue(validator.isLineValid(validLine2))
        );
    }

    @Test
    void testInvalidLine() {
        String invalidLine1 = "arr: abc, 123";
        String invalidLine2 = "arr: 1,,2,3";
        String invalidLine3 = "arr:1, 2, 3, ";
        String invalidLine4 = "";
        String invalidLine5 = null;

        assertAll(
                () -> assertFalse(validator.isLineValid(invalidLine1)),
                () -> assertFalse(validator.isLineValid(invalidLine2)),
                () -> assertFalse(validator.isLineValid(invalidLine3)),
                () -> assertFalse(validator.isLineValid(invalidLine4)),
                () -> assertFalse(validator.isLineValid(invalidLine5))
        );
    }
}