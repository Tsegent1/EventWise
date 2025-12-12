package com.eventwise.service;

import com.eventwise.model.Attendee;
import com.eventwise.model.Event;
import com.eventwise.model.Rsvp;

import java.util.*;

/**
 * Simple in-memory service for RSVP objects.
 */
public class RsvpService {

    private final Map<Long, Rsvp> rsvps = new LinkedHashMap<>();
    private long nextId = 1;

    /**
     * Create a new RSVP and assign an id.
     */
    public Rsvp create(Rsvp rsvp) {
        long id = nextId++;
        rsvp.setId(id);
        rsvps.put(id, rsvp);
        return rsvp;
    }

    /**
     * Find an RSVP by id.
     */
    public Rsvp findById(long id) {
        return rsvps.get(id);
    }

    /**
     * Return all RSVPs.
     */
    public List<Rsvp> findAll() {
        return new ArrayList<>(rsvps.values());
    }

    /**
     * Find all RSVPs for a given event.
     */
    public List<Rsvp> findByEvent(Event event) {
        List<Rsvp> result = new ArrayList<>();
        for (Rsvp rsvp : rsvps.values()) {
            if (rsvp.getEvent() == event) {
                result.add(rsvp);
            }
        }
        return result;
    }

    /**
     * Find all RSVPs for a given attendee.
     */
    public List<Rsvp> findByAttendee(Attendee attendee) {
        List<Rsvp> result = new ArrayList<>();
        for (Rsvp rsvp : rsvps.values()) {
            if (rsvp.getAttendee() == attendee) {
                result.add(rsvp);
            }
        }
        return result;
    }

    /**
     * Update an RSVP by id.
     */
    public Rsvp update(long id, Rsvp updated) {
        if (!rsvps.containsKey(id)) {
            return null;
        }
        updated.setId(id);
        rsvps.put(id, updated);
        return updated;
    }

    /**
     * Delete an RSVP by id.
     */
    public boolean delete(long id) {
        return rsvps.remove(id) != null;
    }
}
