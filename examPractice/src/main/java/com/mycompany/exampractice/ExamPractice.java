package com.mycompany.exampractice;

public class ExamPractice {

    public static void main(String[] args) {
        // Set up data
        int[][] productSales = {
            {300, 150, 700}, // year 1
            {250, 200, 600} // year 2
        };

        // 1D label array for reports
        String[] labels = {"Total sales:", "Average sales:", "Maximum sale:", "Minimum sale:"};
        String[] quarters = {"Q1", "Q2", "Q3"};

        // Object that does the calculations
        ProductSales sales = new ProductSales();

        // Store the results in a 1D array so they can be printed in one loop
        long[] results = {
            sales.TotalSales(productSales),
            Math.round(sales.AverageSales(productSales)), // 366.67 -> 367
            sales.MaxSale(productSales),
            sales.MinSale(productSales)
        };

        // ---------- Print heading ----------
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("------------------------------");

        // ---------- Print the sales table (rows and columns) ----------
        System.out.printf("%-10s", "");                 // empty top-left cell
        for (String q : quarters) {
            System.out.printf("%-8s", q);               // column headings
        }
        System.out.println();

        for (int year = 0; year < productSales.length; year++) {
            System.out.printf("%-10s", "Year " + (year + 1));    // row heading
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                System.out.printf("%-8d", productSales[year][quarter]);
            }
            System.out.println();
        }
        System.out.println("------------------------------");

        // ---------- Print the summary ----------
        for (int i = 0; i < labels.length; i++) {
            System.out.printf("%-16s%d%n", labels[i], results[i]);
        }
        System.out.println("------------------------------");
    }
}

