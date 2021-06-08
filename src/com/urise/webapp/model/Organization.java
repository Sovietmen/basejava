package com.urise.webapp.model;

import java.time.YearMonth;

public class Organization {
    private String name, position, responsibility;
    private YearMonth startDate, endDate;

    public Organization(String name, String position, String responsibility, YearMonth startDate, YearMonth endDate) {
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

    public YearMonth getStartDate() {
        return startDate;
    }

    public YearMonth getEndDate() {
        return endDate;
    }
}
