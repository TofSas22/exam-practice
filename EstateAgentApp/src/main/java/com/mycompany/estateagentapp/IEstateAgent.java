package com.mycompany.estateagentapp;

/**
 * Contract for calculating commission and validating estate agent data.
 */
public interface IEstateAgent {

    double CalculateCommission(String propertyPrice, String agentCommission);

    boolean ValidateData(Data dataToValidate);
}