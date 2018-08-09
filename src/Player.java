import java.util.*;

public class Player {
    public String name;
    public List<Card> hand = new ArrayList<Card>();

    public Player(String name) {
        this.name = name;
    }

    public void emptyHand() {
        hand.clear();
    }

    public void dealCard(Card card) {
        if (hand.size() < 2) {
            hand.add(card);
        }
    }

    public String showHand() {
        String card1 = hand.get(0).rank + hand.get(0).suit;
        String card2 = hand.get(1).rank + hand.get(1).suit;
        return name + ": " + card1 + " " + card2;
    }

}
