package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int indexOfResume = findIndex(resume.getUuid());
        if (indexOfResume >= 0) {
            System.out.println("ERROR: Resume " + resume.getUuid() + " is present at the storage.");
        } else if (size >= MAX_SIZE) {
            System.out.println("ERROR: storage is overspace.");
        } else if (indexOfResume < 0) {
            indexOfResume = -(indexOfResume) - 1;
            System.arraycopy(storage, indexOfResume, storage, indexOfResume + 1, size - indexOfResume);
            storage[indexOfResume] = resume;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int indexOfResume = findIndex(uuid);
        if (indexOfResume >= 0) {
            System.arraycopy(storage, indexOfResume + 1, storage, indexOfResume, size - indexOfResume);
            size--;
        } else {
            System.out.println("ERROR: Resume " + uuid + " is absent at the storage.");
        }
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
