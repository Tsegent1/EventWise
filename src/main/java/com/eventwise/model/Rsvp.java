package com.eventwise.model;

public class Rsvp {
    /**
     * unique identifier for this Rsvp record.
     */
    private long id;
    /**
     * Id of the event this RSVP belongs to.
     */
    private long eventId;
    /**
     * Id of the attendee who RSVP'd.
     */
    private long attendeeId;
    /**
     * Current status of the RSVP (confirmed, cancelled, etc)
     */
    private RsvpStatus status;

}
