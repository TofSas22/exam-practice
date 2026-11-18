package com.mycompany.homemakeoverreport;

/**
 * Prints a renovator's monthly home makeover report for six months.
 */
public class HomeMakeoverReport {

    // A monthly total of 15 or more earns three stars
    public static final int STAR_TARGET = 15;

    public static void main(String[] args) {
        // Single-dimensional arrays: the months (rows) and the makeover types (columns)
        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN"};
        String[] makeoverTypes = {"Bathrooms", "Kitchens", "Garden"};

        // Two-dimensional array: row = month, column = makeover type
        int[][] makeovers = {
            {8, 2, 5},   // JAN
            {7, 4, 5},   // FEB
            {5, 5, 2},   // MAR
            {2, 2, 3},   // APR
            {7, 7, 9},   // MAY
            {7, 8, 5}    // JUN
        };

        String line = "------------------------------------------------------------";

        // Report heading
        System.out.println(line);
        System.out.println("HOME MAKEOVER REPORT");
        System.out.println(line);

        // Column headings
        System.out.printf("%-12s", "");
        for (String type : makeoverTypes) {
            System.out.printf("%-12s", type);
        }
        System.out.println();

        // Print every row (month) and every column (makeover type)
        for (int row = 0; row < makeovers.length; row++) {
            System.out.printf("%-12s", months[row]);
            for (int col = 0; col < makeovers[row].length; col++) {
                System.out.printf("%-12d", makeovers[row][col]);
            }
            System.out.println();
        }

        // Monthly totals section
        System.out.println(line);
        System.out.println("MONTHLY TOTALS");
        System.out.println(line);

        for (int row = 0; row < makeovers.length; row++) {
            // Accumulate the total for this month
            int monthlyTotal = 0;
            for (int col = 0; col < makeovers[row].length; col++) {
                monthlyTotal += makeovers[row][col];
            }

            System.out.printf("%-12s%-8d", months[row], monthlyTotal);

            // Decision: print three stars if the total is 15 or more
            if (monthlyTotal >= STAR_TARGET) {
                System.out.print("***");
            }
            System.out.println();
        }
        System.out.println(line);
    }
}