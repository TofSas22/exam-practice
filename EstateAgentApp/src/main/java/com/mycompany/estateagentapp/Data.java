package com.mycompany.estateagentapp;

/**
 * Holds the data captured for one estate agent commission.
 */
public class Data {

    private String agentLocation;
    private String agentName;
    private double propertyPrice;
    private double commissionPercentage;

    // Constructor sets all the captured values
    public Data(String agentLocation, String agentName,
            double propertyPrice, double commissionPercentage) {
        this.agentLocation = agentLocation;
        this.agentName = agentName;
        this.propertyPrice = propertyPrice;
        this.commissionPercentage = commissionPercentage;
    }

    public String getAgentLocation() {
        return agentLocation;
    }

    public String getAgentName() {
        return agentName;
    }

    public double getPropertyPrice() {
        return propertyPrice;
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }
}