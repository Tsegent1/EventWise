package com.eventwise.service;

import com.eventwise.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RsvpServiceTest {

    @Test
    void findByEvent_shouldReturnMatchingRsvps() {
        RsvpService service = new RsvpService();

        Event event = new Event(1, "Conference", LocalDate.now(), "Hall A", 100);
        Attendee attendee = new Attendee();

        Rsvp rsvp1 = new Rsvp(0, event, attendee, RsvpStatus.CONFIRMED, null);
        Rsvp rsvp2 = new Rsvp(0, event, attendee, RsvpStatus.PENDING, null);

        service.create(rsvp1);
        service.create(rsvp2);

        List<Rsvp> results = service.findByEvent(event);

        assertEquals(2, results.size());
    }

    @Test
    void findByAttendee_shouldReturnMatchingRsvps() {
        RsvpService service = new RsvpService();

        Event event = new Event(1, "Meetup", LocalDate.now(), "Room 1", 50);
        Attendee attendee = new Attendee();

        Rsvp rsvp = new Rsvp(0, event, attendee, RsvpStatus.CONFIRMED, "Vegetarian");

        service.create(rsvp);

        List<Rsvp> results = service.findByAttendee(attendee);

        assertEquals(1, results.size());
        assertEquals("Vegetarian", results.get(0).getNotes());
    }
}

