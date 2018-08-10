import java.util.*;

public class PokerHelper {
    private static Map<String, Integer> RANK_WEIGHTS = new HashMap<String, Integer>();

    public PokerHelper() {
        populateRankWeights();
    }

    private void populateRankWeights() {
        RANK_WEIGHTS.put("A", 14);
        RANK_WEIGHTS.put("K", 13);
        RANK_WEIGHTS.put("Q", 12);
        RANK_WEIGHTS.put("J", 11);
        RANK_WEIGHTS.put("T", 10);
    }

    public Player calculateWinner(List<Player> players, List<Card> board) {
        int score;
        int topScore = 0;
        Player topPlayer = null;

        for (Player player : players) {
            List<Card> cards = new ArrayList<Card>();
            cards.addAll(player.hand);
            cards.addAll(board);

            score = getScore(cards);
            if (topPlayer == null || score > topScore) {
                topScore = score;
                topPlayer = player;
            }
        }

        return topPlayer;

    }

    public boolean fourOfAKind(List<Card> cards) {
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (Card card : cards) {
            if (counts.containsKey(card.rank)) {
                counts.put(card.rank, counts.get(card.rank) + 1);
            }
        }

        if (counts.containsValue(4)) {
            return true;
        }
        return false;
    }

    public boolean fullHouse(List<Card> cards) {
        return threeOfAKind(cards) && pair(cards);
    }

    public boolean flush(List<Card> cards) {
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (Card card : cards) {
            if (counts.containsKey(card.suit)) {
                counts.put(card.suit, counts.get(card.suit) + 1);
            } else {
                counts.put(card.suit, 1);
            }
        }

        for (int value : counts.values()) {
            if (value >= 5) {
                return true;
            }
        }
        return false;
    }

    public boolean straight(List<Card> cards) {

        List<Integer> intCards = convertHandToInts(cards);

        Set<Integer> set = new HashSet<Integer>(intCards);
        List<Integer> sorted = new ArrayList<Integer>(set);
        Collections.sort(sorted);

        if (sorted.containsAll(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 14)))){
            return true;
        } else if (sorted.size() < 5) {
            return false;
        } else {
            int count = 1;
            int next = sorted.get(0);
            for (int rank : sorted) {
                int value = rank;
                if (value != next) {
                    count = 1;
                }
                next = value + 1;

                if (count == 5) {
                    return true;
                }
                count += 1;

            }
            return false;
        }
    }


    public boolean threeOfAKind(List<Card> cards) {
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (Card card : cards) {
            if (counts.containsKey(card.rank)) {
                counts.put(card.rank, counts.get(card.rank) + 1);
            } else {
                counts.put(card.rank, 1);
            }
        }

        if (counts.containsValue(3)) {
            return true;
        }
        return false;
    }

    public boolean twoPair(List<Card> cards) {
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (Card card : cards) {
            if (counts.containsKey(card.rank)) {
                counts.put(card.rank, counts.get(card.rank) + 1);
            } else {
                counts.put(card.rank, 1);
            }
        }
        boolean onePair = false;
        for (int count : counts.values()) {
            if (count == 2 && !onePair) {
                onePair = true;
            } else if (count == 2 && onePair) {
                return true;
            }
        }
        return false;
    }

    public boolean pair(List<Card> cards) {
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (Card card : cards) {
            if (counts.containsKey(card.rank)) {
                counts.put(card.rank, counts.get(card.rank) + 1);
            } else {
                counts.put(card.rank, 1);
            }
        }

        if (counts.containsValue(2)) {
            return true;
        }
        return false;
    }

    private List<Integer> convertHandToInts(List<Card> cards) {
        List<Integer> cardInts = new ArrayList<Integer>();

        for (Card card : cards) {
            try {
                cardInts.add(Integer.parseInt(card.rank));
            } catch (Exception ex) {
                cardInts.add(RANK_WEIGHTS.get(card.rank));
            }
        }

            return cardInts;
    }

    public int getScore(List<Card> cards) {

        int score = 0;

        List<Integer> cardInts = convertHandToInts(cards);
        Collections.sort(cardInts);

        if (straight(cards) && flush(cards)) {

        }
        else if (fourOfAKind(cards)) {

        }
        else if (fullHouse(cards)) {

        }
        else if (flush(cards)) {

        }
        else if (straight(cards)) {

        }
        else if (threeOfAKind(cards)) {

        }
        else if (twoPair(cards)) {

        }
        else if (pair(cards)) {

        }

        //add high card score
        return 0;
    }
}
