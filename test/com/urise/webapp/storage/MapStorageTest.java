package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private final Resume resume1 = new Resume(UUID_1);
    private final Resume resume2 = new Resume(UUID_2);
    private final Resume resume3 = new Resume(UUID_3);

    MapStorage mapStorage = new MapStorage();

    @BeforeEach
    void setUp() {
        mapStorage.clear();
        mapStorage.save(resume1);
        mapStorage.save(resume2);
        mapStorage.save(resume3);
    }

    @Test
    void clear() {
        mapStorage.clear();
        assertEquals(0, mapStorage.size());
    }

    @Test
    void save() {
        Resume resume4 = new Resume("new_resume");
        mapStorage.save(resume4);
        assertEquals(resume4, mapStorage.get("new_resume"));
    }

    @Test
    void savedExist() {
        assertThrows(ExistStorageException.class, () -> mapStorage.save(resume1));
    }

    @Test
    void get() {
        assertEquals(resume1, mapStorage.get(UUID_1));
    }

    @Test
    void gotNotExist() {
        assertThrows(NotExistStorageException.class, () -> mapStorage.get("nope"));
    }

    @Test
    void delete() {
        mapStorage.delete("uuid3");
        assertThrows(NotExistStorageException.class, () -> mapStorage.get(UUID_3));
    }

    @Test
    void update() {
        Resume resume = mapStorage.get(UUID_1);
        mapStorage.update(resume);
        assertEquals(resume1, mapStorage.get(UUID_1));
    }

    @Test
    void updateNotExist() {
        assertThrows(NotExistStorageException.class, () -> mapStorage.update(new Resume("nope")));
    }

    @Test
    void size() {
        assertEquals(3, mapStorage.size());
    }

}
