import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CardGame {
    private static ArrayList<Card> cards = new ArrayList<>();
    private static ArrayList<String> symbols = new ArrayList<>();
    final int MAX_NUM = 14;
    final int MIN_NUM = 2;
    public static final Random RANDOM = new Random();
    public static String generateSymbol(int value){
        switch(value) {
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            case 14: return "A";
            default: return String.valueOf(value);
        }
    }
    public static void generateCards() {
        String[] suits = {"hearts", "clubs", "diamonds", "spades"};

        for (int value = 2; value <= 14; value++) {
            String symbol = generateSymbol(value);
            for (String suit : suits) {
                cards.add(new Card(suit, symbol, value));
            }
        }
    }
    public void getDeck() {
        for(Card cards: cards ) {
            System.out.println("Card: " + cards);
        }
    }
    public static void dealCard(){

        System.out.println(cards.get(0));
    }
    public ArrayList<Card> shuffleDeck(){
        generateCards();
        ArrayList<Card> shuffledDeck = new ArrayList<>();

        for(int i=0; i<cards.size(); i++){
            int randomIndex = RANDOM.nextInt(shuffledDeck.size() + 1);
            shuffledDeck.add(randomIndex, cards.get(i));
        }

        return shuffledDeck;
    }
    public ArrayList<Card> sortDeck() {
        ArrayList<Card> sortedDeck = new ArrayList<>(shuffleDeck());

        Collections.sort(sortedDeck, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return Integer.compare(c1.value, c2.value);
            }
        });

        return sortedDeck;
    }
}

