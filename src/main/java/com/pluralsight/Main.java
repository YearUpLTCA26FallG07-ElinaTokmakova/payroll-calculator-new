package com.pluralsight;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            String selectedFile = Console.promptForString("Enter the name of the file to process: ");
            String createdFile = Console.promptForString("Enter the name of the payroll file to create: ");

            //create a buffer
            BufferedReader bufReader = new BufferedReader(new FileReader("employees.csv"));
            String input;

            //create file writer = open the file
            FileWriter writer = new FileWriter(createdFile + "csv");
            writer.write("id|name|gross pay");

            bufReader.readLine(); //skip first line in employees.csv

            if (selectedFile.contains("employees.csv")) {
                while ((input = bufReader.readLine()) != null) {
                    addInputToFile(input, writer);
                }
            } else { //if entered sth other than "employees.csv"
                System.out.println("File not found. Please try again.");
            }

            bufReader.close();
            writer.close();

            System.out.println(createdFile + ".csv successfully created.");
        }

        catch(IOException e){
                System.out.println("An unexpected error occurred.");
                e.printStackTrace();
        }
    }

    public static void convertInputToEmployee(String input) {
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
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
        }
    }

    public static void addInputToFile(String input, FileWriter writer) {
        try {
            //split each line
            String[] arguments = input.split(Pattern.quote("|"));

            //declare arguments
            int employeeId = Integer.parseInt(arguments[0]);
            String name = arguments[1];
            double hoursWorked = Double.parseDouble(arguments[2]);
            double payRate = Double.parseDouble(arguments[3]);

            //String text
            //for

            //create object
            Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
            writer.write(employee.getEmployeeId() + employee.getName() + employee.getGrossPay());

        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
        }
    }
}
