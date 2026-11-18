package com.mycompany.productsalesapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Q.2.5 - Unit tests for the ProductSales class.
 */
public class ProductSalesTest {

    private final ProductSales productSales = new ProductSales();

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        // 700 and 600 are above 500
        assertEquals(2, productSales.GetSalesOverLimit());
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        // 300, 150, 250 and 200 are not above 500
        assertEquals(4, productSales.GetSalesUnderLimit());
    }
}