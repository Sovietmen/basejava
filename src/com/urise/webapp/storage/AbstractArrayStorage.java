package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
	protected final int MAX_SIZE = 10_000;
	protected Resume[] storage = new Resume[MAX_SIZE];
	protected int size = 0;

	public void clear() {
		Arrays.fill(storage, 0, size, null);
		size = 0;
	}

	public Resume get(String uuid) {
		int findResult = findIndex(uuid);
		if (findResult >= 0) {
			return storage[findResult];
		}
		System.out.println("ERROR: Resume " + uuid + " is absent at the storage.");
		return null;
	}

	public Resume[] getAll() {
		return Arrays.copyOfRange(storage, 0, size);
	}

	public void update(Resume resume) {
		int indexOfResume = findIndex(resume.getUuid());
		if (indexOfResume >= 0) {
			storage[indexOfResume] = resume;
		} else {
			System.out.println("ERROR: Resume " + resume.getUuid() + " is absent at the storage.");
		}
	}

	public void save(Resume resume) {
		int indexOfResume = findIndex(resume.getUuid());
		if (indexOfResume >= 0) {
			System.out.println("ERROR: Resume " + resume.getUuid() + " is present at the storage.");
		} else if (size >= MAX_SIZE) {
			System.out.println("ERROR: storage is overspace.");
		} else if (indexOfResume < 0) {
			indexOfResume = -(indexOfResume) - 1;
			System.arraycopy(storage, indexOfResume, storage, indexOfResume + 1, size - indexOfResume);
			storage[indexOfResume] = resume;
			size++;
		}
	}

	public void delete(String uuid) {
		int findResult = findIndex(uuid);
		if (findResult >= 0) {
			if (size - 1 - findResult >= 0)
				System.arraycopy(storage, findResult + 1, storage, findResult, size - 1 - findResult);
			size--;
		} else {
			System.out.println("ERROR: Resume " + uuid + " is absent at the storage.");
		}
	}

	protected abstract int findIndex(String uuid);

	public int size() {
		return size;
	}
}
