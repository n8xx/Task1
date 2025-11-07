package org.example.task1.repository;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.repository.specification.ArraySpecification;
import org.example.task1.repository.ArrayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayEntityRepositoryTest {

    private ArrayRepository repository;

    @BeforeEach
    void setUp() {
        repository = ArrayRepository.getInstance();
    }

    @Test
    void testAddAndRemove() throws ArrayException {
        ArrayEntity arrayEntity = new ArrayEntity("arr1",new int[]{1, 2, 3});
        repository.addArray(arrayEntity);
        assertTrue(repository.sortArray(Comparator.comparing(ArrayEntity::getId)).contains(arrayEntity));

        repository.removeArray(arrayEntity);
        assertFalse(repository.sortArray(Comparator.comparing(ArrayEntity::getId)).contains(arrayEntity));

    }

    @Test
    void testAddNullThrowsException() {
        assertThrows(ArrayException.class, () -> repository.addArray(null));
    }

    @Test
    void testRemoveNullThrowsException() {
        assertThrows(ArrayException.class, () -> repository.removeArray(null));
    }

    @Test
    void testSort() throws ArrayException {
        ArrayEntity a1 = new ArrayEntity("arr1",new int[]{1, 2});
        ArrayEntity a2 = new ArrayEntity("arr2",new int[]{10, 20, 30});
        repository.addArray(a1);
        repository.addArray(a2);

        List<ArrayEntity> sorted = repository.sortArray(Comparator.comparingInt(arr -> arr.getArray().length));
        assertEquals(a1, sorted.get(0));
        assertEquals(a2, sorted.get(1));

        repository.removeArray(a1);
        repository.removeArray(a2);
    }

    @Test
    void testQuery() throws ArrayException {
        ArrayEntity a1 = new ArrayEntity("arr1", new int[]{1, 2, 3});
        ArrayEntity a2 = new ArrayEntity("arr2",new int[]{5, 5, 5});
        repository.addArray(a1);
        repository.addArray(a2);

        ArraySpecification hasFive = arr -> {
            for (int num : arr.getArray()) {
                if (num == 5) return true;
            }
            return false;
        };

        List<ArrayEntity> result = repository.query(hasFive);
        assertEquals(1, result.size());
        assertTrue(result.contains(a2));

        repository.removeArray(a1);
        repository.removeArray(a2);
    }
}