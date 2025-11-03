package org.example.task1.service.parser.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.parser.ArrayEntityParser;
import org.example.task1.factory.ArrayEntityFactory;
import org.example.task1.service.validator.ArrayValidator;
import org.example.task1.service.validator.impl.ArrayValidationService;

import org.example.task1.service.reader.impl.ArrayReaderService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ArrayParserService implements ArrayEntityParser {
        private final static Logger logger = LogManager.getLogger();
        public final String SPLIT_REGEX = ":\\s+";
        public static final String NUMBERS_REGEX = "^\\s*(-?\\d+)(\\s*[,;\\-\\s]\\s*-?\\d+)*\\s*$";

        @Override
        public ArrayEntity parseEntityFromString(String line) throws ArrayException {
            ArrayValidator validator = new ArrayValidationService();
            if(validator.isLineValid(line)) {
                return ArrayEntityFactory.createWithData(parseIdFromString(line),parseArrayFromString(line));
            }
            return null;
        }
            public int[] parseArrayFromString(String line) throws ArrayException {
                String numberString = line.split(SPLIT_REGEX)[1].trim();
                ArrayValidator validator = new ArrayValidationService();
                if (numberString == null || numberString.isBlank()) {
                    logger.warn("Numbers string is empty");
                    return new int[0];
                }
                Pattern pattern = Pattern.compile(NUMBERS_REGEX);
                Matcher matcher = pattern.matcher(numberString);

                List<Integer> numberList = new ArrayList<>();

                while (matcher.find()) {
                    try {
                        String numberStr = matcher.group();
                        int number = Integer.parseInt(numberStr);

                        // Валидация числел
                        if (validator.isValidNumber(number)) {
                            numberList.add(number);
                            logger.debug("Parsed number: {}", number);

                        }else{
                            logger.error("Failed to parse number: {}", matcher.group());
                            throw new ArrayException("Failed to parse number: " + matcher.group());
                        }


                }catch (NumberFormatException e){
                        logger.error("Failed to parse number: {}", matcher.group());
                    }
                }
                if (numberList.isEmpty()) {
                    logger.warn("No valid numbers found in string: {}", line);
                    throw new ArrayException("No valid numbers found in string: " + line);
                }

                // Конвертируем List<Integer> в int[]
                int[] result = new int[numberList.size()];
                for (int i = 0; i < numberList.size(); i++) {
                    result[i] = numberList.get(i);
                }
                logger.debug("Successfully parsed {} numbers", result.length);
                return result;
            }
            public String parseIdFromString(String line) throws ArrayException {
                ArrayValidator validator = new ArrayValidationService();
                String id;
                if (line != null || line.isBlank()==false) {
                     id = line.split(SPLIT_REGEX)[0].trim();
                }else{
                    logger.warn("Ids string is empty"+line);
                    throw new ArrayException("Invalid id string"+line);
                }
                return id;
            }




    }