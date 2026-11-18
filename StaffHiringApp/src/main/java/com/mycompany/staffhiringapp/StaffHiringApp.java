package com.mycompany.staffhiringapp;

import java.util.Scanner;

public class StaffHiringApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the current staff number: ");
        int staffNumber = input.nextInt();
        input.nextLine(); // Clears the leftover Enter key after nextInt()

        System.out.print("Enter the staff hiring location: ");
        String staffLocation = input.nextLine();

        // Instantiate the subclass and print the report
        StaffHiring staffHiring = new StaffHiring(staffNumber, staffLocation);
        staffHiring.printStaffHiring();

        input.close();
    }
}

