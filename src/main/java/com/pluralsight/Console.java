package com.pluralsight;

import java.util.Scanner;

public class Console {

    public static final Scanner scanner = new Scanner(System.in);

    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int promptForInt(String prompt) {
        int result = 0;
        System.out.print(prompt);
        result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
}