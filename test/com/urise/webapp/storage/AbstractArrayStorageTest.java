package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private final Resume resume1 = new Resume(UUID_1);
    private final Resume resume2 = new Resume(UUID_2);
    private final Resume resume3 = new Resume(UUID_3);

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }
    
    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void get() {
        assertEquals(resume2, storage.get(UUID_2));
    }

    @Test
    void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get("someID"));
    }

    @Test
    void getAll() {
        Resume[] resumes = (Resume[]) storage.getAll();
        assertEquals(resume1, resumes[0]);
        assertEquals(resume2, resumes[1]);
        assertEquals(resume3, resumes[2]);
    }

    @Test
    void update() {
        Resume resume = storage.get(UUID_2);
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_2));
    }

    @Test
    void updatedNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.update(new Resume("someID")));
    }

    @Test
    void saveNew() {
        Resume resume = new Resume("testUUID");
        storage.save(resume);
        assertEquals(resume, storage.get("testUUID"));
        assertEquals(4, storage.size());
    }

    @Test
    void saveExist() {
        assertThrows(ExistStorageException.class, () -> storage.save(resume1));
    }

    @Test
    void delete() {
        storage.delete(UUID_2);
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_2));
        assertEquals(2, storage.size());
    }

    @Test
    void deleteNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.delete("someID"));
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }

    @Test
    void overflow() {
        storage.clear();
        int maxSize = AbstractArrayStorage.MAX_SIZE;
        try {
            for (int i = 0; i < maxSize; i++) {
                storage.save(new Resume("uuid" + (i + 1)));
            }
        } catch (StorageException exception) {
            fail("Overflow is too early");
        }
        assertThrows(StorageException.class, () -> storage.save(new Resume("lastUUID")));
    }
}