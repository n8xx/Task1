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
        // Уведомляем наблюдателей об изменении
        //ArrayRepository.getInstance().notifyArrayChanged(this);
    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
            // Уведомляем наблюдателей об изменении
            //ArrayRepository.getInstance().notifyArrayChanged(this);
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
        return Objects.equals(id, that.id) && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayEntity{id='" + id + "', array=" + Arrays.toString(array) + "}";
    }
}