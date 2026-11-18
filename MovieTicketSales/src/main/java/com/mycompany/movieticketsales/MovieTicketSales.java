package com.mycompany.movieticketsales;

/**
 * Q.1.1 - Displays the movie ticket sales report for January to March 2024, the
 * total ticket sales for each movie, and the top performing movie.
 */
public class MovieTicketSales {

    public static void main(String[] args) {

        // Single-dimensional arrays: movie names and month headings
        String[] movies = {"Napoleon", "Oppenheimer"};
        String[] months = {"JAN", "FEB", "MAR"};

        // Two-dimensional array: rows = movies, columns = months
        int[][] ticketSales = {
            {3000, 1500, 1700}, // Napoleon
            {3500, 1200, 1600} // Oppenheimer
        };

        // Single-dimensional array to hold the total sales for each movie
        int[] totalSales = new int[movies.length];

        // Object used for the calculations (referenced through the interface)
        IMovieTickets movieTickets = new MovieTickets();

        // ---------- Report heading ----------
        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println();

        // Print the month column headings
        System.out.printf("%-20s", "");
        for (String month : months) {
            System.out.printf("%-15s", month);
        }
        System.out.println();
        System.out.println("-".repeat(70));

        // ---------- Report rows ----------
        for (int row = 0; row < movies.length; row++) {
            // Movie name in the first column
            System.out.printf("%-20s", movies[row]);

            // Ticket sales for each month
            for (int col = 0; col < months.length; col++) {
                System.out.printf("%-15d", ticketSales[row][col]);
            }
            System.out.println();

            // Calculate and store the total for this movie
            totalSales[row] = movieTickets.TotalMovieSales(ticketSales[row]);
        }
        System.out.println();

        // ---------- Totals per movie ----------
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Total movie ticket sales for " + movies[i] + " " + totalSales[i]);
        }
        System.out.println();

        // ---------- Top performing movie ----------
        System.out.println("Top performing movie: " + movieTickets.TopMovie(movies, totalSales));
    }
}
