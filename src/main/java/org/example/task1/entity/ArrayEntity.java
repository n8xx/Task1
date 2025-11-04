package org.example.task1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.observer.ArrayObserver;
import org.example.task1.observer.impl.ArrayStatsObserver;
import org.example.task1.observer.ArrayObservable;

import java.util.Arrays;
import java.util.List;


public class ArrayEntity implements ArrayObservable {
    public final static Logger logger = LogManager.getLogger();
    private final String id;
    private int[] array;
    private ArrayStatsObserver observer;

    public ArrayEntity(String id, int[] array) {
        this.id = id;
        this.array = array != null ? array.clone() : new int[0];
    }
    public ArrayEntity(String id, int length) {
        this.id = id;
        this.array = new int[length];
    }

    public String getId() {
        return id;
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array != null ? array.clone() : new int[0];
        notifyObservers(observer);
    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
            
        }
        notifyObservers(observer);
    }

    public int getLength() {
        return array.length;
    }

    @Override
    public void attach(ArrayStatsObserver observer) {
        logger.info("An observer has been attached to an array");
        this.observer = observer;
    }

    @Override
    public void detach(ArrayStatsObserver observer) {
        logger.info("An observer has been detached to an array");
        this.observer = null;
    }
    @Override
    public void notifyObservers( ArrayStatsObserver observer){
        if (observer != null){
            observer.onArrayChanged(this);
            logger.info("Observers have been notified");

        }
    }


    @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayEntity that = (ArrayEntity) o;
        if (that.getArray().length != array.length){
            return false;
        }
        for (int i = 0; i < that.getArray().length; i++) {
            if (array[i] != that.getArray()[i]){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 7;
        for (int i = 0; i < array.length; i++) {
            hashCode = 31 * hashCode + array[i] * 2 ^ i;
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return "ArrayEntity{id='" + id + "', array=" + Arrays.toString(array) + "}";
    }
}