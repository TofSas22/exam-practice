package com.mycompany.estateagentreport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Q.1.5 - Unit tests for the EstateAgent class.
 */
public class EstateAgentTest {

    private final EstateAgent estateAgent = new EstateAgent();

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        // Joe Bloggs: 800 000 + 1 500 000 + 2 000 000 = 4 300 000
        double[] joeSales = {800000, 1500000, 2000000};
        assertEquals(4300000, estateAgent.EstateAgentSales(joeSales), 0.01);
    }

    @Test
    public void CalculateTotalCommission_ReturnsCommission() {
        // 2% of 4 300 000 = 86 000
        assertEquals(86000, estateAgent.EstateAgentCommission(4300000), 0.01);
    }

    @Test
    public void TopAgent_ReturnsTopPosition() {
        // Joe (position 0) sold more than Jane (position 1)
        double[] totalSales = {4300000, 3500000};
        assertEquals(0, estateAgent.TopEstateAgent(totalSales));
    }
}