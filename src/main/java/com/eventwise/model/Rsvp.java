package com.eventwise.model;

/**
 * Links an attendee to an event with a specific RSVP status.
 */
public class Rsvp {

    // Unique identifier for the RSVP record
    private long id;

    // The event this RSVP belongs to
    private long eventId;

    // The attendee who made this RSVP
    private long attendeeId;

    // Current status of the RSVP
    private RsvpStatus status;

    /**
     * No-argument constructor.
     */
    public Rsvp() {
    }

    /**
     * Constructor that sets all fields at once.
     */
    public Rsvp(long id, long eventId, long attendeeId, RsvpStatus status) {
        this.id = id;
        this.eventId = eventId;
        this.attendeeId = attendeeId;
        this.status = status;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(long attendeeId) {
        this.attendeeId = attendeeId;
    }

    public RsvpStatus getStatus() {
        return status;
    }

    public void setStatus(RsvpStatus status) {
        this.status = status;
    }
}
