package domain;

import vo.Chips;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dealer {

    private Map<Player, Deck> map;

    private Deck player1Deck;
    private Deck player2Deck;

    public Dealer() {
        this.player1Deck = new Deck();
        this.player2Deck = new Deck();
    }

    public Chips giveInitChips(int numberOfChips) {
        Chips chips = new Chips(numberOfChips);
        return chips;
    }


}
