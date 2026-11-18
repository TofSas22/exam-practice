package com.mycompany.movieticketsales;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Q.1.3 - Unit tests for the MovieTickets class.
 */
public class MovieTicketsTest {

    // Class under test
    private final MovieTickets movieTickets = new MovieTickets();

    /**
     * Supplies Napoleon's monthly sales to TotalMovieSales and checks that
     * the correct total (3000 + 1500 + 1700 = 6200) is returned.
     */
    @Test
    public void CalculateTotalSales_ReturnsExpectedTotalSales() {
        int[] napoleonSales = {3000, 1500, 1700};

        int expected = 6200;
        int actual = movieTickets.TotalMovieSales(napoleonSales);

        assertEquals(expected, actual);
    }

    /**
     * Supplies the movie names and their total sales to TopMovie and checks
     * that Oppenheimer (6300) is returned as the top performer over Napoleon (6200).
     */
    @Test
    public void TopMovieSales_ReturnsTopMovie() {
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totalSales = {6200, 6300};

        String expected = "Oppenheimer";
        String actual = movieTickets.TopMovie(movies, totalSales);

        assertEquals(expected, actual);
    }
}