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
		int index = findIndex(uuid);
		if (index >= 0) {
			return storage[index];
		}
		System.out.println("ERROR: Resume " + uuid + " is absent at the storage.");
		return null;
	}

	public Resume[] getAll() {
		return Arrays.copyOf(storage, size);
	}

	public void update(Resume resume) {
		int index = findIndex(resume.getUuid());
		if (index >= 0) {
			storage[index] = resume;
		} else {
			System.out.println("ERROR: Resume " + resume.getUuid() + " is absent at the storage.");
		}
	}

	public void save(Resume resume) {
		int index = findIndex(resume.getUuid());
		if (index >= 0) {
			System.out.println("ERROR: Resume " + resume.getUuid() + " is present at the storage.");
		} else if (size >= MAX_SIZE) {
			System.out.println("ERROR: storage is overspace.");
		} else {
			saveUnit(resume, index);
			size++;
		}
	}

	public void delete(String uuid) {
		int index = findIndex(uuid);
		if (index >= 0) {
			deleteUnit(uuid, index);
			size--;
		} else {
			System.out.println("ERROR: Resume " + uuid + " is absent at the storage.");
		}
	}

	protected abstract int findIndex(String uuid);

	protected abstract void saveUnit(Resume resume, int index);

	protected abstract void deleteUnit(String uuid, int index);

	public int size() {
		return size;
	}
}
