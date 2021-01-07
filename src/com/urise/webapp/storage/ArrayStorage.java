package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public final int MAX_SIZE = 10_000;
    private Resume[] storage = new Resume[MAX_SIZE];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (find(resume.getUuid()) >= 0) {
            System.out.println("ERROR: Resume " + resume.getUuid() + " is present at the storage.");
        } else if (size > MAX_SIZE) {
            System.out.println("ERROR: storage is overspace.");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        if (find(uuid) >= 0) {
            return storage[find(uuid)];
        } else {
            System.out.println("ERROR: Resume " + uuid + " is absent at the storage.");
            return null;
        }
    }

    public void delete(String uuid) {
        if (find(uuid) >= 0) {
            for (int j = find(uuid); j < size - 1; j++) {
                storage[j] = storage[j + 1];
            }
            size--;
        } else {
            System.out.println("ERROR: Resume " + uuid + " is absent at the storage.");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void update(Resume resume) {
        if (find(resume.getUuid()) >= 0) {
            storage[find(resume.getUuid())] = resume;
            System.out.println("Resume " + resume.getUuid() + " is updated");
        } else {
            System.out.println("ERROR: Resume " + resume.getUuid() + " is absent at the storage.");
        }
    }

    public int size() {
        return size;
    }

    /*
    method of searching resume by uuid: if resume with specified uuid is in the storage,
    return position resume at the storage else return -1
     */
    private int find(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
