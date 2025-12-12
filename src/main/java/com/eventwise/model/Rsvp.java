package com.eventwise.model;

/**
 * Represents a single RSVP entry for an event.
 * Links one attendee to one event with a status and optional notes.
 */
public class Rsvp {

    /**
     * Unique identifier for this RSVP.
     */
    private long id;

    /**
     * The event that the attendee is responding to.
     */
    private Event event;

    /**
     * The attendee who is responding.
     */
    private Attendee attendee;

    /**
     * Current RSVP status (for example: PENDING, CONFIRMED, DECLINED).
     */
    private RsvpStatus status;

    /**
     * Extra notes (for example: “Vegetarian meal”, “Bringing a guest”).
     */
    private String notes;

    // ---------------- Constructors ----------------

    /**
     * No-argument constructor.
     * Allows us to create an empty Rsvp and set fields later with setters.
     */
    public Rsvp() {
    }

    /**
     * Convenience constructor to create a fully populated Rsvp in one step.
     */
    public Rsvp(long id, Event event, Attendee attendee, RsvpStatus status, String notes) {
        this.id = id;
        this.event = event;
        this.attendee = attendee;
        this.status = status;
        this.notes = notes;
    }

    // ---------------- Getters and setters ----------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }

    public RsvpStatus getStatus() {
        return status;
    }

    public void setStatus(RsvpStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
