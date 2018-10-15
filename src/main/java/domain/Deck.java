package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Integer> deck;

    private Deck(List<Integer> deck) {
        this.deck = deck;
    }

    public static Deck initDeck() {
        return new Deck(makeDeck());
    }

    private static List<Integer> makeDeck() {
        List<Integer> deck = new ArrayList<>();
        for (int i = 0; i<2; i++ ){
            inputCard(deck);
        }

        Collections.shuffle(deck);
        return deck;
    }

    private static void inputCard(List<Integer> deck) {
        for (int i = 1; i <= 10; i++) {
            deck.add(i);
        }
    }

    public void cardDistribution(Gamer gamer) {
        gamer.getCard(this.deck.remove(0));
    }

}
