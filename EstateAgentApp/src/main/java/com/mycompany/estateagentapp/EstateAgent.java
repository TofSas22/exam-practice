package com.mycompany.estateagentapp;

/**
 * Calculates estate agent commission and validates the captured data.
 */
public class EstateAgent implements IEstateAgent {

    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission) {
        // The interface passes Strings, so convert them to numbers first
        double price = Double.parseDouble(propertyPrice);
        double percentage = Double.parseDouble(agentCommission);

        // 10 means 10%, so divide by 100
        double commission = price * percentage / 100;

        // Round to 2 decimal places
        return Math.round(commission * 100) / 100.0;
    }

    @Override
    public boolean ValidateData(Data dataToValidate) {
        // Rule 1: Agent location cannot be empty
        if (dataToValidate.getAgentLocation() == null
                || dataToValidate.getAgentLocation().trim().isEmpty()) {
            return false;
        }

        // Rule 2: Agent name cannot be empty
        if (dataToValidate.getAgentName() == null
                || dataToValidate.getAgentName().trim().isEmpty()) {
            return false;
        }

        // Rule 3: Property price cannot be less than or equal to zero
        if (dataToValidate.getPropertyPrice() <= 0) {
            return false;
        }

        // Rule 4: Commission percentage cannot be less than or equal to zero
        if (dataToValidate.getCommissionPercentage() <= 0) {
            return false;
        }

        return true;
    }
}