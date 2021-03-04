package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{
    private Storage storage;

    AbstractArrayStorageTest(Storage storage) {
        super(storage);
        this.storage = storage;
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