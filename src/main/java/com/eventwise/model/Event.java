package com.eventwise.model;

import java.time.LocalDate;

/**
 * Represents an event in the system.
 * The event has basic information and a limit on how many people can attend.
 *
 * Validation and logic for these values will be handled elsewhere.
 */
public class Event {

    /**
     * Unique identifier for the event.
     */
    private long id;

    /**
     * Name of the event.
     */
    private String name;

    /**
     * Date when the event will take place.
     * Should not be set to a past date.
     */
    private LocalDate date;

    /**
     * Location of the event.
     */
    private String location;

    /**
     * Maximum number of attendees allowed.
     */
    private int maxAttendees;

    // Constructors and methods will be added later
}
