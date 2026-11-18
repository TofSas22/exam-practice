package com.mycompany.estateagentreport;

/**
 * Contract for estate agent sales calculations.
 */
public interface IEstateAgent {

    double EstateAgentSales(double[] propertySales);

    double EstateAgentCommission(double propertySales);

    int TopEstateAgent(double[] totalSales);
}