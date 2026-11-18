package com.mycompany.staffhiringapp;

/**
 * Abstract base class that stores the staff number and location.
 * It cannot be instantiated directly - only through a subclass.
 */
public abstract class Staff implements iStaff {

    // Hiring starts if a store has fewer staff than this
    public static final int MINIMUM_STAFF = 20;

    private int staffNumber;
    private String staffLocation;

    // Constructor accepts the staff number and location
    public Staff(int staffNumber, String staffLocation) {
        this.staffNumber = staffNumber;
        this.staffLocation = staffLocation;
    }

    @Override
    public int getStaffNumber() {
        return staffNumber;
    }

    @Override
    public String getStaffLocation() {
        return staffLocation;
    }

    // Decides whether hiring must start: YES if fewer than 20 staff
    @Override
    public String getStaffHiringProcess() {
        if (staffNumber < MINIMUM_STAFF) {
            return "YES";
        } else {
            return "NO";
        }
    }

    // Abstract method: every subclass MUST provide its own version
    public abstract void printStaffHiring();
}