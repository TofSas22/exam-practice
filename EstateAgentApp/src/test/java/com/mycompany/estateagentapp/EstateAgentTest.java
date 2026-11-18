package com.mycompany.estateagentapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

/**
 * Q.2.8 - Unit tests for the EstateAgent class.
 */
public class EstateAgentTest {

    private final EstateAgent estateAgent = new EstateAgent();

    @Test
    public void CalculateCommission_CalculatedSuccessfully() {
        // 10% of R800 000 = R80 000
        double result = estateAgent.CalculateCommission("800000", "10");
        assertEquals(80000.0, result, 0.01);
    }

    @Test
    public void CalculateCommission_CalculatedUnSuccessfully() {
        // 800 000 x 10 = 8 000 000 is the wrong answer you get if you forget to
        // divide by 100. The method must NOT return that value.
        double result = estateAgent.CalculateCommission("800000", "10");
        assertNotEquals(8000000.0, result, 0.01);
    }

    @Test
    public void ValidateData_EmptyAgentName_ReturnsFalse() {
        // An empty name breaks the rule "Agent Name cannot be empty"
        Data data = new Data("Cape Town", "", 800000, 10);
        assertFalse(estateAgent.ValidateData(data));
    }
}