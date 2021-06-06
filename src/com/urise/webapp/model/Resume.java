package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {
    private String uuid;
    private String fullName;
    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);
    private ArrayList<String> achiev = new ArrayList<>();
    private ListSection achievement = new ListSection(achiev);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.fullName = fullName;
        this.uuid = uuid;
    }

    public void setAchievement(String achievement) {
        achiev.add(achievement);
        sections.put(SectionType.ACHIEVMENT, this.achievement);
    }

    public ListSection getAchievement() {
        return (ListSection) sections.get(SectionType.ACHIEVMENT);
    }

    public void setObjective(String content) {
        sections.put(SectionType.OBJECTIVE, new TextSection(content));
    }

    public TextSection getObjective() {
        return (TextSection) sections.get(SectionType.OBJECTIVE);
    }

    public void setPersonal(String content) {
        sections.put(SectionType.PERSONAL, new TextSection((content)));
    }

    public TextSection getPersonal() {
        return (TextSection) sections.get(SectionType.PERSONAL);
    }

    public void addContact(ContactType contactType, String contact) {
        contacts.put(contactType, contact);
    }

    public String getContact(ContactType contactType) {
        return contacts.get(contactType);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "uuid: " + uuid + "\nfull name: " + fullName;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode() + fullName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Resume resume = (Resume) obj;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);

    }

    @Override
    public int compareTo(Resume o) {
        return fullName.compareTo(o.fullName);
    }

    public void setContacts(Map<ContactType, String> contacts) {
        this.contacts = contacts;
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public void setSections(Map<SectionType, Section> sections) {
        this.sections = sections;
    }

    public Map<SectionType, Section> getSections() {
        return sections;
    }
}
