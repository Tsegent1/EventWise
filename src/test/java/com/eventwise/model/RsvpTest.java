package com.eventwise.model;

import com.eventwise.model.Attendee;
import com.eventwise.model.Event;
import com.eventwise.model.Rsvp;
import com.eventwise.model.RsvpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Basic unit tests for the Rsvp model.
 * Each test checks one getter/setter pair.
 */
class RsvpTest {

    @Test
    void setAndGetId_shouldWork() {
        Rsvp rsvp = new Rsvp();
        rsvp.setId(42L);

        assertEquals(42L, rsvp.getId());
    }

    @Test
    void setAndGetEvent_shouldWork() {
        Event event = new Event();
        event.setName("Tech Meetup");

        Rsvp rsvp = new Rsvp();
        rsvp.setEvent(event);

        assertEquals("Tech Meetup", rsvp.getEvent().getName());
    }

    @Test
    void setAndGetAttendee_shouldWork() {
        Attendee attendee = new Attendee();
        attendee.setName("Lili");

        Rsvp rsvp = new Rsvp();
        rsvp.setAttendee(attendee);

        assertEquals("Lili", rsvp.getAttendee().getName());
    }

    @Test
    void setAndGetStatus_shouldWork() {
        Rsvp rsvp = new Rsvp();
        rsvp.setStatus(RsvpStatus.CONFIRMED);

        assertEquals(RsvpStatus.CONFIRMED, rsvp.getStatus());
    }

    @Test
    void setAndGetNotes_shouldWork() {
        Rsvp rsvp = new Rsvp();
        rsvp.setNotes("Bringing a guest");

        assertEquals("Bringing a guest", rsvp.getNotes());
    }
}
