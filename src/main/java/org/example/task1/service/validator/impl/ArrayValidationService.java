package org.example.task1.service.validator.impl;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.service.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.validator.ArrayValidator;

import java.nio.file.Path;
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
            if (line == null || line.isBlank()) {
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
            if (id == null || id.isEmpty()) {
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
                }
            }

            logger.debug("Array with length {} is valid", array.length);
            return true;
        }

        public boolean isValidEntity(ArrayEntity arrayEntity) throws ArrayException {
            if(isLineValid(arrayEntity.getId()) == true) {
                return isValidArray(arrayEntity.getArray());
            }
            return false;
        }

        public boolean isValidFilePath(String filePath) throws ArrayException {
            if (filePath == null || filePath.isBlank()) {
                logger.warn("File path is null or empty");
                return false;
            }
            Path path = Path.of(filePath).normalize();
            return true;
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


    }



