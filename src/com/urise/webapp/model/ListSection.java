package com.urise.webapp.model;

import java.util.*;

public class ListSection extends AbstractSection {
    private ArrayList<String> content;

    public ListSection(ArrayList<String> content) {
        this.content = content;
    }

    public ArrayList<String> getContent() {
        return content;
    }
}
