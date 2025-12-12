package com.eventwise.model;

import com.eventwise.model.Event;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    @Test
    void setAndGetId_shouldWork() {
        Event event = new Event();
        event.setId(1L);

        assertEquals(1L, event.getId());
    }

    @Test
    void setAndGetName_shouldWork() {
        Event event = new Event();
        event.setName("Tech Meetup");

        assertEquals("Tech Meetup", event.getName());
    }

    @Test
    void setAndGetDate_shouldWork() {
        Event event = new Event();
        LocalDate date = LocalDate.of(2025, 1, 15);
        event.setDate(date);

        assertEquals(date, event.getDate());
    }

    @Test
    void setAndGetLocation_shouldWork() {
        Event event = new Event();
        event.setLocation("Library");

        assertEquals("Library", event.getLocation());
    }

    @Test
    void setAndGetMaxAttendees_shouldWork() {
        Event event = new Event();
        event.setMaxAttendees(50);

        assertEquals(50, event.getMaxAttendees());
    }
}
