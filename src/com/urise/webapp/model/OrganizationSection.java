package com.urise.webapp.model;

import java.util.ArrayList;

public class OrganizationSection extends Section {
    private ArrayList<Organization> content;

    OrganizationSection(ArrayList<Organization> content) {
        this.content = content;
    }

    public ArrayList<Organization> getContent() {
        return content;
    }
}
