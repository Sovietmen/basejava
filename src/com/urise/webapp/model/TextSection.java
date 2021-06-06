package com.urise.webapp.model;

public class TextSection extends Section {
    private String content;

    TextSection(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
