package com.mycompany.staffhiringapp;

/**
 * Subclass of Staff that prints the staff hiring report.
 */
public class StaffHiring extends Staff {

    // Passes the values up to the Staff constructor
    public StaffHiring(int staffNumber, String staffLocation) {
        super(staffNumber, staffLocation);
    }

    // Prints the staff details and whether hiring must start
    @Override
    public void printStaffHiring() {
        System.out.println();
        System.out.println("STAFF HIRING REPORT");
        System.out.println("*******************");
        System.out.println("LOCATION: " + getStaffLocation());
        System.out.println("STAFF NUMBER: " + getStaffNumber());
        System.out.println("HIRE STAFF: " + getStaffHiringProcess());
    }
}