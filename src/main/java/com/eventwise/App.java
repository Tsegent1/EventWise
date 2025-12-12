package com.eventwise;

import com.eventwise.controller.MenuController;
import com.eventwise.service.AttendeeService;
import com.eventwise.service.EventService;
import com.eventwise.service.RsvpService;

import java.util.Scanner;

/**
 * Entry point for the EventWise console application.
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Services (in-memory for now)
        EventService eventService = new EventService();
        AttendeeService attendeeService = new AttendeeService();
        RsvpService rsvpService = new RsvpService();

        // Controller that runs the menu loop
        MenuController menuController = new MenuController(scanner, eventService, attendeeService, rsvpService);
        menuController.start();

        scanner.close();
    }
}
