package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean isExist(String uuid) {
        for (Resume resume : storage) {
            if (Objects.equals(resume.getUuid(), uuid)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void doSave(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void doDelete(String uuid) {
        storage.remove(storage.get(findIndex(uuid)));
    }

    @Override
    protected Resume doGet(String uuid) {
        return storage.get(findIndex(uuid));
    }

    @Override
    protected void doUpdate(Resume resume) {
        storage.set(findIndex(resume.getUuid()), resume);
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
    protected int findIndex(String uuid) {
        for (Resume resume : storage) {
            if (Objects.equals(resume.getUuid(), uuid)) return storage.indexOf(resume);
        }
        return -1;
    }
}
