package org.example.task1.entity;

import java.util.Arrays;
import java.util.Objects;


public class ArrayEntity {
    private final String id;
    private int[] array;

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

    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
            
        }
    }

    public int getLength() {
        return array.length;
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