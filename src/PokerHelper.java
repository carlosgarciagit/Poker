import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public int getScore(List<Card> cards) {
        return 0;
    }
}
