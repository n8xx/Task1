package org.example.task1.service.validator.impl;

import org.example.task1.service.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.validator.ArrayValidator;

import java.util.regex.Pattern;


    public class ArrayValidationService implements ArrayValidator {

        public static final Logger logger = LogManager.getLogger(ArrayValidationService.class);
        public static final String REGEX = "^\\s*(-?\\d+)(\\s*[,;\\-\\s]\\s*-?\\d+)*\\s*$";

        // Дополнительные константы для валидации
        private static final String ID_REGEX = "^[a-zA-Z_][a-zA-Z0-9_]*$";
        private static final int MAX_ARRAY_LENGTH = 1000;
        private static final int MIN_NUMBER_VALUE = -1000000;
        private static final int MAX_NUMBER_VALUE = 1000000;

        @Override
        public boolean isLineValid(String line) throws ArrayException {
            if (line == null || line.trim().isEmpty()) {
                logger.info("Line is empty");
                return false;
            }

            Pattern pattern = Pattern.compile(REGEX);
            boolean isValid = pattern.matcher(line).matches();
                logger.info("validation of the line:"+isValid);

            return isValid;
        }

        /**
         * Валидация ID массива
         */
        public boolean isValidId(String id) {
            if (id == null || id.trim().isEmpty()) {
                logger.warn("ID is null or empty");
                return false;
            }

            boolean isValid = Pattern.matches(ID_REGEX, id);
            if (isValid) {
                logger.debug("ID '{}' is valid", id);
            } else {
                logger.warn("ID '{}' is not valid. ID must start with letter or underscore and contain only letters, numbers and underscores", id);
            }
            return isValid;
        }

        /**
         * Валидация отдельного числа
         */
        public boolean isValidNumber(int number) {
            boolean isValid = number >= MIN_NUMBER_VALUE && number <= MAX_NUMBER_VALUE;
            if (!isValid) {
                logger.warn("Number {} is out of allowed range [{}, {}]", number, MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);
            }
            return isValid;
        }

        /**
         * Валидация всего массива
         */
        public boolean isValidArray(int[] array) {
            if (array == null) {
                logger.warn("Array is null");
                return false;
            }

            if (array.length > MAX_ARRAY_LENGTH) {
                logger.warn("Array length {} exceeds maximum allowed length {}", array.length, MAX_ARRAY_LENGTH);
                return false;
            }

            // Проверяем каждое число в массиве
            for (int i = 0; i < array.length; i++) {
                if (!isValidNumber(array[i])) {
                    logger.warn("Array contains invalid number at index {}: {}", i, array[i]);
                    return false;
                }
            }

            logger.debug("Array with length {} is valid", array.length);
            return true;
        }

        /**
         * Валидация строки в формате "id:числа"
         */
        public boolean isValidEntityLine(String line) throws ArrayException {
            if (line == null || line.trim().isEmpty()) {
                logger.info("Line is empty");
                return false;
            }

            // Разделяем на ID и числа
            String[] parts = line.split(":", 2);
            if (parts.length != 2) {
                logger.warn("Invalid format. Expected 'id:numbers', got: {}", line);
                return false;
            }

            String id = parts[0].trim();
            String numbersPart = parts[1].trim();

            // Валидируем ID
            if (!isValidId(id)) {
                return false;
            }

            // Валидируем часть с числами
            if (!numbersPart.isEmpty() && !isLineValid(numbersPart)) {
                logger.warn("Numbers part is not valid: {}", numbersPart);
                return false;
            }

            logger.debug("Entity line is valid: {}", line);
            return true;
        }

        /**
         * Валидация с получением детальной информации об ошибке
         */
        public ValidationResult validateWithDetails(String line) {
            if (line == null) {
                return new ValidationResult(false, "Line is null");
            }

            if (line.trim().isEmpty()) {
                return new ValidationResult(false, "Line is empty");
            }

            String[] parts = line.split(":", 2);
            if (parts.length != 2) {
                return new ValidationResult(false, "Invalid format. Expected 'id:numbers'");
            }

            String id = parts[0].trim();
            String numbersPart = parts[1].trim();

            // Валидация ID
            if (id.isEmpty()) {
                return new ValidationResult(false, "ID is empty");
            }

            if (!Pattern.matches(ID_REGEX, id)) {
                return new ValidationResult(false,
                        "ID '" + id + "' is not valid. Must start with letter or underscore and contain only letters, numbers and underscores");
            }

            // Валидация чисел (если они есть)
            if (!numbersPart.isEmpty()) {
                if (!Pattern.matches(REGEX, numbersPart)) {
                    return new ValidationResult(false, "Numbers format is not valid: " + numbersPart);
                }

                // Дополнительная проверка на максимальное количество чисел
                String[] numberStrings = numbersPart.split("[,;\\-\\s]+");
                if (numberStrings.length > MAX_ARRAY_LENGTH) {
                    return new ValidationResult(false,
                            "Too many numbers: " + numberStrings.length + ", maximum allowed: " + MAX_ARRAY_LENGTH);
                }

                // Проверка диапазонов чисел
                for (String numStr : numberStrings) {
                    try {
                        int num = Integer.parseInt(numStr.trim());
                        if (num < MIN_NUMBER_VALUE || num > MAX_NUMBER_VALUE) {
                            return new ValidationResult(false,
                                    "Number " + num + " is out of allowed range [" + MIN_NUMBER_VALUE + ", " + MAX_NUMBER_VALUE + "]");
                        }
                    } catch (NumberFormatException e) {
                        return new ValidationResult(false, "Invalid number format: " + numStr);
                    }
                }
            }

            return new ValidationResult(true, "Valid");
        }

        /**
         * Получить максимально допустимую длину массива
         */
        public int getMaxArrayLength() {
            return MAX_ARRAY_LENGTH;
        }

        /**
         * Получить минимальное допустимое значение числа
         */
        public int getMinNumberValue() {
            return MIN_NUMBER_VALUE;
        }

        /**
         * Получить максимальное допустимое значение числа
         */
        public int getMaxNumberValue() {
            return MAX_NUMBER_VALUE;
        }

        /**
         * Результат валидации с детальным сообщением
         */
        public static class ValidationResult {
            private final boolean valid;
            private final String message;

            public ValidationResult(boolean valid, String message) {
                this.valid = valid;
                this.message = message;
            }

            public boolean isValid() {
                return valid;
            }

            public String getMessage() {
                return message;
            }

            @Override
            public String toString() {
                return "ValidationResult{valid=" + valid + ", message='" + message + "'}";
            }
        }
    }



