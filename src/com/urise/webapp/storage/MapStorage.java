package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExist(Object key) {
        return storage.containsKey(key);
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        storage.put((String) key, resume);
    }

    @Override
    protected void doDelete(Object key) {
        storage.remove(key);
    }

    @Override
    protected Resume doGet(Object key) {
        return storage.get(key);
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        storage.replace(resume.getUuid(), storage.get(resume.getUuid()), resume);
    }

    @Override
    protected Object searchKey(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Object[] getAll() {
        return storage.values().toArray();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
