package org.example.task1.repository;

import org.example.task1.entity.ArrayEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;



public class ArrayRepository {
    private static ArrayRepository instance;

    private final Map<String, ArrayEntity> entities;


    // Приватный конструктор для Singleton
    private ArrayRepository() {
        this.entities = new ConcurrentHashMap<>();
    }



    public void save(ArrayEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }

        boolean isUpdate = entities.containsKey(entity.getId());
        entities.put(entity.getId(), entity);

    /**

    public Optional<ArrayEntity> findById(String id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(entities.get(id));
    }

    /**
     * Получение всех entities
     */
    public List<ArrayEntity> findAll() {
        return new ArrayList<>(entities.values());
    }

    /**
     * Удаление entity по ID
     */
    public boolean deleteById(String id) {
        if (id == null) {
            return false;
        }

        ArrayEntity removed = entities.remove(id);
        if (removed != null) {
            return true;
        }
        return false;
    }

    /**
     * Проверка существования entity по ID
     */
    public boolean existsById(String id) {
        return id != null && entities.containsKey(id);
    }

    /**
     * Получение количества entities
     */
    public int count() {
        return entities.size();
    }

    /**
     * Очистка репозитория
     */
    public void clear() {
        List<ArrayEntity> allEntities = new ArrayList<>(entities.values());
        entities.clear();
        for (ArrayEntity entity : allEntities) {
        }
    }
}

