package com.mycompany.exampractice;

/**
 * Interface defining the product sales calculations.
 * Method names follow the exam specification exactly.
 */
public interface IProduct {

    // Returns the sum of all sales in the 2D array
    int TotalSales(int[][] productSales);

    // Returns the average of all sales in the 2D array
    double AverageSales(int[][] productSales);

    // Returns the highest single sale
    int MaxSale(int[][] productSales);

    // Returns the lowest single sale
    int MinSale(int[][] productSales);
}