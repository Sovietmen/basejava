/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
	Resume[] storage = new Resume[10000];
	int size;

	void clear() {
		for (int i = 0; i < size; i++) {
			storage[i] = null;
		}
		size = 0;
	}

	void save(Resume r) {
		boolean repeatIs = false;

		for (int i = 0; i < size; i++) {
			if (storage[i].toString() == r.toString()) {
				System.out.printf("ERROR %s element is present in array!", r.toString());
				repeatIs = true;
			}
		}
		if (!repeatIs) {
			storage[size] = r;
			size++;
		}
	}

	Resume get(String uuid) {
		Resume resume = null;

		for (int i = 0; i < size; i++) {
			if (uuid == storage[i].toString()) {
				resume = storage[i];
				break;
			}
		}
		if (resume == null)
			System.out.printf("ERROR: No \"%s\" in storage array!", uuid);
		return resume;
	}

	void delete(String uuid) {

		boolean findUuidOk = false;

		for (int i = 0; i < size; i++) {
			if (uuid == storage[i].toString()) {
				if (i < storage.length) {
					findUuidOk = true;
				} else {
					storage[i] = null;
					size--;
					break;
				}
			}
			if (findUuidOk) {
				storage[i] = storage[i + 1];
			}
		}
		if (findUuidOk)
			size--;
	}

	/**
	 * @return array, contains only Resumes in storage (without null)
	 */
	Resume[] getAll() {
		Resume[] allResume = new Resume[size];
		for (int i = 0; i < size; i++) {
			allResume[i] = storage[i];
		}
		return allResume;
	}

	int size() {
		return size;
	}
}
