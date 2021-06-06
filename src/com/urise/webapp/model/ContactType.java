package com.urise.webapp.model;

public enum ContactType {

    PHONE("Телефон"),
    SKYPE("Скайп"),
    MAIL("E-mail"),
    LINK("Ссылка 1"),
    LINK2("Ссылка 2"),
    LINK3("Ссылка 3");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
