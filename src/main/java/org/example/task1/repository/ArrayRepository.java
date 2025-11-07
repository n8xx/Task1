package org.example.task1.repository;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.repository.specification.ArraySpecification;
import org.example.task1.validator.impl.ArrayValidationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepository {
    private static ArrayRepository instance;
    private final static Logger logger = LogManager.getLogger();
    private List<ArrayEntity> arrays;
    private final ArrayValidationService validator;
    private ArrayRepository() {
        arrays = new ArrayList<ArrayEntity>();
        validator = new ArrayValidationService();
    }
    public static ArrayRepository getInstance() {
        if (instance == null) {
            instance = new ArrayRepository();
        }
        logger.info("Create an Array Repository");
        return instance;
    }
    public void addArray(ArrayEntity arrayEntity) throws ArrayException {
        logger.info("Called a method for adding an array");
        if(validator.isValidEntity(arrayEntity)){
            arrays.add(arrayEntity);
        }else {
            logger.error("Entity is not valid");
            throw new ArrayException("Entity is not valid");
        }
    }
    public void removeArray(ArrayEntity arrayEntity) throws ArrayException {
        logger.info("Called a method for removing an array");
        if(validator.isValidEntity(arrayEntity)) {
            arrays.remove(arrayEntity);
        }else {
            logger.error("No such array");
            throw new ArrayException("Array is not valid");
        }
    }
    public ArrayEntity getArrayById(String id) {
        logger.info("Called a method for getting an array by id");
        for (ArrayEntity arrayEntity : arrays) {
            if(arrayEntity.getId().equals(id)) {
                return arrayEntity;
            }
        }
        logger.warn("There's no array with index" + id);
        return null;
    }
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
    public List<ArrayEntity> query(ArraySpecification specification) throws ArrayException {
        logger.info("Starting query operation with specification: {}",
                specification != null ? specification.getClass().getSimpleName() : "null");
        List<ArrayEntity> list = new ArrayList<>();
        for (ArrayEntity array : arrays) {
            if (specification.specify(array)) {
                list.add(array);
            }
        }
        return list;
    }
}