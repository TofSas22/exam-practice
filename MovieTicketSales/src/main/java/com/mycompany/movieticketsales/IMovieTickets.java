package com.mycompany.movieticketsales;

public interface IMovieTickets {
    /**
     * Adds up the monthly ticket sales for one movie.
     *
     * @param movieTicketSales ticket sales for each month (Jan, Feb, Mar)
     * @return total number of tickets sold
     */
    int TotalMovieSales(int[] movieTicketSales);

    /**
     * Finds the movie with the highest total ticket sales.
     *
     * @param movies     movie names
     * @param totalSales total sales per movie (same order as movies)
     * @return name of the top performing movie
     */
    String TopMovie(String[] movies, int[] totalSales);
}
