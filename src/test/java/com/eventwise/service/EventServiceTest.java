package com.eventwise.service;

import com.eventwise.model.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EventService.
 */
class EventServiceTest {

    @Test
    void create_shouldAssignIdAndStoreEvent() {
        EventService service = new EventService();

        Event event = new Event();
        event.setName("Test Event");

        Event created = service.create(event);

        assertNotNull(created);
        assertEquals(1, created.getId());
        assertEquals(1, service.findAll().size());
        assertEquals("Test Event", service.findAll().get(0).getName());
    }

    @Test
    void findById_shouldReturnEventWhenExists() {
        EventService service = new EventService();

        Event event = new Event();
        event.setName("Event A");
        service.create(event);

        Event found = service.findById(1);

        assertNotNull(found);
        assertEquals(1, found.getId());
        assertEquals("Event A", found.getName());
    }

    @Test
    void findById_shouldReturnNullWhenNotFound() {
        EventService service = new EventService();

        Event found = service.findById(999);

        assertNull(found);
    }

    @Test
    void deleteById_shouldRemoveEventWhenExists() {
        EventService service = new EventService();

        Event event = new Event();
        service.create(event);

        boolean deleted = service.deleteById(1);

        assertTrue(deleted);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void deleteById_shouldReturnFalseWhenNotFound() {
        EventService service = new EventService();

        boolean deleted = service.deleteById(123);

        assertFalse(deleted);
    }

}

