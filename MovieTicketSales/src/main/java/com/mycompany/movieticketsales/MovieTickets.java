package com.mycompany.movieticketsales;

public class MovieTickets implements IMovieTickets {

    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        // Start by assuming the first movie is the top performer
        int topIndex = 0;

        // Compare every other movie against the current top performer
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topIndex]) {
                topIndex = i;
            }
        }

        return movies[topIndex];
    }

    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        int total = 0;

        // Add each month's ticket sales to the running total
        for (int monthlySales : movieTicketSales) {
            total += monthlySales;
        }

        return total;
    }

}
