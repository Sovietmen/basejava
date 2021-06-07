package com.urise.webapp.model;

import java.time.LocalDate;

public class Organization {
    private String name, position, responsibility;
    private LocalDate startDate, endDate;

    public Organization(String name, String position, String responsibility, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.position = position;
        this.responsibility = responsibility;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
