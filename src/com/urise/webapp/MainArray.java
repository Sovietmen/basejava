package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ListStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Interactive test for com.urise.webapp.storage.ArrayStorage implementation
 * (just run, no need to understand)
 */
public class MainArray {
    private final static ListStorage ARRAY_STORAGE = new ListStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume resume;
        while (true) {
            System.out.print("Enter command - (list | save \"uuid\" \"fullname\" | delete uuid | get uuid | clear | exit | update): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params[0].equals("save") && (params.length < 2)) {
                System.out.println("Wrong command.1");
                continue;
            }
            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "save":
                    if (params.length == 2) {
                        resume = new Resume(params[1]);
                    } else {
                        String fullname = "";
                        for (int i = 2; i < params.length; i++) {
                            fullname = fullname + " " + params[i];
                        }
                        resume = new Resume(params[1], fullname);
                    }
                    ARRAY_STORAGE.save(resume);
                    break;
                case "delete":
                    if (params.length != 2) break;
                    ARRAY_STORAGE.delete(params[1]);
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.get(params[1]));
                    break;
                case "clear":
                    ARRAY_STORAGE.clear();
                    break;
                case "update":
                    resume = new Resume(params[1]);
                    ARRAY_STORAGE.update(resume);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command.");
                    break;
            }
        }
    }

    static void printAll() {
        List<Resume> all = ARRAY_STORAGE.getAllSorted();
        System.out.println("----------------------------");
        if (all.size() == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}