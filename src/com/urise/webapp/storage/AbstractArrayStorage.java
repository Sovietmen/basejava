package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int MAX_SIZE = 10_000;
    protected Resume[] storage = new Resume[MAX_SIZE];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doSave(Resume resume) {
        if (size >= MAX_SIZE) {
            throw new StorageException("storage is overflow", resume.getUuid());
        }
        saveResume(resume, findIndex(resume.getUuid()));
        size++;
    }

    @Override
    protected Resume doGet(String uuid, int index) {
        return storage[index];
    }

    @Override
    public void doDelete(String uuid, int index) {
        deleteResume(uuid, index);
        storage[size] = null;
        size--;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void doUpdate(Resume resume, int index) {
        storage[index] = resume;
    }

    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(String uuid) {
        int index = findIndex(uuid);
        return index >= 0;
    }

    protected abstract void saveResume(Resume resume, int index);

    protected abstract void deleteResume(String uuid, int index);
}
