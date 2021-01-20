package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

	@Override
	protected int findIndex(String uuid) {
		for (int i = 0; i < size; i++) {
			if (uuid.equals(storage[i].getUuid())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	protected void deleteUnit(String uuid, int index) {
		System.arraycopy(storage, index + 1, storage, index, size);
	}

	@Override
	protected void saveUnit(Resume resume, int index) {
		storage[size] = resume;
	}
}
