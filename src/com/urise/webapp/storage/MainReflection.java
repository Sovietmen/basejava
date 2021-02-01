package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        String uuid = "uuid";
        Resume r = new Resume(uuid);
        Field[] fields = r.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(r, "new_UUID");
            System.out.println(field.get(r));
        }
        Method resumeToString = r.getClass().getDeclaredMethods()[2];
        System.out.println(resumeToString.invoke(r));
    }
}
