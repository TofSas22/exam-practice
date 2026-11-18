package com.mycompany.exampractice;

/**
 * Performs calculations on product sales data.
 * Implements the IProduct interface.
 */
public class ProductSales implements IProduct {

    // Adds up every sale in the 2D array
    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                total += productSales[year][quarter];
            }
        }
        return total;
    }

    // Divides the total by the number of sales
    @Override
    public double AverageSales(int[][] productSales) {
        int count = 0;
        for (int year = 0; year < productSales.length; year++) {
            count += productSales[year].length;   // number of quarters in this year
        }
        // Reuse TotalSales instead of looping again (avoids redundant code)
        return (double) TotalSales(productSales) / count;
    }

    // Finds the highest sale
    @Override
    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0];   // start with the first value
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                if (productSales[year][quarter] > max) {
                    max = productSales[year][quarter];
                }
            }
        }
        return max;
    }

    // Finds the lowest sale
    @Override
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0];   // start with the first value
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                if (productSales[year][quarter] < min) {
                    min = productSales[year][quarter];
                }
            }
        }
        return min;
    }
}