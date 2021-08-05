package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.*;
import java.util.Objects;

public class Organization {
    private String name, responsibility;
    private YearMonth startDate, endDate;
    private List<Position> positions = new ArrayList<>();

    public Organization(String name, Position... positions) {
        this.name = name;
        this.positions = Arrays.asList(positions);
    }

    public String getName() {
        return name;
    }

    public List getPositions() {
        return positions;
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

    @Override
    public String toString() {
        String s = name + "\n";
        for (Position p: positions) {
            s = s + p.toString();
        }
        return s;

    }

    public static class Position {
        private YearMonth startDate;
        private YearMonth endDate;
        private String posName;
        private String responsibility;

        public Position(String posName, String responsibility, YearMonth startDate, YearMonth endDate){
            this.posName = posName;
            this.responsibility = responsibility;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public YearMonth getStartDate() {
            return startDate;
        }

        public YearMonth getEndDate() {
            return endDate;
        }

        public String getPosName() {
            return posName;
        }

        public String getResponsibility() {
            return responsibility;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position position = (Position) o;
            return Objects.equals(startDate, position.startDate) && Objects.equals(endDate, position.endDate) && Objects.equals(posName, position.posName) && Objects.equals(responsibility, position.responsibility);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, posName, responsibility);
        }

        @Override
        public String toString() {
            return startDate + " - " +
                    endDate + "\n" +
                    posName + "\n" +
                    responsibility + "\n";
        }
    }
}
