package domain;

import vo.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final int FIRST = 0;
    private List<Card> deck;

    public Deck() {
        this.deck = initDeck();
        Collections.shuffle(this.deck);
    }

    private List<Card> initDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            deck.add(new Card(i));
            deck.add(new Card(i));
        }

        return deck;
    }

    public Card giveCard(){
        if(this.deck.isEmpty()) throw new IndexOutOfBoundsException("deck is empty.");
        return this.deck.remove(FIRST);
    }

}
