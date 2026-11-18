package com.mycompany.estateagentreport;

import java.util.Locale;

/**
 * Console application that prints the estate agents sales report.
 */
public class EstateAgentReport {

    public static void main(String[] args) {
        // Q.1.1 - Agent names (single array) and their sales (2D array)
        // Row = agent, column = month (JAN, FEB, MAR)
        String[] agentNames = {"Joe Bloggs", "Jane Doe"};
        String[] months = {"JAN", "FEB", "MAR"};
        double[][] propertySales = {
            {800000, 1500000, 2000000},   // Joe Bloggs
            {700000, 1200000, 1600000}    // Jane Doe
        };

        EstateAgent estateAgent = new EstateAgent();

        // Holds each agent's total so we can find the top agent later
        double[] totalSales = new double[agentNames.length];

        // Report heading and month headings
        System.out.println("ESTATE AGENTS SALES REPORT");
        System.out.println();
        System.out.printf("%-15s", "");
        for (String month : months) {
            System.out.printf("%15s", month);
        }
        System.out.println();
        System.out.println("------------------------------------------------------------");

        // Print each agent's monthly sales (row by row, column by column)
        for (int row = 0; row < propertySales.length; row++) {
            System.out.printf("%-15s", agentNames[row]);
            for (int col = 0; col < propertySales[row].length; col++) {
                System.out.printf("%15s", "R " + propertySales[row][col]);
            }
            System.out.println();
        }
        System.out.println();

        // Q.1.2 - Total property sales for each agent
        for (int row = 0; row < propertySales.length; row++) {
            totalSales[row] = estateAgent.EstateAgentSales(propertySales[row]);
            System.out.printf(Locale.US, "Total property sales for %s = R %,.0f%n",
                    agentNames[row], totalSales[row]);
        }
        System.out.println();

        // Q.1.3 - 2% commission for each agent
        for (int row = 0; row < totalSales.length; row++) {
            double commission = estateAgent.EstateAgentCommission(totalSales[row]);
            System.out.printf(Locale.US, "Sales Commission for %s = R %,.0f%n",
                    agentNames[row], commission);
        }
        System.out.println();

        // Top-performing agent: the method returns a position, which we use to look up the name
        int topAgent = estateAgent.TopEstateAgent(totalSales);
        System.out.println("Top performing estate agent: " + agentNames[topAgent]);
    }
}