package com.mycompany.estateagentreport;

/**
 * Calculates estate agent sales, commission and the top-performing agent.
 */
public class EstateAgent implements IEstateAgent {

    // Commission rate of 2%
    public static final double COMMISSION_RATE = 0.02;

    // Adds up all the property sales for ONE agent (one row of the 2D array)
    @Override
    public double EstateAgentSales(double[] propertySales) {
        double total = 0;
        for (double sale : propertySales) {
            total += sale;
        }
        return total;
    }

    // Works out the 2% commission on an agent's total sales
    @Override
    public double EstateAgentCommission(double propertySales) {
        return propertySales * COMMISSION_RATE;
    }

    // Returns the POSITION (index) of the agent with the highest total sales
    @Override
    public int TopEstateAgent(double[] totalSales) {
        int topIndex = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topIndex]) {
                topIndex = i;
            }
        }
        return topIndex;
    }
}