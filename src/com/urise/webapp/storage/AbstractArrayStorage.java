package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int MAX_SIZE = 10_000;
    protected Resume[] storage = new Resume[MAX_SIZE];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doSave(Resume resume, Integer key) {
        if (size >= MAX_SIZE) {
            throw new StorageException("storage is overflow ", resume.getUuid());
        }
        saveResume(resume, key);
        size++;
    }

    @Override
    protected Resume doGet(Integer key) {
        return storage[key];
    }

    @Override
    public void doDelete(Integer key) {
        deleteResume(key);
        storage[size] = null;
        size--;
    }

    @Override
    public List<Resume> doList() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    public void doUpdate(Resume resume, Integer key) {
        storage[key] = resume;
    }

    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(Integer key) {
        return  key >= 0;
    }

    protected abstract void saveResume(Resume resume, int key);

    protected abstract void deleteResume(int key);
}
