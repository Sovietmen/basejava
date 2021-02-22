package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Resume> iter = storage.iterator();
        while (iter.hasNext()) {
            Resume r = iter.next();
            if (Objects.equals(r.getUuid(), uuid)) iter.remove();
        }
    }

    @Override
    protected Resume doGet(String uuid) {
        for (Resume resume : storage) {
            if (Objects.equals(resume.getUuid(), uuid)) return resume;
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume resume) {
        for (Resume res : storage) {
            if (Objects.equals(resume.getUuid(), res.getUuid())) storage.set(storage.indexOf(res), resume);
        }
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
}
