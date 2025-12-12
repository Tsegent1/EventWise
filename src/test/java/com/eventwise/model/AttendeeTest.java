package com.eventwise.model;

import com.eventwise.model.Attendee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttendeeTest {

    @Test
    void setAndGetId_shouldWork() {
        Attendee attendee = new Attendee();
        attendee.setId(10L);

        assertEquals(10L, attendee.getId());
    }

    @Test
    void setAndGetName_shouldWork() {
        Attendee attendee = new Attendee();
        attendee.setName("Lili");

        assertEquals("Lili", attendee.getName());
    }

    @Test
    void setAndGetEmail_shouldWork() {
        Attendee attendee = new Attendee();
        attendee.setEmail("lili@example.com");

        assertEquals("lili@example.com", attendee.getEmail());
    }

    @Test
    void setAndGetNotes_shouldWork() {
        Attendee attendee = new Attendee();
        attendee.setNotes("Vegetarian meal");

        assertEquals("Vegetarian meal", attendee.getNotes());
    }
}
