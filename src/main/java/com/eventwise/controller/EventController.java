package com.eventwise.controller;

import com.eventwise.model.Event;
import com.eventwise.service.EventService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Handles event-related console actions.
 */
public class EventController {

    private final Scanner scanner;
    private final EventService eventService;

    public EventController(Scanner scanner, EventService eventService) {
        this.scanner = scanner;
        this.eventService = eventService;
    }

    public void createEvent() {
        System.out.println();
        System.out.println("=== Create Event ===");

        System.out.print("Event name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Location: ");
        String location = scanner.nextLine().trim();

        LocalDate date = readDate("Event date (YYYY-MM-DD): ");

        int maxAttendees = readInt("Max attendees: ");

        Event event = new Event();
        event.setName(name);
        event.setLocation(location);
        event.setDate(date);
        event.setMaxAttendees(maxAttendees);

        Event created = eventService.create(event);

        System.out.println("Created event with ID: " + created.getId());
    }

    public void listEvents() {
        System.out.println();
        System.out.println("=== Events ===");

        List<Event> events = eventService.findAll();

        if (events.isEmpty()) {
            System.out.println("No events found.");
            return;
        }

        for (Event event : events) {
            System.out.println(formatEvent(event));
        }
    }

    public void deleteEvent() {
        System.out.println();
        System.out.println("=== Delete Event ===");

        long id = readLong("Enter event ID to delete: ");
        boolean deleted = eventService.deleteById(id);

        if (deleted) {
            System.out.println("Event deleted.");
        } else {
            System.out.println("Event not found.");
        }
    }

    private String formatEvent(Event e) {
        return "ID=" + e.getId() +
                " | " + e.getName() +
                " | " + e.getDate() +
                " | " + e.getLocation() +
                " | Max=" + e.getMaxAttendees();
    }

    private LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return LocalDate.parse(input);
            } catch (Exception e) {
                System.out.println("Invalid date format. Use YYYY-MM-DD.");
            }
        }
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
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
