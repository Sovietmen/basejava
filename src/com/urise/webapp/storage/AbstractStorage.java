package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    protected static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    @Override
    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK key = searchKey(resume.getUuid());
        if (isExist(key)) {
            LOG.warning("Resume " + resume.getUuid() + " alredy exist");
            throw new ExistStorageException(resume.getUuid());
        } else doSave(resume, key);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        return doGet(getSarchKeyIfExist(uuid));
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        doDelete(getSarchKeyIfExist(uuid));
    }

    @Override
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        doUpdate(resume, getSarchKeyIfExist(resume.getUuid()));
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("GetAllSorted ");
        List<Resume> list = doList();
        
       final Comparator<Resume> COMPARATOR_RESUME = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);
		
		list.sort(COMPARATOR_RESUME);
        return list;
    }

    private SK getSarchKeyIfExist(String uuid) {
        SK key = searchKey(uuid);
        if (!isExist(key)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected abstract List<Resume> doList();

    protected abstract boolean isExist(SK key);

    protected abstract void doSave(Resume resume, SK key);

    protected abstract void doDelete(SK key);

    protected abstract Resume doGet(SK key);

	protected abstract void doUpdate(Resume resume, SK key);

	protected abstract SK searchKey(String uuid);
}
