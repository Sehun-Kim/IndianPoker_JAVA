package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void giveCard() {
        deck.giveCard();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void giveCardWithException() {
        while(true){
            deck.giveCard();
        }
    }


}