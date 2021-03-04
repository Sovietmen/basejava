package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean isExist(Object key) {
            return ((int) key >= 0);
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        storage.add(resume);
    }

    @Override
    protected void doDelete(Object key) {
        storage.remove(storage.get((int) key));
    }

    @Override
    protected Resume doGet(Object key) {
        return storage.get((int) key);
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        storage.set((int) key, resume);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Object[] getAll() {
        return storage.toArray();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object searchKey(String uuid) {
        return storage.indexOf(new Resume(uuid));
    }
}
