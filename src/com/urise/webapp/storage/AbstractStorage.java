package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        if (isExist(resume.getUuid())) {
            throw new ExistStorageException(resume.getUuid());
        } else doSave(resume);

    }

    @Override
    public Resume get(String uuid) {
        if (isExist(uuid)) {
            return doGet(uuid);
        } else throw new NotExistStorageException(uuid);
    }

    @Override
    public void delete(String uuid) {
        if (!isExist(uuid)) {
            throw new NotExistStorageException(uuid);
        } else doDelete(uuid);
    }

    @Override
    public void update(Resume resume) {
        if (isExist(resume.getUuid())) {
            doUpdate(resume);
        } else throw new NotExistStorageException(resume.getUuid());
    }

    protected abstract boolean isExist(String uuid);

    protected abstract void doSave(Resume resume);

    protected abstract void doDelete(String uuid);

    protected abstract Resume doGet(String uuid);

    protected abstract void doUpdate(Resume resume);

    protected abstract int findIndex(String uuid);
}
