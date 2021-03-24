package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        Object key = searchKey(resume.getUuid());
        if (isExist(key)) {
            throw new ExistStorageException(resume.getUuid());
        } else doSave(resume, key);
    }

    @Override
    public Resume get(String uuid) {
        return doGet(getSarchKeyIfExist(uuid));
    }

    @Override
    public void delete(String uuid) {
        doDelete(getSarchKeyIfExist(uuid));
    }

    @Override
    public void update(Resume resume) {
        doUpdate(resume, getSarchKeyIfExist(resume.getUuid()));
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doList();
        
       final Comparator<Resume> COMPARATOR_RESUME = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);
		
		list.sort(COMPARATOR_RESUME);
        return list;
    }

    private Object getSarchKeyIfExist(String uuid) {
        Object key = searchKey(uuid);
        if (!isExist(key)) throw new NotExistStorageException(uuid);
        return key;
    }

    protected abstract List<Resume> doList();

    protected abstract boolean isExist(Object key);

    protected abstract void doSave(Resume resume, Object key);

    protected abstract void doDelete(Object key);

    protected abstract Resume doGet(Object key);

	protected abstract void doUpdate(Resume resume, Object key);

	protected abstract Object searchKey(String uuid);
}
