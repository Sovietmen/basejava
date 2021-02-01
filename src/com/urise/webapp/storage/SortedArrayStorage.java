package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

	@Override
	protected void saveUnit(Resume resume, int index) {
		index = -(index) - 1;
		System.arraycopy(storage, index, storage, index + 1, size - index);
		storage[index] = resume;
	}

	@Override
	protected void deleteUnit(String uuid, int index) {
		if (size - 1 - index >= 0)
			System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
	}

	@Override
	protected int findIndex(String uuid) {
		Resume searchKey = new Resume();
		searchKey.setUuid(uuid);
		return Arrays.binarySearch(storage, 0, size, searchKey);
	}
}