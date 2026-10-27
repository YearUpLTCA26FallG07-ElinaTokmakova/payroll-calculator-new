package com.pluralsight;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            //create a buffer
            BufferedReader bufReader = new BufferedReader(new FileReader("employees.csv"));

            //create an array
            Employee[] employees;
            String input;
            int index = 0;

            while ((input = bufReader.readLine()) != null) {
                String[] inputs = input.split(Pattern.quote("|"));
                // inputs[0] = employees[index].



            }
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
