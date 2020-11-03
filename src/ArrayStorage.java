/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
	Resume[] storage = new Resume[10000];
	static int size;// количество резюме (размер не нулевого массива)

	void clear() {
		int i = 0;
		for (Resume resume : storage) {
			storage[i] = null;
			i++;
		}
		size = 0;
	}

	void save(Resume r) {
		boolean repeatIs = false;

		for (int i = 0; i < size;) {
			if (storage[i].toString() == r.toString()) {
				System.out.printf("ERROR %s element is present in array!", r.toString());
				repeatIs = true;
			}
			i++;
		}
		if (!repeatIs) {
			storage[size] = r;
			size++;
		}
	}

	Resume get(String uuid) {
		uuid.toLowerCase();
		Resume resTemp = null;

		for (int i = 0; i < size;) {
			if (uuid == storage[i].toString()) {
				resTemp = storage[i];
				break;
			}
			i++;
		}
		return resTemp;
	}

	void delete(String uuid) {
		uuid = uuid.toLowerCase();
		Resume[] resumeTemp = storage;
		boolean findUuidOk = false;

		for (int i = 0; i < size;) {
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
				storage[i] = resumeTemp[i + 1];
			}
			i++;
		}
		if (findUuidOk)
			size--;
	}

	/**
	 * @return array, contains only Resumes in storage (without null)
	 */
	Resume[] getAll() {
		Resume[] allResume = new Resume[size];
		for (int i = 0; i < allResume.length;) {
			allResume[i] = storage[i];
			i++;
		}
		return allResume;
	}

	int size() {
		return size;
	}
}
