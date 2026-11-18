package com.mycompany.movieticketsapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

/**
 * Q.2.9 - Unit tests for the MovieTickets class.
 */
public class MovieTicketsTest {

    private final MovieTickets movieTickets = new MovieTickets();

    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        // 3 tickets x R100 = R300, plus 14% VAT (R42) = R342
        double result = movieTickets.CalculateTotalTicketPrice(3, 100);
        assertEquals(342.0, result, 0.01);
    }

    @Test
    public void ValidateData_NumberOfTicketsIsZero_ReturnsFalse() {
        // 0 tickets breaks the rule "cannot be less than or equal to zero"
        MovieTicketData data = new MovieTicketData("Napoleon", 0, 100);
        assertFalse(movieTickets.ValidateData(data));
    }
}