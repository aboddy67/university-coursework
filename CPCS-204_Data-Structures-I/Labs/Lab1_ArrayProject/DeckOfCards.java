/* 
Abdulrahman Thigah
*/
package Lab1_ArrayProject;

public class DeckOfCards {
    public static void main(String[] args) {

        //Create an array deck
        int[] deck = new int[52];

        //Create an array of Suits of cards
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};

        //Create an array of rank of cards
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "g", "9", "10", "Jack", "Queen", "King"};

        // Initialize the cards
        for (int i = 0; i < deck.length; i++)
            deck[i] = i;

        // Shuffle the cards
        for (int i = 0; i < deck.length; i++) {

            // Generate an index randomly
            int index = (int) (Math.random() * deck.length);

            //Swap card at index 'i' with card at index 'index'
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }

        // Display the first five cards
        for (int i = 0; i < 5; i++) {
            String suit = suits[deck[i] / 13];
            String rank = ranks[deck[i] % 13];
            System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit);

        }
    }
}
