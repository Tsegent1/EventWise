package com.eventwise.model;

/**
 * Represents a person who is RSVP'ing to an event.
 */
public class Attendee {

    /** Unique identifier for the attendee */
    private long id;

    /** The attendee's full name */
    private String name;

    /** Email address used for RSVP communication */
    private String email;

    /** Extra details or notes provided by the attendee */
    private String notes;

    /**
     * No-arg constructor.
     */
    public Attendee() {
    }

    /**
     * All-args constructor for quick Attendee creation.
     */
    public Attendee(long id, String name, String email, String notes) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.notes = notes;
    }

    // Getters and setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
