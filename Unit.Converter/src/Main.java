// Author: Navjot Singh
// Date: May 24, 2024
// Modified: May 24, 2024
// Description: This java program allows user to convert units (inches to metre, pounds to kilograms and
// Celsius to Fahrenheit) based on their selection, providing input validation.


import java.util.*;

public class Main {
    public static void main(String[] args) {
    // Conversion Constants
      final double INCH_TO_METER = 0.0254;
      final double POUND_TO_KILOGRAM = 0.453592;
      final double Celsius_To_FAHRENHEIT = 33.8;

      Scanner input = new Scanner(System.in);
      // Greet the user and display the conversion types option
        System.out.println("Welcome to the Unit Converter");
        System.out.println("Select a conversion type:");
        System.out.println("1. Inch to Meter");
        System.out.println("2. Pound to Kilogram");
        System.out.println("3. Celsius to Fahrenheit");

        // Ask the user to enter their choice
        System.out.println("Enter Your Choice: ");
        int choice = input.nextInt();
        // Ask the user to enter the value for conversion
        System.out.println("Enter the value that you want to convert:");
        double value = input.nextDouble();
        double answer;

        //Based on the user's selection, execute the conversion
        if (choice == 1) {
            answer = value * INCH_TO_METER;
            System.out.printf("%.1f inches is equal to %.1f meters%n",value, answer);
        } else if (choice == 2) {
            answer = value * POUND_TO_KILOGRAM;
            System.out.printf("%.1f pounds is equal to %.1f kilograms%n", value, answer);
        } else if (choice == 3) {
            answer = value * Celsius_To_FAHRENHEIT;
            System.out.printf("%.1f degrees Celsius is equal to %.1f degrees Fahrenheit%n", value, answer);
            // Otherwise, Show Invalid Input
        } else {
            System.out.println("Invalid input. Please check the input");
        }
    }
}