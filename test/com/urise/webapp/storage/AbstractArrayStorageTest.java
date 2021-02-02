package com.urise.webapp.storage;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.urise.webapp.exception.ExistStorageExceprion;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

abstract class AbstractArrayStorageTest {
	private Storage storage;
	private static final String UUID_1 = "uuid1";
	private static final String UUID_2 = "uuid2";
	private static final String UUID_3 = "uuid3";

	AbstractArrayStorageTest(Storage storage) {
		this.storage = storage;
	}

	@BeforeEach
	void setUp() {
		storage.clear();
		storage.save(new Resume(UUID_1));
		storage.save(new Resume(UUID_2));
		storage.save(new Resume(UUID_3));
	}

	@Test
	void clear() {
		storage.clear();
		assertEquals(0, storage.size());
	}

	@Test
	void get() {
		assertEquals(new Resume(UUID_2), storage.get(UUID_2));
	}

	@Test
	void getNotExist() {
		assertThrows(NotExistStorageException.class, () -> storage.get("someID"));
	}

	@Test
	void getAll() {
		Resume[] resumes = storage.getAll();
		boolean result = true;
		for (Resume resume : resumes) {
			result = result && ((resume.equals(new Resume(UUID_1))) || (resume.equals(new Resume(UUID_2)))
					|| (resume.equals(new Resume(UUID_3))));
		}
		assertEquals(true, result);
	}

	@Test
	void update() {
		Resume resume = storage.get(UUID_2);
		storage.update(resume);
		assertEquals(resume, storage.get(UUID_2));
	}

	@Test
	void updatedNotExist() {
		assertThrows(NotExistStorageException.class, () -> storage.update(new Resume("someID")));
	}

	@Test
	void saveNew() {
		Resume resume = new Resume("testUUID");
		storage.save(resume);
		assertEquals(resume, storage.get("testUUID"));
		assertEquals(4, storage.size());
	}

	@Test
	void saveExist() {
		assertThrows(ExistStorageExceprion.class, () -> storage.save(new Resume(UUID_1)));
	}

	@Test
	void delete() {
		int sizeBefore = storage.size() - 1;
		storage.delete(UUID_2);
		assertEquals(sizeBefore, storage.size());
	}

	@Test
	void deleteNotExist() {
		assertThrows(NotExistStorageException.class, () -> storage.delete("someID"));
	}

	@Test
	void size() {
		assertEquals(3, storage.size());
	}

	@Test
	void overflow() {
		storage.clear();
		int maxSize = 10_000;
		try {
			for (int i = 0; i < maxSize; i++) {
				storage.save(new Resume("uuid" + (i + 1)));
			}
			assertThrows(StorageException.class, () -> storage.save(new Resume("lastUUID")));
		} catch (StorageException exception) {
			fail("Overflow is too early");
		}
		
	}
}