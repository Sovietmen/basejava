package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected final int MAX_SIZE = 10_000;
    protected Resume[] storage = new Resume[MAX_SIZE];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        int findResult = findIndex(uuid);
        if (findResult >= 0) {
            return storage[findResult];
        }
        System.out.println("ERROR: Resume " + uuid + " is absent at the storage.");
        return null;
    }

    protected abstract int findIndex(String uuid);

    public int size() {
        return size;
    }
}
