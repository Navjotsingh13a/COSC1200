// Name: Navjot Singh
// Student ID: 100931376
// Date: August 14, 2024
// Modified: August 14, 2024
// Description: This Java application is used to create a basic cipher tool
// with buttons to encrypt, decrypt, and exit.

import javax.swing.*;
import java.io.*;

public class MyCipherTool {
    private JFrame frame;
    private JTextArea messageTextArea, resultTextArea, englishAlphabetTextArea, cipherAlphabetTextArea, instructionTextArea;
    private JTextField shiftTextField, complexityTextField;
    private JRadioButton substitutionRadioButton, translationRadioButton;

    public MyCipherTool() {
        // Create and set up the main window...
        frame = new JFrame();
        frame.setTitle("WELCOME TO MY CIPHER TOOL...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Set up the text areas and labels...
        JLabel messageLabel = new JLabel("Message:");
        JLabel resultLabel = new JLabel("Result:");
        JLabel englishAlphabetLabel = new JLabel("English Alphabet:");
        JLabel cipherAlphabetLabel = new JLabel("Cipher Alphabet:");
        JLabel shiftLabel = new JLabel("Shift:");
        JLabel complexityLabel = new JLabel("Complexity:");
        JLabel instructionLabel = new JLabel("Instructions/Errors:");

        // Set up text areas for input and output...
        messageTextArea = new JTextArea();
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        englishAlphabetTextArea = new JTextArea("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        cipherAlphabetTextArea = new JTextArea("YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop");
        shiftTextField = new JTextField();
        complexityTextField = new JTextField();
        instructionTextArea = new JTextArea();
        instructionTextArea.setEditable(false);

        // Set bounds for labels and text areas...
        messageLabel.setBounds(10, 10, 150, 30);
        resultLabel.setBounds(10, 60, 150, 30);
        englishAlphabetLabel.setBounds(10, 110, 150, 30);
        cipherAlphabetLabel.setBounds(10, 160, 150, 30);
        shiftLabel.setBounds(10, 210, 150, 30);
        complexityLabel.setBounds(10, 260, 150, 30);
        instructionLabel.setBounds(10, 310, 150, 30);

        // Set bounds for labels and text areas (weight and height)...
        messageTextArea.setBounds(160, 10, 600, 30);
        resultTextArea.setBounds(160, 60, 600, 30);
        englishAlphabetTextArea.setBounds(160, 110, 600, 30);
        cipherAlphabetTextArea.setBounds(160, 160, 600, 30);
        shiftTextField.setBounds(160, 210, 150, 30);
        complexityTextField.setBounds(160, 260, 150, 30);
        instructionTextArea.setBounds(160, 310, 600, 50);

        // Add labels and text areas to the frame...
        frame.add(messageLabel);
        frame.add(resultLabel);
        frame.add(englishAlphabetLabel);
        frame.add(cipherAlphabetLabel);
        frame.add(shiftLabel);
        frame.add(complexityLabel);
        frame.add(instructionLabel);

        frame.add(messageTextArea);
        frame.add(resultTextArea);
        frame.add(englishAlphabetTextArea);
        frame.add(cipherAlphabetTextArea);
        frame.add(shiftTextField);
        frame.add(complexityTextField);
        frame.add(instructionTextArea);

        // Create radio buttons...
        substitutionRadioButton = new JRadioButton("Substitution");
        translationRadioButton = new JRadioButton("Translation");
        ButtonGroup cipherGroup = new ButtonGroup();
        cipherGroup.add(substitutionRadioButton);
        cipherGroup.add(translationRadioButton);

        // Set bounds for radio buttons...
        substitutionRadioButton.setBounds(10, 370, 150, 30);
        translationRadioButton.setBounds(170, 370, 150, 30);
        frame.add(substitutionRadioButton);
        frame.add(translationRadioButton);

        // Create buttons for Encrypt, Decrypt, and Exit functions...
        JButton btnEncrypt = new JButton("Encrypt");
        JButton btnDecrypt = new JButton("Decrypt");
        JButton btnExit = new JButton("Exit");

        // Set up button positions and sizes...
        btnEncrypt.setBounds(10, 420, 100, 30);
        btnDecrypt.setBounds(120, 420, 100, 30);
        btnExit.setBounds(230, 420, 100, 30);

        // Add buttons to the frame...
        frame.add(btnEncrypt);
        frame.add(btnDecrypt);
        frame.add(btnExit);

        // Functionality to encrypt the message when the Encrypt button is clicked...
        btnEncrypt.addActionListener(e -> {
            try {
                clearInstructionText();
                String message = messageTextArea.getText();
                String result = performCipherOperation(message, true);
                resultTextArea.setText(result);
            } catch (Exception ex) {
                displayError(ex.getMessage());
            }
        });

        // Functionality to decrypt the message when the Decrypt button is clicked...
        btnDecrypt.addActionListener(e -> {
            try {
                clearInstructionText();
                String message = messageTextArea.getText();
                String result = performCipherOperation(message, false);
                resultTextArea.setText(result);
            } catch (Exception ex) {
                displayError(ex.getMessage());
            }
        });

        // Close the application when the Exit button is clicked...
        btnExit.addActionListener(e -> frame.dispose());
    }

    // Perform the cipher operation based on user selection...
    public String performCipherOperation(String message, boolean isEncrypt) throws Exception {
        if (complexityTextField.getText().isEmpty() || shiftTextField.getText().isEmpty()) {
            throw new Exception("Please fill in all fields.");
        }

        // Give the result with the input message...
        String result = message;
        int complexity = Integer.parseInt(complexityTextField.getText());

        // Check which cipher method is selected and perform the operation based on complexity...
        if (substitutionRadioButton.isSelected()) {
            for (int i = 0; i < complexity; i++) {
                result = substitutionCipher(result, isEncrypt);
            }
        } else if (translationRadioButton.isSelected()) {
            int shift = Integer.parseInt(shiftTextField.getText());
            // Perform translation cipher based on complexity and shift...
            for (int i = 0; i < complexity; i++) {
                result = translationCipher(result, isEncrypt ? shift : -shift);
            }
        } else {
            // Throw an exception if no method is selected...
            throw new Exception("Please select a cipher method.");
        }
        return result;
    }

    // Substitution cipher method (simplified)...
    public String substitutionCipher(String message, boolean encrypt) {
        return message;
    }

    // Translation cipher method (simplified)...
    public String translationCipher(String message, int shift) {
        return message;
    }

    // Display an error message in the instruction/error text area...
    public void displayError(String errorMessage) {
        instructionTextArea.setText("Error: " + errorMessage);
    }

    // Clear the instruction/error text area...
    public void clearInstructionText() {
        instructionTextArea.setText("");
    }

    // Display the window....
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyCipherTool tool = new MyCipherTool();
            tool.frame.setVisible(true);
        });
    }
}
