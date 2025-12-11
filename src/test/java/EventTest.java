package com.eventwise.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void noArgConstructor_shouldCreateEventWithDefaultValues() {
        Event event = new Event();

        assertNotNull(event);
        assertEquals(0L, event.getId());
        assertNull(event.getName());
        assertNull(event.getDate());
        assertNull(event.getLocation());
        assertEquals(0, event.getMaxAttendees());
    }

    @Test
    void fullConstructor_shouldSetAllFields() {
        LocalDate date = LocalDate.of(2025, 1, 1);

        Event event = new Event(1L, "New Year Party", date, "Dallas", 100);

        assertEquals(1L, event.getId());
        assertEquals("New Year Party", event.getName());
        assertEquals(date, event.getDate());
        assertEquals("Dallas", event.getLocation());
        assertEquals(100, event.getMaxAttendees());
    }

    @Test
    void setAndGetId_shouldWork() {
        Event event = new Event();
        event.setId(10L);
        assertEquals(10L, event.getId());
    }

    @Test
    void setAndGetName_shouldWork() {
        Event event = new Event();
        event.setName("Study Session");
        assertEquals("Study Session", event.getName());
    }

    @Test
    void setAndGetDate_shouldWork() {
        Event event = new Event();
        LocalDate date = LocalDate.of(2025, 5, 5);
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

