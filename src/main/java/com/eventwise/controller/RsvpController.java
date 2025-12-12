package com.eventwise.controller;

import com.eventwise.model.Attendee;
import com.eventwise.model.Event;
import com.eventwise.model.Rsvp;
import com.eventwise.model.RsvpStatus;
import com.eventwise.service.AttendeeService;
import com.eventwise.service.EventService;
import com.eventwise.service.RsvpService;

import java.util.List;
import java.util.Scanner;

/**
 * Handles RSVP-related console actions.
 */
public class RsvpController {

    private final Scanner scanner;
    private final EventService eventService;
    private final AttendeeService attendeeService;
    private final RsvpService rsvpService;

    public RsvpController(Scanner scanner, EventService eventService, AttendeeService attendeeService, RsvpService rsvpService) {
        this.scanner = scanner;
        this.eventService = eventService;
        this.attendeeService = attendeeService;
        this.rsvpService = rsvpService;
    }

    public void createRsvp() {
        System.out.println();
        System.out.println("=== RSVP to Event ===");

        // List events to help user pick an ID
        List<Event> events = eventService.findAll();
        if (events.isEmpty()) {
            System.out.println("No events available. Create an event first.");
            return;
        }

        for (Event e : events) {
            System.out.println("ID=" + e.getId() + " | " + e.getName() + " | " + e.getDate());
        }

        long eventId = readLong("Enter event ID to RSVP: ");
        Event event = eventService.findById(eventId);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        // Create attendee
        System.out.print("Your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Your email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Notes (optional): ");
        String notes = scanner.nextLine().trim();

        Attendee attendee = new Attendee();
        attendee.setName(name);
        attendee.setEmail(email);
        attendee.setNotes(notes);

        attendeeService.create(attendee);

        // Create RSVP
        Rsvp rsvp = new Rsvp();
        rsvp.setEvent(event);
        rsvp.setAttendee(attendee);
        rsvp.setStatus(RsvpStatus.PENDING);
        rsvp.setNotes(notes);

        rsvpService.create(rsvp);

        System.out.println("RSVP created! Status: " + rsvp.getStatus());
    }

    public void listRsvpsForEvent() {
        System.out.println();
        System.out.println("=== RSVPs for an Event ===");

        long eventId = readLong("Enter event ID: ");
        Event event = eventService.findById(eventId);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        List<Rsvp> results = rsvpService.findByEvent(event);

        if (results.isEmpty()) {
            System.out.println("No RSVPs for this event yet.");
            return;
        }

        for (Rsvp r : results) {
            System.out.println(formatRsvp(r));
        }
    }

    private String formatRsvp(Rsvp r) {
        String attendeeName = (r.getAttendee() == null) ? "Unknown" : r.getAttendee().getName();
        return "RSVP_ID=" + r.getId() +
                " | Attendee=" + attendeeName +
                " | Status=" + r.getStatus() +
                " | Notes=" + (r.getNotes() == null ? "" : r.getNotes());
    }

    private long readLong(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Long.parseLong(input);
            } catch (Exception e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
