package com.urise.webapp.exception;

public class ExistStorageExceprion extends StorageException {
    public ExistStorageExceprion(String uuid) {
        super("Resume " + uuid + " alredy exist", uuid);
    }
}
