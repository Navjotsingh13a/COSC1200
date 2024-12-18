// Author : Navjot Singh
// Date: May 16, 2024

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Conversion constants
        final double D_SCOOP_TO_ML = 120.0;
        final double D_SCOOP_TO_CUP = 0.5;
        final double D_SCOOP_TO_L = 0.12;
        final double D_KIDDIE_TO_SCOOP = 0.5;
        final double D_SMALL_TO_SCOOP = 1.0;
        final double D_MEDIUM_TO_SCOOP = 2.0;
        final double D_LARGE_TO_SCOOP = 3.0;
        final double D_ML_TO_L = 0.001;

        // Accumulators
        int iCountKiddie = 0;
        int iCountSmall = 0;
        int iCountMedium = 0;
        int iCountLarge = 0;

        // Result variables
        Double dCountScoops = 0.0;
        double dCups = 0.0;
        Double dLitres = 0.0;

        // Greet the user
        System.out.println(" Welcome to the Cone Collection Conversion Routine");
        System.out.println("*");
        System.out.println("Stuff that is gonna be done");

        Scanner input = new Scanner(System.in);
        String answer;


        System.out.println("Please enter the number of kiddie cones sold: ");
        if (input.hasNextInt()) {
            iCountKiddie = input.nextInt();
            System.out.println("Please enter the number of small cones sold: ");
            if (input.hasNext()) {
                iCountSmall = input.nextInt();
                System.out.println("Please enter the number of medium cones sold: ");
                if (input.hasNextInt()) {
                    iCountMedium = input.nextInt();
                    System.out.println("Please enter the number of large cones sold: ");
                    iCountLarge = input.nextInt();

                    dCountScoops = (D_KIDDIE_TO_SCOOP * iCountKiddie) +
                            (D_SMALL_TO_SCOOP * iCountSmall) +
                            (D_MEDIUM_TO_SCOOP * iCountMedium) +
                            (D_LARGE_TO_SCOOP * iCountLarge);

                    System.out.println("You need " + dCountScoops.toString() + "Scoops of ice-cream");
                    dLitres = dCountScoops * D_SCOOP_TO_L;
                    System.out.println("Which translates to " + dLitres.toString() + " Litres of ice-cream");
                } else {
                    System.out.println("Sorry - I didn't understand your answer for large cones!");
                }
            } else {
                System.out.println("Sorry - I didn't understand your answer for medium cones!");
            }
        } else {
            System.out.println("Sorry - I didn't understand your answer for small cones!");
        }
        System.out.println(" Do you want to add another values");
        answer = input.next();
    } while(answer.equalsIgnoreCase("yes"));
}








