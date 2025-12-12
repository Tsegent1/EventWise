package com.eventwise.controller;

import com.eventwise.service.AttendeeService;
import com.eventwise.service.EventService;
import com.eventwise.service.RsvpService;

import java.util.Scanner;

/**
 * Handles the main menu and routes user actions to the correct controller.
 */
public class MenuController {

    private final Scanner scanner;
    private final EventController eventController;
    private final RsvpController rsvpController;

    public MenuController(Scanner scanner,
                          EventService eventService,
                          AttendeeService attendeeService,
                          RsvpService rsvpService) {
        this.scanner = scanner;
        this.eventController = new EventController(scanner, eventService);
        this.rsvpController = new RsvpController(scanner, eventService, attendeeService, rsvpService);
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    eventController.createEvent();
                    break;
                case "2":
                    eventController.listEvents();
                    break;
                case "3":
                    eventController.deleteEvent();
                    break;
                case "4":
                    rsvpController.createRsvp();
                    break;
                case "5":
                    rsvpController.listRsvpsForEvent();
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("===== EventWise =====");
        System.out.println("1) Create Event");
        System.out.println("2) List Events");
        System.out.println("3) Delete Event");
        System.out.println("4) RSVP to Event");
        System.out.println("5) List RSVPs for an Event");
        System.out.println("0) Exit");
        System.out.print("Choose an option: ");
    }
}
