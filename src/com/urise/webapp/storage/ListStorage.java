package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume resume) {
        if (storage.contains(resume)) {
            throw new ExistStorageException(resume.getUuid());
        } else storage.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        for (Resume r : storage) {
            if (Objects.equals(r.getUuid(), uuid)) {
                return r;
            }
        }
        throw new NotExistStorageException(uuid);
    }

    @Override
    public void delete(String uuid) {
        Iterator<Resume> iter = storage.iterator();
        while (iter.hasNext()) {
            Resume r = iter.next();
            if (Objects.equals(r.getUuid(), uuid)) {
                iter.remove();
            } else if (!iter.hasNext()) {
                throw new NotExistStorageException(uuid);
            }
        }
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) storage.toArray();
    }

    @Override
    public void update(Resume resume) {
        if (storage.contains(resume)) {
            storage.set(storage.indexOf(resume), resume);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public int size() {
        return storage.size();
    }
}
