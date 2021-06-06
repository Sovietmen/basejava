package com.urise.webapp.model;

public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVMENT("Достижения"),//List of Strings
    QUALIFICATIONS("Квалификация"),//List of Strings
    EXPERIENCE("Опыт работы"),//List of Organizations
    EDUCATION("Образование");//List of Organizations

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
