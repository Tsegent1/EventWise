package com.eventwise.service;

import com.eventwise.model.Attendee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttendeeServiceTest {

    @Test
    void create_shouldAssignIdAndStore() {
        AttendeeService service = new AttendeeService();

        Attendee attendee = new Attendee();
        Attendee created = service.create(attendee);

        assertEquals(1, created.getId());
        assertNotNull(service.findById(1));
    }

    @Test
    void findById_shouldReturnNullWhenNotFound() {
        AttendeeService service = new AttendeeService();

        assertNull(service.findById(999));
    }

    @Test
    void findAll_shouldReturnAllAttendees() {
        AttendeeService service = new AttendeeService();

        service.create(new Attendee());
        service.create(new Attendee());

        List<Attendee> all = service.findAll();
        assertEquals(2, all.size());
        assertEquals(1, all.get(0).getId());
        assertEquals(2, all.get(1).getId());
    }

    @Test
    void update_shouldReplaceExistingAttendee() {
        AttendeeService service = new AttendeeService();

        service.create(new Attendee()); // id = 1

        Attendee updated = new Attendee();
        Attendee result = service.update(1, updated);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertSame(result, service.findById(1));
    }

    @Test
    void update_shouldReturnNullWhenNotFound() {
        AttendeeService service = new AttendeeService();

        Attendee updated = new Attendee();
        assertNull(service.update(999, updated));
    }

    @Test
    void delete_shouldRemoveAttendee() {
        AttendeeService service = new AttendeeService();

        service.create(new Attendee()); // id = 1

        assertTrue(service.delete(1));
        assertNull(service.findById(1));
    }

    @Test
    void delete_shouldReturnFalseWhenNotFound() {
        AttendeeService service = new AttendeeService();

        assertFalse(service.delete(999));
    }
}
