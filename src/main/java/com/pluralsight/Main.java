package com.pluralsight;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            //create a buffer
            BufferedReader bufReader = new BufferedReader(new FileReader("employees.csv"));

            //create an array
            String input;

            bufReader.readLine();

            while ((input = bufReader.readLine()) != null) {
                 convertInputToEmployee(input);
            }
        }

        catch (IOException e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    public static void convertInputToEmployee (String input) {
        try {
            //split each line
            String[] arguments = input.split(Pattern.quote("|"));

            //declare arguments
            int employeeId = Integer.parseInt(arguments[0]);
            String name = arguments[1];
            double hoursWorked = Double.parseDouble(arguments[2]);
            double payRate = Double.parseDouble(arguments[3]);

            Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

            //output
            System.out.printf("%nEmployee with id %d %s got paid $%.2f.", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
        }

        catch (Exception e) {
            System.out.println("An unexpected error occurred.");
        }
    }
}
