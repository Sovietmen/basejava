package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private final Resume resume1 = new Resume(UUID_1);
    private final Resume resume2 = new Resume(UUID_2);
    private final Resume resume3 = new Resume(UUID_3);

    ListStorage listStorage = new ListStorage();

    @BeforeEach
    void setUp() {
        listStorage.clear();
        listStorage.save(resume1);
        listStorage.save(resume2);
        listStorage.save(resume3);
    }

    @Test
    void clear() {
        listStorage.clear();
        assertEquals(0, listStorage.size());
    }

    @Test
    void save() {
        Resume resume4 = new Resume("new_resume");
        listStorage.save(resume4);
        assertEquals(resume4, listStorage.get("new_resume"));
    }

    @Test
    void savedExist() {
        assertThrows(ExistStorageException.class, () -> listStorage.save(resume1));
    }

    @Test
    void get() {
        assertEquals(resume1, listStorage.get(UUID_1));
    }

    @Test
    void gotNotExist() {
        assertThrows(NotExistStorageException.class, () -> listStorage.get("nope"));
    }

    @Test
    void delete() {
        listStorage.delete("uuid3");
        assertThrows(NotExistStorageException.class, () -> listStorage.get(UUID_3));
    }

    @Test
    void update() {
        Resume resume = listStorage.get(UUID_1);
        listStorage.update(resume);
        assertEquals(resume1, listStorage.get(UUID_1));
    }

    @Test
    void updateNotExist() {
        assertThrows(NotExistStorageException.class, () -> listStorage.update(new Resume("nope")));
    }

    @Test
    void size() {
        assertEquals(3, listStorage.size());
    }

}
