import java.util.ArrayList;

public class CardGamePlayground {
    public static void main(String[] args){
        CardGame cardGame = new CardGame();
        CardGame.generateCards();
        cardGame.dealCard();
        cardGame.shuffleDeck();

        System.out.println(cardGame.sortDeck());


    }
}
