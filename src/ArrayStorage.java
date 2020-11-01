/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
	Resume[] storage = new Resume[10000];
	static int size;

	void clear() {
		int i = 0;
		for (Resume resume : storage) {
			storage[i] = null;
			i++;
			size = 0;
		}
	}

	void save(Resume r) {
		int i = 0;
		boolean repeatIs = false;
		// check each of storage array element for r.uuid if true show ERROR
		for (Resume resRepeat : storage) {
			if (resRepeat != null) {
				if (resRepeat.toString() == r.toString()) {
					System.out.printf("ERROR %s element is present in array!", r.toString());
					repeatIs = true;
				}
			}
		}
		if (!repeatIs) {// if r is absent in storage check each element of storage for null element
			for (Resume resume : storage) {

				if (resume == null) { // if null element searched in storage null element in storage became "r" and
					// cycle stopped
					storage[i] = r;
					size++;
					break;
				}
				i++;
			}
		}
	}

	Resume get(String uuid) {
		int i = 0;
		uuid.toLowerCase();
		for (Resume resume : storage) {
			if (resume != null)
				if (uuid == resume.toString())
					break;
			if (uuid != resume.toString()) {
				System.out.printf("No \"%s\" in storage array.", uuid);
				break;
			}
			i++;
		}
		return storage[i];
	}

	void delete(String uuid) {
		int i = 0;
		uuid = uuid.toLowerCase();
		Resume[] resumeTemp = storage;
		boolean findUuidOk = false;

		for (Resume resume : storage) {
			if (resume != null) {
				if (uuid == resume.toString()) {
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
			} else
				break;
			i++;
		}
		if (findUuidOk)
			size--;
	}

	/**
	 * @return array, contains only Resumes in storage (without null)
	 */
	Resume[] getAll() {
		int nonNulCount = 0;

		for (Resume resume : storage) {
			if (resume != null)
				nonNulCount++;
		}

		Resume[] allResume = new Resume[nonNulCount];
		for (int i = 0; i < nonNulCount;) {
			allResume[i] = storage[i];
			i++;
		}
		return allResume;
	}

	int size() {

		return size;
	}
}
