package com.eventwise.service;

import com.eventwise.model.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple in-memory service for managing events.
 * No database yet - just stores events in a list.
 */
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private long nextId = 1;

    /**
     * Creates an event, assigns an id, stores it, and returns it.
     */
    public Event create(Event event) {
        event.setId(nextId);
        nextId++;
        events.add(event);
        return event;
    }

    /**
     * Returns all events currently stored.
     */
    public List<Event> findAll() {
        return new ArrayList<>(events); // return a copy to protect internal list
    }

    /**
     * Finds one event by id. Returns null if not found.
     */
    public Event findById(long id) {
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    /**
     * Deletes an event by id. Returns true if deleted, false if not found.
     */
    public boolean deleteById(long id) {
        Event found = findById(id);
        if (found == null) {
            return false;
        }
        return events.remove(found);
    }
}
