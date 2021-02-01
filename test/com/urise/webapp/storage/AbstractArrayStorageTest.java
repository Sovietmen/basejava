package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageExceprion;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void get() {
        assertEquals(UUID_2, storage.get(UUID_2).toString());
    }

    @Test
    void getAll() {
        Resume[] resumes = storage.getAll();
        boolean result = true;
        for (Resume resume : resumes) {
            result = result && ((resume.getUuid().equals(UUID_1)) || (resume.getUuid().equals(UUID_2)) || (resume.getUuid().equals(UUID_3)));
        }
        assertEquals(true, result);
    }

    @Test
    void update() {
        Resume resume = storage.get(UUID_2);
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_2));
    }

    @Test
    void save() {
        storage.save(new Resume("testUUID"));
        assertEquals("testUUID", storage.get("testUUID").toString());
    }

    @Test
    void delete() {
        int sizeBefore = storage.size() - 1;
        storage.delete(UUID_2);
        assertEquals(sizeBefore, storage.size());
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }

    @Test
    void overflow() {
        storage.clear();
        int maxSize = 10_000;
        try {
            for (int i = 0; i < maxSize; i++) {
                storage.save(new Resume("uuid" + (i + 1)));
            }
            assertEquals(10_000, storage.size());
        } catch (StorageException exception) {
            fail("Overflow is too early");
        }
    }

    @Test
    @DisplayName("getNotExist(): Expect NotExistStorageException")
    void getNotExist() {
        Exception exGet = assertThrows(NotExistStorageException.class, () -> storage.get("Jack"));
        Exception exDel = assertThrows(NotExistStorageException.class, () -> storage.delete("Jack"));
    }

    @Test
    @DisplayName("getNotExist(): Expect ExistStorageException")
    void getExist() {
        Exception exGet = assertThrows(ExistStorageExceprion.class, () -> storage.save(new Resume("uuid1")));
    }
}