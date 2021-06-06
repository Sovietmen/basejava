package com.urise.webapp.model;

import java.util.*;

public class ListSection extends Section {
    private ArrayList<String> content;

    ListSection (ArrayList<String> content) {
        this.content = content;
    }

    public ArrayList<String> getContent() {
        return content;
    }
}
