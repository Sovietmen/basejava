package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public final int MAX_SIZE = 10000;
    private Resume[] storage = new Resume[MAX_SIZE];
    private int size;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        boolean repeatIs = false;

        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == r.toString()) {
                repeatIs = true;
                System.out.println("ERROR: Resume is present at the storage.");
            }
            if (i == MAX_SIZE) {
                System.out.println("ERROR: storage have't free space.");
                break;
            }
        }
        if (!repeatIs) {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {

        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].toString()) {
                return storage[i];
            }
        }
        System.out.println("ERROR: Resume is absent at the storage.");
        return null;
    }

    public void delete(String uuid) {

        for (int i = 0; i <= size; i++) {
            if (uuid == storage[i].toString()) {
                for (int j = i; j < size - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                size--;
                break;
            }
            if ((i == size) && (uuid != storage[i].toString())) {
                System.out.println("ERROR: Resume is absent at the storage.");
            }
        }
    }

    public Resume[] getAll() {
        Resume[] allResume = new Resume[size];
        for (int i = 0; i < size; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.toString() == storage[i].toString()) {
                System.out.println("Resume " + resume.toString() + " is updated");
                break;
            }
            if ((i == size) && (resume.getUuid() != storage[i].toString())) {
                System.out.println("ERROR: Resume is absent at the storage.");
            }
        }
    }

    public int size() {
        return size;
    }
}
