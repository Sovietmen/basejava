package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {
        if (findIndex(resume.getUuid()) >= 0) {
            System.out.println("ERROR: Resume " + resume.getUuid() + " is present at the storage.");
        } else if (size >= MAX_SIZE) {
            System.out.println("ERROR: storage is overspace.");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void delete(String uuid) {
        int findResult = findIndex(uuid);
        if (findResult >= 0) {
            if (size - 1 - findResult >= 0)
                System.arraycopy(storage, findResult + 1, storage, findResult, size - 1 - findResult);
            size--;
        } else {
            System.out.println("ERROR: Resume " + uuid + " is absent at the storage.");
        }
    }

    public void update(Resume resume) {
        int findResult = findIndex(resume.getUuid());
        if (findResult >= 0) {
            storage[findResult] = resume;
            System.out.println("Resume " + resume.getUuid() + " is updated");
        } else {
            System.out.println("ERROR: Resume " + resume.getUuid() + " is absent at the storage.");
        }
    }

    /*
    method of searching resume by uuid: if resume with specified uuid is in the storage,
    return position resume at the storage else return -1
     */
    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
