package com.eventwise.model;

import java.time.LocalDate;

/**
 * Represents an event in the system.
 * The event has basic information and a limit on how many people can attend.
 *
 * Validation and logic for these values will be handled elsewhere.
 */
public class Event {

    private long id;
    private String name;
    private LocalDate date;
    private String location;
    private int maxAttendees;
    public Event() {
    }
    public Event(long id, String name, LocalDate date, String location, int maxAttendees) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.maxAttendees = maxAttendees;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(int maxAttendees) {
        this.maxAttendees = maxAttendees;
    }
}



