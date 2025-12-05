package com.eventwise.model;

/**
 * Represents the current status of an attendee's RSVP.
 */
public enum RsvpStatus {
    /**
     * The attendee is confirmed for the event.
     */
    CONFIRMED,
    /**
     * The attendee was on the list but has cancelled.
     */
    CANCELLED,
    /**
     * The event is full for now; attendee is on a waitlist.
     * (optional usage)
     */
    WAITLISTED
}
