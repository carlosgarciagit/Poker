import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Deck {
    public static List<String> RANKS = new ArrayList<String>(Arrays.asList("A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"));
    public static List<String> SUITS = new ArrayList<String>(Arrays.asList("c", "h", "d", "s"));

    private List<Card> deck = new ArrayList<Card>();

    public Deck() {
        populateDeck();
        shuffleDeck();
    }

    private void populateDeck() {
        deck.clear();

        for (String rank : RANKS) {
            for (String suit : SUITS) {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
    }

    public void shuffleDeck() {
        populateDeck();
        Collections.shuffle(deck);
    }

    public Card pullCard() {
        return deck.remove(0);
    }

    public void burnCard() {
        deck.remove(0);
    }

}
