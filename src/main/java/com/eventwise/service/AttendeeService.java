package com.eventwise.service;

import com.eventwise.model.Attendee;

import java.util.*;

/**
 * Simple in-memory service for Attendee objects (no database yet).
 */
public class AttendeeService {

    private final Map<Long, Attendee> attendees = new LinkedHashMap<>();
    private long nextId = 1;

    /**
     * Create a new attendee. Assigns a new id and stores it.
     */
    public Attendee create(Attendee attendee) {
        long id = nextId++;
        attendee.setId(id);
        attendees.put(id, attendee);
        return attendee;
    }

    /**
     * Find an attendee by id.
     */
    public Attendee findById(long id) {
        return attendees.get(id);
    }

    /**
     * Return all attendees.
     */
    public List<Attendee> findAll() {
        return new ArrayList<>(attendees.values());
    }

    /**
     * Update an existing attendee by id.
     * Returns the updated attendee, or null if not found.
     */
    public Attendee update(long id, Attendee updated) {
        if (!attendees.containsKey(id)) {
            return null;
        }
        updated.setId(id);
        attendees.put(id, updated);
        return updated;
    }

    /**
     * Delete an attendee by id.
     * Returns true if deleted, false if not found.
     */
    public boolean delete(long id) {
        return attendees.remove(id) != null;
    }
}
