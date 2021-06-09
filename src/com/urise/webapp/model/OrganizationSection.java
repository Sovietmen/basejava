package com.urise.webapp.model;

import java.util.ArrayList;

public class OrganizationSection extends AbstractSection {
    private ArrayList<Organization> content;

    public OrganizationSection(ArrayList<Organization> content) {
        this.content = content;
    }

    public ArrayList<Organization> getContent() {
        return content;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Object s : content.toArray()){
            string.append(s);
        }
        return string.toString();
    }
}
