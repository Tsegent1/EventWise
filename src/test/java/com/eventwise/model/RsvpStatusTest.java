package com.eventwise.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RsvpStatusTest {

    @Test
    void enumShouldContainExpectedValues() {
        // values() returns all enum constants in the order they are declared
        RsvpStatus[] values = RsvpStatus.values();

        assertEquals(3, values.length);
        assertNotNull(RsvpStatus.PENDING);
        assertNotNull(RsvpStatus.CONFIRMED);
        assertNotNull(RsvpStatus.CANCELLED);
    }
}
