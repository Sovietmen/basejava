package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveMethod(Resume resume) {
        int indexOfResume = findIndex(resume.getUuid());
        indexOfResume = -(indexOfResume) - 1;
        System.arraycopy(storage, indexOfResume, storage, indexOfResume + 1, size - indexOfResume);
        storage[indexOfResume] = resume;
        size++;
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
