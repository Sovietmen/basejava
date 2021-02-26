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
    protected void doSave(Resume resume, Object key) {
        if (size >= MAX_SIZE) {
            throw new StorageException("storage is overflow", resume.getUuid());
        }
        saveResume(resume, (int) key);
        size++;
    }

    @Override
    protected Resume doGet(Object key) {
        return storage[(int) key];
    }

    @Override
    public void doDelete(Object key) {
        deleteResume((int) key);
        storage[size] = null;
        size--;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void doUpdate(Resume resume, Object key) {
        storage[(int) key] = resume;
    }

    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(String uuid) {
        int searchKey = (int) searchKey(uuid);
        return searchKey >= 0;
    }

    protected abstract void saveResume(Resume resume, int key);

    protected abstract void deleteResume(int key);
}
