import java.util.*;

public class Poker {

    private List<Player> players;
    private Deck deck;
    private List<Card> board = new ArrayList<Card>();
    private Integer pot = 0;
    private Player dealer;

    private Random rand = new Random();

    public Poker(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
    }

    private void showFlop() {
        deck.burnCard();
        board.add(deck.pullCard());
        board.add(deck.pullCard());
        board.add(deck.pullCard());
    }

    private void showTurn() {
        deck.burnCard();
        board.add(deck.pullCard());
    }

    private void showRiver() {
        deck.burnCard();
        board.add(deck.pullCard());
    }

    private void shiftDealer() {
        Player newDealer = players.remove(0);
        players.add(newDealer);
    }

    private void dealHands() {
        for (int i=0; i < 2; i++) {
            for (Player player : players) {
                player.dealCard(deck.pullCard());
            }
        }
    }

    public List<Card> getBoard() {
        return Collections.unmodifiableList(board);
    }

    public void printBoard() {
        String readableBoard = "";
        for (Card card: board) {
            readableBoard += card.rank + card.suit + " ";
        }

        System.out.println("Board:\n" + readableBoard + "\n");
    }

    public void printHands() {
        String readableHands = "";
        for (Player player : players) {
            readableHands += player.showHand() + "\n";
        }

        System.out.println(readableHands);
    }


    public static void main(String[] args) {
        PokerHelper helper = new PokerHelper();

        Player carlos = new Player("Carlos");
        Player joe = new Player("Joe");
        List<Player> players = new ArrayList<Player>(Arrays.asList(carlos, joe));

        Poker game = new Poker(players);

        game.dealHands();
        game.printHands();

        game.showFlop();
        game.showTurn();
        game.showRiver();
        game.printBoard();

        Player winner = helper.calculateWinner(players, game.getBoard());
        System.out.println("Winner: " + winner.name);

        Card card1 = new Card("4", "c");
        Card card2 = new Card("A", "c");
        Card card3 = new Card("10", "c");
        Card card4 = new Card("5", "c");
        Card card5 = new Card("J", "c");
        Card card6 = new Card("2", "d");
        Card card7 = new Card("3", "d");

        System.out.println(helper.pair(new ArrayList<Card>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7))));

    }

}
