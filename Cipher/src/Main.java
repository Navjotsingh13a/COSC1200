// Name: Navjot Singh
// Date: June 10, 2024
// Modified: June 10, 2024
// Description: This java program allows user to encrypt or decrypt phrases
// using substitution and Translation ciphers repetitions, until the user not
// choose to exit.

import java.util.*;

public class Main {
    //  String Constants
    public static final String ENGLISH_ALPHABETS =
            "A" + "B" + "C" + "D" + "E" + "F" + "G" + "H" + "I" + "J" + "K" + "L" + "M" +
                    "N" + "O" + "P" + "Q" + "R" + "S" + "T" + "U" + "V" + "W" + "X" + "Y" + "Z" +
                    "a" + "b" + "c" + "d" + "e" + "f" + "g" + "h" + "i" + "j" + "k" + "l" + "m" +
                    "n" + "o" + "p" + "q" + "r" + "s" + "t" + "u" + "v" + "w" + "x" + "y" + "z";

    public static final String COSC1200_ALPHABETS =
            "Y" + "W" + "L" + "R" + "A" + "S" + "K" + "T" + "E" + "Z" + "G" + "M" + "V" +
                    "H" + "Q" + "B" + "X" + "N" + "C" + "D" + "I" + "J" + "F" + "U" + "O" + "P" +
                    "y" + "w" + "l" + "r" + "a" + "s" + "k" + "t" + "e" + "z" + "g" + "m" + "v" +
                    "h" + "q" + "b" + "x" + "n" + "c" + "d" + "i" + "j" + "f" + "u" + "o" + "p";
    public static void main(String[] args) {
        // Creating a Scanner for input of the user
        Scanner input = new Scanner(System.in);

        // Greet the user
        System.out.println("Welcome to the Cipher program!");

        // While loop to repeatedly perform encryption or decryption.
        while (true) {
            System.out.println("Select mode: (1) for Encrypt (2) for Decrypt");
            String mode = input.next();

            // Validating the cipher selection input.
            if (!mode.equals("1") && !mode.equals("2")) {
                System.out.println("Invalid mode. Please enter 1 for Encrypt or 2 for Decrypt.");
                continue;
            }
            // Ask the user to enter the phrase
            System.out.println("Please Enter the phrase:");
            String phrase = input.next();

            //Ask the user to select the cipher method
            System.out.println("Select cipher: (1) for Substitution (2) for Translation");
            String cipherSelection = input.next();

            if (!cipherSelection.equals("1") && !cipherSelection.equals("2")) {
                System.out.println("Invalid cipher selection. Please enter 1 for Substitution or 2 for Translation.");
                // restarting the loop if the input is invalid by the user.
                continue;
            }

            // Ask the user to enter the complexity key
            System.out.println("Enter the complexity key (number of repetitions):");
            int complexityKey;
            try {
                // Convert the input into integers.
                complexityKey = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid complexity key. Please enter a valid integer.");
                continue;
            }

            String answer = phrase;
            for (int i = 0; i < complexityKey; i++) {
                if (cipherSelection.equals("1")) {
                    // Perform substitution cipher based on user's selection.
                    answer = substitutionCipher(answer, mode.equals("1"));
                } else {
                    // Ask the user to enter the shift number for translation.
                    System.out.println("Please Enter the shift number:");
                    int shiftNumber;
                    try {
                        // Convert the input into integers.
                        shiftNumber = Integer.parseInt(input.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid shift value. Please enter a valid number.");
                        continue;
                    }
                    // if the mode is 1 for encryption,the character is shifted forward with shift number, otherwise shifted backward
                    answer = translationCipher(answer, mode.equals("1") ? shiftNumber : -shiftNumber);
                }
            }

            // Print the result
            System.out.println("Result: " + answer);

            System.out.println("Do you want to continue thee program? (Yes/No)");
            String user_input = input.next();
            if (!user_input.equalsIgnoreCase("Yes")) {
                break;
            }
        }
        // greet at the end.
        System.out.println("Very Very Thank you for using cipher program.");
    }

    // Method of substitution cipher.
    public static String substitutionCipher(String phrase, boolean encrypt) {
        StringBuilder answer = new StringBuilder();
        // Two String Variables.
        String fromAlphabet;
        String toAlphabet;
        
        if (encrypt) {
            fromAlphabet = ENGLISH_ALPHABETS;
            toAlphabet = COSC1200_ALPHABETS;
        } else {
            fromAlphabet = COSC1200_ALPHABETS;
            toAlphabet = ENGLISH_ALPHABETS;
        }

        // Iterate through each character(C) in the phrase
        for (char C : phrase.toCharArray()) {
            int index = fromAlphabet.indexOf(C);
            // Substituting the character if found in Alphabets
            if (index != -1) {
                answer.append(toAlphabet.charAt(index));
            } else {
                answer.append(C);
            }
        }
        // return the encrypted or decrypted answer
        return answer.toString();
    }

    // Method of Translation cipher.
    public static String translationCipher(String phrase, int shift) {
        StringBuilder answer = new StringBuilder();

        // Iterate through each character in the phrase
        for (char C : phrase.toCharArray()) {
            // Check if the character is letter.
            if (Character.isLetter(C)) {
                // Determine the base character (a for lower case and A for Upper Case.)
                char base;
                if (Character.isUpperCase(C)) {
                    base = 'A';
                } else {
                    base = 'a';
                }
                // calculate the new character correspondence to the position of character.
                int offset = (C - base + shift + 26) % 26;
                answer.append((char) (base + offset));
            } else {
                answer.append(C);
            }
        }
        // return the encrypted or decrypted answer.
        return answer.toString();
    }
}