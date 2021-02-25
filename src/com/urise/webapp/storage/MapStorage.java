package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExist(String uuid) {
        return storage.containsKey(uuid);
    }

    @Override
    protected void doSave(Resume resume, int index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(String uuid, int index) {
        storage.remove(uuid);
    }

    @Override
    protected Resume doGet(String uuid, int index) {
        return storage.get(uuid);
    }

    @Override
    protected void doUpdate(Resume resume, int index) {
        storage.replace(resume.getUuid(), storage.get(resume.getUuid()), resume);
    }

    @Override
    protected int findIndex(String uuid) {
        return storage.get(uuid).hashCode();
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
