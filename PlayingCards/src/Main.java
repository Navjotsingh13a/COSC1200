import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Greet the user
        System.out.println("Welcome to BlackJack");
        System.out.println("**********************");

        try {
            // Initialize and report dealer hand
            Hand dealerHand = new Hand(2);
            dealerHand.flipCard(0);
            System.out.println("Dealer: " + dealerHand);

            // Initialize and report player hand
            Hand playerHand = new Hand(2);
            System.out.println("Player: " + playerHand);

            // Allow the user to add cards to the player hand until bust
            char draw = 'Y';
            while (playerHand.getValue() < 22 && (draw == 'y' || draw == 'Y')) {
                draw = Validation.getValidCharacter("Do you want another card (y/n)?: ", "YNyn");
                if (draw == 'y' || draw == 'Y') {
                    playerHand.addCard(1);
                    System.out.println("Player: " + playerHand);
                }
            }

            // Automatically complete the dealer hand
            dealerHand.flipCard(0);
            while (dealerHand.getValue() < 16) {
                dealerHand.addCard(1);
            }
            System.out.println("Dealer: " + dealerHand);

            // Determine winner
            if (playerHand.getValue() < 22) {
                if (dealerHand.getValue() > 21 || dealerHand.getValue() < playerHand.getValue()) {
                    System.out.println("Congratulations! Player wins");
                } else {
                    System.out.println("Sorry. Dealer wins");
                }
            } else if (dealerHand.getValue() > 21) {
                System.out.println("No winner.");
            } else {
                System.out.println("Sorry. Dealer wins");
            }

        } catch (Exception ex) {
            System.out.println("Sorry - " + ex.getMessage());
        }
    }
}

class PlayingCard {
    private int rank;
    private int suit;
    public boolean faceUp;

    static private String[] rankNames = {"FaceDown", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    static private String[] rankChars = {"", "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
    static private String[] suitNames = {"FaceDown", "Hearts", "Clubs", "Diamonds", "Spades"};
    static private String[] suitChars = {"", "H", "C", "D", "S"};
    static private String[] suitSymbols = {"", "♥", "♣", "♦", "♠"};
    static private int[] cardValue = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    // Constructors
    PlayingCard() {
        rank = 1 + (int) (Math.random() * 12);
        suit = 1 + (int) (Math.random() * 3);
        faceUp = true;
    }

    PlayingCard(int newRank, int newSuit, boolean isFaceUp) {
        setRank(newRank);
        setSuit(newSuit);
        faceUp = isFaceUp;
    }

    // Accessors
    public int getRank() {
        return faceUp ? rank : 0;
    }

    public int getValue() {
        return faceUp ? cardValue[rank] : 0;
    }

    public int getSuit() {
        return faceUp ? suit : 0;
    }

    public String toString() {
        return faceUp ? rankNames[getRank()] + " of " + suitNames[getSuit()] : "Face Down";
    }

    public String toString(int mode) {
        if (!faceUp) return "??";
        switch (mode) {
            case 1: return rankChars[getRank()] + " of " + suitChars[getSuit()];
            case 2: return rankChars[getRank()] + suitSymbols[getSuit()];
            default: return rankChars[getRank()] + suitNames[getSuit()];
        }
    }

    // Mutators
    public void flipCard() {
        faceUp = !faceUp;
    }

    public void setRank(int newRank) {
        if (newRank > 0 && newRank < 14) {
            rank = newRank;
        } else {
            throw new IllegalArgumentException("Rank must be between 1 and 13");
        }
    }

    public void setSuit(int newSuit) {
        if (newSuit >= 1 && newSuit <= 4) {
            suit = newSuit;
        } else {
            throw new IllegalArgumentException("Suit must be between 1 and 4");
        }
    }
}

class Validation {
    public static char getValidCharacter(String prompt, String letters) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        String userInput = input.next();
        while (userInput.length() != 1 || !letters.contains(userInput)) {
            System.out.println("That's not a valid option. Please try again.");
            System.out.print(prompt);
            userInput = input.next();
        }
        return userInput.charAt(0);
    }
}

class Hand {
    private ArrayList<PlayingCard> cards = new ArrayList<>();

    // Constructors
    public Hand() {
    }

    public Hand(int numCards) {
        for (int i = 0; i < numCards; i++) {
            addCard(1);
        }
    }

    // Mutators
    public void addCard(int newCards) {
        for (int i = 0; i < newCards; i++) {
            cards.add(new PlayingCard());
        }
    }

    public void flipCard(int index) {
        if (index >= 0 && index < cards.size()) {
            cards.get(index).flipCard();
        }
    }

    // Accessors
    public int getValue() {
        int value = 0;
        int aceCount = 0;
        for (PlayingCard card : cards) {
            if (card.getValue() == 1) aceCount++;
            value += card.getValue();
        }
        while (value < 12 && aceCount > 0) {
            value += 10;
            aceCount--;
        }
        return value;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PlayingCard card : cards) {
            result.append(card.toString(2)).append(" ");
        }
        result.append("(").append(getValue()).append(")");
        return result.toString();
    }
}
