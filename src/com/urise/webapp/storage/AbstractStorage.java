package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        if (isExist(searchKey(resume.getUuid()))) {
            throw new ExistStorageException(resume.getUuid());
        } else doSave(resume, searchKey(resume.getUuid()));

    }

    @Override
    public Resume get(String uuid) {
        if (isExist(searchKey(uuid))) {
            return doGet(searchKey(uuid));
        } else throw new NotExistStorageException(uuid);
    }

    @Override
    public void delete(String uuid) {
        if (!isExist(searchKey(uuid))) {
            throw new NotExistStorageException(uuid);
        } else doDelete(searchKey(uuid));
    }

    @Override
    public void update(Resume resume) {
        if (isExist(searchKey(resume.getUuid()))) {
            doUpdate(resume, searchKey(resume.getUuid()));
        } else throw new NotExistStorageException(resume.getUuid());
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doList();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> doList();

    protected abstract boolean isExist(Object key);

    protected abstract void doSave(Resume resume, Object key);

    protected abstract void doDelete(Object key);

    protected abstract Resume doGet(Object key);

    protected abstract void doUpdate(Resume resume, Object key);

    protected abstract Object searchKey(String uuid);
}
