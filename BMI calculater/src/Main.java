// Author: Navjot Singh
//Date: May 31, 2025
//Modified: May 31, 2025
//Description: This java program calculates BMI based on the user input for height and weight,
// categorize BMI, with an option to exit at any time

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double Height_Inches = 0;
        double Weight_Pound = 0;
        double Conversion_Factor = 703;

        // Loop for validating height input
        System.out.print("Please enter your height in inches, between 24 and 120: ");
        while (Height_Inches < 24 || Height_Inches > 120) {
            if (scanner.hasNextDouble()) {
                Height_Inches = scanner.nextDouble();
                if (Height_Inches >= 24 & Height_Inches <= 120) {
                    // Exit loop if valid input
                    break;
                }
                System.out.println("The required height ranges is from 24 to 120 inches.");
            } else {
                System.out.println("Please enter a numeric value.");
                scanner.next();
            }
            System.out.print("Please enter a height in inches between 24 and 120. ");
        }
        // Loop for validating weight input
        System.out.print("Enter your weight which would be minimum 25 pounds: ");
        while (Weight_Pound < 25) {
            if (scanner.hasNextDouble()) {
                Weight_Pound = scanner.nextDouble();
                if (Weight_Pound >= 25) {
                    // Exit loop if valid input
                    break;
                }
                System.out.println("A minimum weight of 25 pounds is required.");
            } else {
                // Write an error message
                System.out.println("Please enter a numeric value.");
                scanner.next();
            }
            System.out.print("Please provide a weight in pounds, with a minimum of 25 pounds. ");
        }

        // Calculating BMI using the formula:
        double bmi = (Weight_Pound / (Height_Inches * Height_Inches)) * Conversion_Factor;

        // Using the BMI values to determine the category
        String category ="";
        if (bmi < 16) {
            category = "severely underweight";
        } else if (bmi < 18.5) {
            category = "underweight";
        } else if (bmi < 25) {
            category = "healthy";
        } else if (bmi < 30) {
            category = "overweight";
        } else {
            category = "obese";
        }

        // Displaying BMI and categories.
        System.out.printf("Your BMI is %.1f, which comes in the category of %s.\n", bmi, category);
        System.out.println("Thank you for using BMI calculator");
        scanner.close();
    }
}
