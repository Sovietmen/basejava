package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveResume(Resume resume, int key) {
        key = -(key) - 1;
        System.arraycopy(storage, key, storage, key + 1, size - key);
        storage[key] = resume;
    }

    @Override
    protected void deleteResume(int key) {
        if (size - 1 - key >= 0)
            System.arraycopy(storage, key + 1, storage, key, size - 1 - key);
    }

    @Override
    protected Object searchKey(String uuid) {
        Resume resume = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, resume);
    }
}
