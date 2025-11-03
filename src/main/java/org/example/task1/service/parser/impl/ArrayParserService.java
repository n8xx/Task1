package org.example.task1.service.parser.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.exception.ArrayException;
import org.example.task1.service.parser.ArrayEntityParser;
import org.example.task1.service.validator.impl.ArrayValidationService;


import java.util.List;


    public class ArrayParserService implements ArrayEntityParser {
        private final static Logger logger = LogManager.getLogger();
        private final String SPLIT_REGEX = ",\\s+";

        @Override
        public int[] parseString(List<String> arrayList) throws ArrayException {
            logger.info("Method for parsing String is called");
            int[] arrayInt = null;
            ArrayValidationService arrayValidationService = new ArrayValidationService();
            for (String s : arrayList) {
                if (arrayValidationService.isLineValid(s)) {

                    String[] elements = s.split(SPLIT_REGEX);
                    arrayInt = new int[elements.length];
                    for (int i = 0; i < elements.length; i++) {
                        arrayInt[i] = Integer.parseInt(elements[i]);
                    }
                }

            }
            return arrayInt;
        }


}