package com.mycompany.movieticketsapp;

/**
 * Calculates the total ticket price (including VAT) and validates ticket data.
 */
public class MovieTickets implements IMovieTickets {

    // VAT rate of 14%
    public static final double VAT_RATE = 0.14;

    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double subTotal = numberOfTickets * ticketPrice;
        double total = subTotal + (subTotal * VAT_RATE);

        // Round to 2 decimal places to avoid values like 341.99999999999994
        return Math.round(total * 100) / 100.0;
    }

    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {
        // Rule 1: Movie name cannot be empty
        if (movieTicketData.getMovieName() == null
                || movieTicketData.getMovieName().trim().isEmpty()) {
            return false;
        }

        // Rule 2: Ticket price cannot be less than or equal to zero
        if (movieTicketData.getTicketPrice() <= 0) {
            return false;
        }

        // Rule 3: Number of tickets cannot be less than or equal to zero
        if (movieTicketData.getNumberOfTickets() <= 0) {
            return false;
        }

        return true;
    }
}