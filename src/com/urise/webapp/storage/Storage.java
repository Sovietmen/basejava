package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public interface Storage {
    void clear();

    void save(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    void update(Resume resume);

    int size();
}
