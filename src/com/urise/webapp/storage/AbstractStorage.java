package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume){

    }

    public Resume get(String uuid){
        return null;
    }

    public void delete(String uuid){

    }

    public Object[] getAll(){

        return new Object[0];
    }

    public void update(Resume resume){

    }

    public int size(){

        return 0;
    }

    protected void isExist(Resume r, int index) {

    }
}
