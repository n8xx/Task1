package org.example.task1.repository.impl;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.factory.ArrayEntityFactory;
import org.example.task1.service.validator.impl.ArrayValidationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.repository.ArrayRepository;
import org.example.task1.service.parser.impl.ArrayParserService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static ArrayRepositoryImpl instance;
    private final static Logger logger = LogManager.getLogger();
    private List<ArrayEntity> arrays;
    private final ArrayValidationService validator;
    private ArrayRepositoryImpl() {
        arrays = new ArrayList<ArrayEntity>();
        validator = new ArrayValidationService();
    }
    public static ArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArrayRepositoryImpl();
        }
        logger.info("Create an Array Repository");
        return instance;
    }
    @Override
    public void addArray(ArrayEntity array) throws ArrayException {
        logger.info("Called a method for adding an array");
        if(!validator.isValidArray(array.getArray())) {
            logger.error("Array is not valid");
            throw new ArrayException("Array is not valid");
        }
        arrays.add(array);
    }
    @Override
    public void removeArray(int id) throws ArrayException {
        logger.info("Called a method for removing an array");
        ArrayEntity array = arrays.get(id);
        if(!validator.isValidArray(array.getArray())) {
            logger.error("No such array");
            throw new ArrayException("Array is not valid");
        }
        arrays.remove(array);
    }
    @Override
    public ArrayEntity getArrayById(String id) {
        logger.info("Called a method for getting an array by id");
        for (ArrayEntity array : arrays) {
            if(array.getId().equals(id)) {
                return array;
            }
        }
        logger.warn("There's no array with index" + id);
        return null;
    }
    @Override
    public List<ArrayEntity> getAllArrays() throws ArrayException {
        logger.info("Called a method for getting all arrays");
        return new ArrayList<>(arrays);
    }

    public List<ArrayEntity> sortArray(Comparator<ArrayEntity> comparator) {
        logger.info("Called a method for sorting arrays");
        List<ArrayEntity> sorted = new ArrayList<>(arrays);
        sorted.sort(comparator);
        return sorted;
    }
}