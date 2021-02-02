package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException,
			NoSuchFieldException, SecurityException, NoSuchMethodException {
		String uuid = "uuid";
		Resume r = new Resume(uuid);
		Field field = r.getClass().getDeclaredField(uuid);
		field.setAccessible(true);
		field.set(r, "new_UUID");
		System.out.println(field.get(r));
		Method resumeToString = r.getClass().getDeclaredMethod("toString", null);
		System.out.println(resumeToString.invoke(r));
	}
}
