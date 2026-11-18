package com.mycompany.productsalesapp;

/**
 * Holds the product sales data in memory and performs all calculations.
 */
public class ProductSales implements IProductSales {

    // The retailer's sales limit used to judge whether a product was successful
    public static final int SALES_LIMIT = 500;

    // Rows = years, columns = products (Microphone, Speakers, Mixing Desk)
    private final int[][] productSales = {
        {300, 150, 700},   // Year 1
        {250, 200, 600}    // Year 2
    };

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        // Loop through every year (row) and every product (column)
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale <= SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int GetProductsProcessed() {
        // Number of rows = number of years processed
        return productSales.length;
    }

    @Override
    public double GetAverageSales() {
        int numberOfSales = 0;
        for (int[] year : productSales) {
            numberOfSales += year.length;
        }
        // Cast to double so we don't lose the decimal part
        return (double) GetTotalSales() / numberOfSales;
    }
}